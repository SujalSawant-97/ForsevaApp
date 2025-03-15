package com.example.forsevaApp.Repository;

import com.example.forsevaApp.Entity.WorkerInfo;
import org.bson.types.ObjectId;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WorkerInfoRepository extends MongoRepository<WorkerInfo, ObjectId> {
    @Query("{'workerDetails.skills': ?0, 'location': { $near: { $geometry: { type: 'Point', coordinates: [?1, ?2] }, $maxDistance: ?3 } }}")
    List<WorkerInfo> findByWorkerDetailsSkillsAndLocationNear(
            String skill, double longitude, double latitude, double maxDistance);
}
