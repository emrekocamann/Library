package com.emre.project.library.menu.customer.profile;

import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.UserMenu;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class UpdateMyProfileMenu extends UserMenu {
    public static final String USER_ID="USER_ID";
    public UpdateMyProfileMenu(UserService userService) {
        super("Update my Profile", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        Integer userId = SystemContext.getLoggedInUserId();
        editUser(userId);
        return MenuName.USER_MAIN_MENU;
    }
}
