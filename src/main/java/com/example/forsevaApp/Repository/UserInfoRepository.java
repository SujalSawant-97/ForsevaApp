package com.example.forsevaApp.Repository;


import com.example.forsevaApp.Entity.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserInfoRepository extends MongoRepository<UserInfo, ObjectId> {
}
