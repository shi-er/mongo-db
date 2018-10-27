package com.shier.mongo.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String address;
    private Integer sex;

}
