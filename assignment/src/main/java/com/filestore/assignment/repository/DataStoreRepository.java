package com.filestore.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.filestore.assignment.entity.AssignmentData;

/**
 * The Interface DataStoreRepository.
 * 
 * @author Srinivasan
 */
public interface DataStoreRepository extends MongoRepository<AssignmentData, String> {

	AssignmentData findByKey(String key);
}
