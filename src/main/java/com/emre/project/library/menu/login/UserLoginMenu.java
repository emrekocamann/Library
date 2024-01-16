package com.emre.project.library.menu.login;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.repo.user.SystemUser;
import com.emre.project.library.service.UserService;

import java.util.Optional;

public class UserLoginMenu extends Menu {
    public UserLoginMenu(UserService userService) {
        super("User Login", userService);
    }

    @Override
    public Menu execute() {
        printTitle();
        print("User name: ");
        String username = ConsoleReader.readLine();
        print("Password: ");
        String password = ConsoleReader.readLine();
        Optional<SystemUser> user = getUserService().getByUsernameAndPassword(username, password);
        if (user.isPresent()){
            println("Login success, redirecting to main memu ...");
            return null;
        }else {
           error("Invalid credentials! please try again.");
            return execute();
        }
    }
}
