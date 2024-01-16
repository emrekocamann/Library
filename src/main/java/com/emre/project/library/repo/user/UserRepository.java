package com.emre.project.library.repo.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private  final Map<Integer, SystemUser> users= new HashMap<>();

    public void createUser(SystemUser user){
        users.put(user.getId(), user);
    }
    public void deleteUserById(Integer id){
        users.remove(id);
    }

    public Optional<SystemUser> getByUsernameAndPassword(String username, String password) {
        return users.values().stream()
                .filter(u->u.getUsername().equals(username)&&u.getPassword().equals(password)).findFirst();
    }
}
