package com.filestore.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filestore.assignment.entity.AssignmentData;
import com.filestore.assignment.repository.DataStoreRepository;
import com.filestore.assignment.service.DataStoreService;

@Service
public class DataStoreServiceImpl implements DataStoreService {

	@Autowired
	private DataStoreRepository dataStoreRepository;

	@Override
	public synchronized AssignmentData create(AssignmentData assignmentData) {

		AssignmentData assignmentDataObj = dataStoreRepository.findByKey(assignmentData.getKey());
		if (assignmentDataObj != null) {
			throw new RuntimeException("Value for the " + assignmentData.getKey() + " already exists");
		}
		assignmentData = dataStoreRepository.insert(assignmentData);
		return assignmentData;
	}

	@Override
	public AssignmentData read(String key) {
		return dataStoreRepository.findByKey(key);

	}

	@Override
	public AssignmentData delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
