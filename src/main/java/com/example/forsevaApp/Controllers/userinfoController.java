package com.example.forsevaApp.Controllers;


import com.example.forsevaApp.Entity.JobRequests;
import com.example.forsevaApp.Entity.UserInfo;
import com.example.forsevaApp.Entity.WorkerInfo;
import com.example.forsevaApp.Service.UserInfoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userinfoController {

    @Autowired
    private UserInfoService userInfoService;



    @GetMapping
    public List<UserInfo> getall(){

        return null;
    }

    @PostMapping
    public UserInfo createuser(@RequestBody UserInfo myinfo){
        myinfo.setDatecreate(LocalDateTime.now());
        userInfoService.saveInfo(myinfo);
        return myinfo;
    }

    @GetMapping("id/{userid}")
    public UserInfo getuserbyid(@PathVariable ObjectId workerid){

        return userInfoService.findbyid(workerid).orElse(null);
    }

    @PostMapping("/CreateReq")
    public JobRequests createRequest(@RequestBody JobRequests jobRequests){
        jobRequests.setCreatedAt(LocalDateTime.now());
        userInfoService.saveRequest(jobRequests);
        return jobRequests;
    }

    @GetMapping("/JobRequests/id/{userid}")
    public List<JobRequests> getRequests(@PathVariable String userid){

        return userInfoService.gellRequest(userid);
    }
}
