package com.filestore.assignment.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filestore.assignment.dto.ValueDTO;
import com.filestore.assignment.entity.AssignmentData;
import com.filestore.assignment.repository.DataStoreRepository;
import com.filestore.assignment.service.DataStoreService;

@Service
public class DataStoreServiceImpl implements DataStoreService {

	@Autowired
	private DataStoreRepository dataStoreRepository;

	@Value("${data-store.time-to-live}")
	private Integer TTL;

	@Autowired
	ObjectMapper objectMapper;

	@SuppressWarnings("unchecked")
	@Override
	public AssignmentData create(JSONObject jsonObject) {
		AssignmentData requestObj = null;
		while (jsonObject.keys().hasNext()) {
			Object object = jsonObject.keys().next();
			requestObj = new AssignmentData();
			requestObj.setKey(object.toString());
			try {
				requestObj.setValue(jsonObject.get((String) object));
				break;
			} catch (JSONException e) {
				throw new RuntimeException("JSON exception occured while mapping");
			}

		}

		AssignmentData assignmentDataObj = dataStoreRepository.findByKey(requestObj.getKey());
		if (assignmentDataObj != null) {
			throw new RuntimeException("Value for the " + requestObj.getKey() + " already exists");
		}
		requestObj.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
		requestObj = dataStoreRepository.insert(requestObj);
		return requestObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.filestore.assignment.service.DataStoreService#read(java.lang.String)
	 */
	@Override
	public ValueDTO read(String key) {
		ValueDTO valueDTO = new ValueDTO();
		AssignmentData assignmentData = findByKey(key);
		isExpired(assignmentData);
		valueDTO.setValue(assignmentData.getValue());
		return valueDTO;

	}

	private void isExpired(AssignmentData assignmentData) {
		Duration diff = Duration.between(assignmentData.getCreatedAt(), LocalDateTime.now(ZoneOffset.UTC));
		System.out.println(diff.getSeconds());
		if (diff.getSeconds() > TTL) {
			throw new RuntimeException("Key expired cannot be read or deleted");
		}
	}

	@Override
	public String delete(String key) {
		AssignmentData assignmentData = findByKey(key);
		isExpired(assignmentData);
		try {
			dataStoreRepository.delete(assignmentData);
		} catch (IllegalArgumentException ex) {
			throw new RuntimeException("Exception occured while deleting data cause::" + ex.getCause());
		}
		return "Successfully deleted";
	}

	private AssignmentData findByKey(String key) {
		AssignmentData assignmentData = dataStoreRepository.findByKey(key);
		if (assignmentData == null) {
			throw new RuntimeException("Data not found for the given key");
		}

		return assignmentData;
	}

}
