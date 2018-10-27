package com.shier.mongo.service;

import com.shier.mongo.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User getUser(Integer id);

    void update(User user);

    void insert(User user);

    void insertAll(List<User> users);

    void remove(Integer id);

    List<User> findByPage(User user, Pageable pageable);
}
