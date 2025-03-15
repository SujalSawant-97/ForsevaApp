package com.example.forsevaApp.Service;

import com.example.forsevaApp.Entity.JobRequests;
import com.example.forsevaApp.Entity.UserInfo;
import com.example.forsevaApp.Entity.WorkerInfo;
import com.example.forsevaApp.Repository.JobRequestRepository;
import com.example.forsevaApp.Repository.UserInfoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    private JobRequestRepository jobRequestRepository;

    public void saveInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    public Optional<UserInfo> findbyid(ObjectId userid){
        return userInfoRepository.findById(userid);

    }
    public  void saveRequest(JobRequests jobRequests){
        jobRequestRepository.save(jobRequests);
    }

    public List<JobRequests> gellRequest(String userid){
    return jobRequestRepository.findJobsByUserId(userid);
    }

}
