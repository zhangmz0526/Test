package com.example.druidtest.service;

import com.example.druidtest.entity.User;

import java.util.List;
import java.util.Map;
public interface UsersService {

    List<Map<String,Object>> getUser(Integer id);
    List<Map<String,Object>> getUserList();
    String postUser(User user);
    String putUser(Integer id, User user);
    String deleteUser(Integer id);
}
