package com.example.forsevaApp.Repository;

import com.example.forsevaApp.Entity.JobRequests;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface JobRequestRepository extends MongoRepository<JobRequests, ObjectId>{

    @Query("{ 'userId': ?0 }")
    List<JobRequests> findJobsByUserId(String userId);

}
