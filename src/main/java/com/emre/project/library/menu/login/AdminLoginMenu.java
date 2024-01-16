package com.emre.project.library.menu.login;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.repo.user.AdminUser;
import com.emre.project.library.repo.user.SystemUser;
import com.emre.project.library.service.UserService;

import java.util.Optional;

public class AdminLoginMenu extends Menu {
    public AdminLoginMenu(UserService userService) {
        super("Admin Login", userService);
    }

    @Override
    public Menu execute() {
        printTitle();
        print("User name: ");
        String username = ConsoleReader.readLine();
        print("Password: ");
        String password = ConsoleReader.readLine();
        Optional<SystemUser> user = getUserService().getByUsernameAndPassword(username, password);
        if (user.isPresent() ){
            if (user.get() instanceof AdminUser){
                println("Login success, redirecting to main memu ...");
            }else {
                println("User must be an admin user, please try again");
                return execute();
            }
            return null;
        }else {
            error("Invalid credentials! please try again.");
             return  execute();
        }
    }
}
