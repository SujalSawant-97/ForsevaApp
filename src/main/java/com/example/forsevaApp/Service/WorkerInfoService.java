package com.example.forsevaApp.Service;

import com.example.forsevaApp.Entity.UserInfo;
import com.example.forsevaApp.Entity.WorkerInfo;
import com.example.forsevaApp.Repository.WorkerInfoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerInfoService {

    @Autowired
    private WorkerInfoRepository workerInfoRepository;

    public void saveInfo(WorkerInfo workerInfo){

        workerInfoRepository.save(workerInfo);
    }

    public Optional<WorkerInfo> findbyid(ObjectId workerid){
        return workerInfoRepository.findById(workerid);

    }

    public List<WorkerInfo> getWorkersInRange(double userLat, double userLon, double radiusKm, String skill) {
        try {
            // Create a Point for the user's location
            //GeoJsonPoint userLocation = new GeoJsonPoint(userLon, userLat);
            double radiusInMeters = radiusKm * 1000;

            // Define the distance for the radius
            //Distance distance = new Distance(radiusKm, Metrics.KILOMETERS);
            //Point userLocation = new Point(userLon, userLat);
            return workerInfoRepository.findByWorkerDetailsSkillsAndLocationNear(skill,userLat, userLon, radiusInMeters);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching workers: " + e.getMessage());
        }
    }
}

