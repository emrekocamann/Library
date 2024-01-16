package com.emre.project.library.service;

import com.emre.project.library.repo.user.SystemUser;
import com.emre.project.library.repo.user.UserRepository;
import com.emre.project.library.system.SystemContext;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<SystemUser> getByUsernameAndPassword(String username, String password) {
        return userRepository.getByUsernameAndPassword(username, password);
    }

    @Override
    public void createUser(SystemUser user) {
        if (SystemContext.isLoggedInUserAdmin()){
            userRepository.createUser(user);
        }else {
            throw new RuntimeException("Only admin roles can create a new user");
        }

    }

    @Override
    public void deleteUser(Integer userId) {
        if (SystemContext.isLoggedInUserAdmin()){
            userRepository.deleteUserById(userId);
        }else {
            throw new RuntimeException("Only admin roles can delete a user");
        }
    }
}
