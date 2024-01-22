package com.emre.project.library.menu.customer.profile;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import java.util.List;

public class MyProfileMenu extends Menu {


    public MyProfileMenu() {
        super("My Profile Menu");
        setOptions(List.of(
                new MenuOption("U","Update my Profile", MenuName.UPDATE_MY_PROFILE),
                new MenuOption("S","See my Profile",MenuName.SEE_MY_PROFILE),
                new MenuOption("M","Return to Main",MenuName.USER_MAIN_MENU)));

    }

}
