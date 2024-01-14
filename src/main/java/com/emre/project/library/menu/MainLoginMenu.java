package com.emre.project.library.menu;

import java.util.List;

public class MainLoginMenu extends Menu{

    public MainLoginMenu() {
        super("Login Menu");
        setOptions(List.of(
                new MenuOption("U","User Login", this::handleUserLogin),
                new MenuOption("A","Admin Login",this::handleAdminLogin),

                new MenuOption("X","Exit",this::exit)));
    }
    private void handleUserLogin(){
        System.out.println("User handler");
    }
    private void handleAdminLogin(){
        System.out.println("Admin handler");
    }
    private void exit(){
        System.exit(1);
    }
}
