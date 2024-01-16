package com.emre.project.library.menu.admin;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.menu.login.UserLoginMenu;

import java.util.List;

public class AdminMainMenu extends Menu {

    private UserLoginMenu userLoginMenu;
    public AdminMainMenu(UserLoginMenu userLoginMenu) {
        super("Login Menu");
        this.userLoginMenu = userLoginMenu;
        setOptions(List.of(
                new MenuOption("U","User Login", this::handleUserLogin),
                new MenuOption("A","Admin Login",this::handleAdminLogin),

                new MenuOption("X","Exit",this::exit)));
    }
    private Menu handleUserLogin(){
        System.out.println("User login start");
        return userLoginMenu;
    }
    private Menu handleAdminLogin(){
        System.out.println("Admin handler");
        return this;
    }
    private Menu exit(){
        System.exit(1);
        return null;
    }
}
