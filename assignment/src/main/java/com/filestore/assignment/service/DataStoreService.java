package com.filestore.assignment.service;

import com.filestore.assignment.dto.ValueDTO;
import com.filestore.assignment.entity.AssignmentData;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataStoreService.
 */
public interface DataStoreService {

	/**
	 * Creates key-value.
	 *
	 * @param assignmentData the assignment data
	 * @return {@link AssignmentData} the assignment data
	 */
	public AssignmentData create (AssignmentData assignmentData);
	
	/**
	 * Read.
	 *
	 * @return the assignment data
	 */
	public ValueDTO read(String key);
	
	/**
	 * Delete.
	 *
	 * @return the assignment data
	 */
	public String delete(String key);
	
}
