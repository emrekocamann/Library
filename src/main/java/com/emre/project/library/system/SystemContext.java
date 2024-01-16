package com.emre.project.library.system;

import com.emre.project.library.exceptions.UserLogInException;
import com.emre.project.library.repo.user.AdminUser;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.SystemUser;

import java.util.Optional;

public final class SystemContext {
    private static Integer loggedInUserId;
    private static boolean isAdmin = false;

    public static boolean isLoggedInUserAdmin(){
        return isAdmin;
    }
    public static Integer getLoggedInUserId(){
        return Optional
                .ofNullable(loggedInUserId)
                .orElseThrow(()->new UserLogInException("No log in info available"));
    }

    public static void logInUser(SystemUser user){
        switch (user){
            case null -> throw new UserLogInException("Lon in user is null");
            case Customer customer ->{
                loggedInUserId = user.getId();
                isAdmin = false;
            }
            case AdminUser admin -> {
                loggedInUserId = user.getId();
                isAdmin = true;
            }
            default -> {throw new UserLogInException("Unsupported user type: " +user);}
        }
    }

    public static void logOut(){
        loggedInUserId = null;
        isAdmin = false;
    }
}