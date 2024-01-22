package com.emre.project.library.menu.customer;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import java.util.List;

public class UserMainMenu extends Menu {


    public UserMainMenu() {
        super("Admin Main Menu");
        setOptions(List.of(
                new MenuOption("P","My Profile", MenuName.MY_PROFILE),
                new MenuOption("B","Borrow Book",MenuName.BORROW_BOOK),
                new MenuOption("R","Return Books",MenuName.RETURN_BOOK),
                new MenuOption("O","Log off",MenuName.LOG_OFF)));
    }
}
