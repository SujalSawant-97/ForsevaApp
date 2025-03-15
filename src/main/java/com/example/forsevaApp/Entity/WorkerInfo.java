package com.example.forsevaApp.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class WorkerInfo {

    @Id
    private String workerid;
    private String email;
    private String phone;
    private Map<String,Object> address;
    private Map<String,Object> workersdetail;
    private WorkerDetails workerDetails;
    private GeoJsonPoint location;
    private LocalDateTime datecreate;
    private LocalDateTime dateupdate;


}
