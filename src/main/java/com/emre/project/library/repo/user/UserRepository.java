package com.emre.project.library.repo.user;

import java.util.*;

public class UserRepository {
    private  final Map<Integer, SystemUser> users= new HashMap<>();

    public void createUser(SystemUser user){
        users.put(user.getId(), user);
    }
    public void deleteUserById(Integer id){
        users.remove(id);
    }

    public Optional<SystemUser> getById(Integer userId) {
        return Optional.ofNullable(users.get(userId));
    }

    public Optional<SystemUser> getByUsernameAndPassword(String username, String password) {
        return users.values().stream()
                .filter(u->u.getUsername().equals(username)&&u.getPassword().equals(password)).findFirst();
    }

    public List<SystemUser> searchUsers(String searchTerm) {
        return users.values().stream()
                .filter(u->searchUser(u,searchTerm))
                .toList();
    }

    private boolean searchUser(SystemUser user, String searchTerm) {
        boolean found = findId(searchTerm,
                user.getId().toString(),
                user.getUsername());
       if (user instanceof Customer customer){
           return found || findId(searchTerm,
                   customer.getAddress(),
                   customer.getPostcode(),
                   customer.getCity(),
                   customer.getEmail(),
                   customer.getFirstname(),
                   customer.getLastname());
       }else {
           return false;
       }

    }

    private boolean findId(String searchTerm, String ... values){
        return Arrays.stream(values)
                .anyMatch(s -> s.contains(searchTerm));

    }

}
