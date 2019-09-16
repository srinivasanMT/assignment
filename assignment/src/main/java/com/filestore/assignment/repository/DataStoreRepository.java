package com.filestore.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.filestore.assignment.entity.AssignmentData;

/**
 * The Interface DataStoreRepository.
 * 
 * @author Srinivasan
 */
@Repository
public interface DataStoreRepository extends MongoRepository<AssignmentData, String> {

	AssignmentData findByKey(String key);
}
