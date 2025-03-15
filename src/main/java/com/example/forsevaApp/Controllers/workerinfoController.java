package com.example.forsevaApp.Controllers;


import com.example.forsevaApp.Entity.WorkerInfo;
import com.example.forsevaApp.Service.WorkerInfoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/worker")
public class workerinfoController {

    @Autowired
    private WorkerInfoService workerInfoService;

    @PostMapping
    public ResponseEntity<WorkerInfo> createworker(@RequestBody WorkerInfo workerInfo){
        try {
            workerInfo.setDatecreate(LocalDateTime.now());
            workerInfoService.saveInfo(workerInfo);
            return new ResponseEntity<>(workerInfo,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("id/{workerid}")
    public ResponseEntity<?> getworkerbyid(@PathVariable ObjectId workerid){
        Optional<WorkerInfo> workerInfo=workerInfoService.findbyid(workerid);
        if(workerInfo.isPresent()){
            return new ResponseEntity<>(workerInfo.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/workerbyloc")
    public List<WorkerInfo> getWorkersInRange(
            @RequestParam double userLat,
            @RequestParam double userLon,
            @RequestParam(defaultValue = "10") double radiusKm,
            @RequestParam String skill) {
     try {
         return workerInfoService.getWorkersInRange(userLat, userLon, radiusKm, skill);
     }catch (Exception e) {
         e.printStackTrace();
         throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching workers", e);
     }
    }


}
