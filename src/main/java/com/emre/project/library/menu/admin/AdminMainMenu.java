package com.emre.project.library.menu.admin;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.menu.login.UserLoginMenu;

import java.util.List;

public class AdminMainMenu extends Menu {


    public AdminMainMenu() {
        super("Admin Main Menu");

        setOptions(List.of(
                new MenuOption("S"," Search users", MenuName.SEARCH_USERS),
                new MenuOption("C","Create user",MenuName.CREATE_USER),
                new MenuOption("B","Search books",MenuName.SEARCH_BOOKS),
                new MenuOption("B","Create book", MenuName.CREATE_BOOK),
                new MenuOption("O","Log off",MenuName.LOG_OFF)));
    }
//    private Menu handleUserLogin(){
//        System.out.println("User login start");
//        return userLoginMenu;
//    }
    private Menu handleAdminLogin(){
        System.out.println("Admin handler");
        return this;
    }
    private Menu exit(){
        System.exit(1);
        return null;
    }
}
