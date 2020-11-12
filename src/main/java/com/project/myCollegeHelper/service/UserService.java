package com.project.myCollegeHelper.service;

import com.project.myCollegeHelper.entity.User;

public interface UserService {
    void insertUser(User user);
    boolean userSessionExists(String sessionId);
}
