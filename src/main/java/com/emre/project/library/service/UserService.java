package com.emre.project.library.service;

import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.SystemUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<SystemUser> getByUsernameAndPassword(String username, String password);
    void createUser(SystemUser user);
    void deleteUserByUserId(Integer userId);

    List<Customer> searchUsers(String searchTerm);
}
