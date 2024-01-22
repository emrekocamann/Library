package com.emre.project.library.menu.login;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.SystemUser;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;
import java.util.Optional;

public class UserLoginMenu extends Menu {
    public UserLoginMenu(UserService userService) {
        super("User Login", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String username = printAndGet("User name: ");
        String password = printAndGet("Password: ");

        Optional<SystemUser> user = getUserService().getByUsernameAndPassword(username, password);
        if (user.isPresent()){
            println("Login success, redirecting to main memu ...");
            SystemContext.logInUser(user.get());
            return MenuName.USER_MAIN_MENU;
        }else {
           error("Invalid credentials! please try again.");
            return execute();
        }
    }
}
