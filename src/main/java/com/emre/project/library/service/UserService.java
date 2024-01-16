package com.emre.project.library.service;

import com.emre.project.library.repo.user.SystemUser;

import java.util.Optional;

public interface UserService {
    Optional<SystemUser> getByUsernameAndPassword(String username, String password);
    void createUser(SystemUser user);
    void deleteUser(Integer userId);
}
