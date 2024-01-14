package com.emre.project.library;

import com.emre.project.library.menu.MainLoginMenu;
import com.emre.project.library.menu.Menu;

public class LibraryApp {

    public static void main(String[] args)  {
        Menu mainMenu = new MainLoginMenu();
        mainMenu.execute();
    }
}
