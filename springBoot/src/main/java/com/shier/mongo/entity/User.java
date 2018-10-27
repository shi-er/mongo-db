package com.shier.mongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //@id这个注解来对应mongo的_id这个字段
    @Id
    private String _id;
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(String _id, int id, String name, int age) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
