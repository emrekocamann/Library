package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.UserMenu;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class EditUserMenu extends UserMenu {
    public static final String USER_ID="USER_ID";
    public EditUserMenu(UserService userService) {
        super("Edit User", userService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        String userId = SystemContext.getProperty(USER_ID);
        editUser(Integer.valueOf(userId));
        SystemContext.removeProperty(USER_ID);
       return MenuName.ADMIN_MAIN_MENU;
      }

}
