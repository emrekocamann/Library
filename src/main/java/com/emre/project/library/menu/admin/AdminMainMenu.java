package com.emre.project.library.menu.admin;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import java.util.List;

public class AdminMainMenu extends Menu {


    public AdminMainMenu() {
        super("Admin Main Menu");
        setOptions(List.of(
                new MenuOption("S","Search users", MenuName.SEARCH_USERS),
                new MenuOption("C","Create user",MenuName.ADMIN_CREATE_USER),
                new MenuOption("B","Search books",MenuName.ADMIN_SEARCH_BOOKS),
                new MenuOption("K","Create book", MenuName.ADMIN_CREATE_BOOK),
                new MenuOption("O","Log off",MenuName.LOG_OFF)));
    }
}
