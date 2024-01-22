package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.menu.generic.UserMenu;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;
import java.util.List;
public class ViewUsersMenu extends UserMenu {
    public static final String USER_ID="USER_ID";
    public ViewUsersMenu(UserService userService) {
        super("View Users", userService);
        setOptions(List.of(
                new MenuOption("E","Edit user", MenuName.ADMIN_EDIT_USER),
                new MenuOption("D","Delete user",MenuName.ADMIN_DELETE_USER),
                new MenuOption("M","Back to main menu",MenuName.ADMIN_MAIN_MENU)));
    }
    @Override
    public MenuName execute() {
        printTitle();
        String userId = SystemContext.getProperty(USER_ID);
        viewUser(Integer.valueOf(userId));
        return run();
      }
}
