package com.example.forsevaApp.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.*;


@Data
@Document(collection = "User_info")
public class UserInfo {


    @Id
    private Object userid;
    private String email;
    private String phone;
    private Map<String, Object> address;
    private LocalDateTime datecreate;
    private LocalDateTime dateupdate;

}
