package com.emre.project.library.menu.customer.profile;

import com.emre.project.library.menu.generic.*;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class SeeMyProfileMenu extends UserMenu {
    public static final String USER_ID="USER_ID";
    public SeeMyProfileMenu(UserService userService) {
        super("Update my Profile", userService);
        setOptions(List.of(
                new MenuOption("U","Update my Profile", MenuName.UPDATE_MY_PROFILE),
                new MenuOption("R","Return to My Profile",MenuName.MY_PROFILE)));
    }
    @Override
    public MenuName execute() {
        printTitle();
        Integer userId = SystemContext.getLoggedInUserId();
        viewUser(userId);
        return run();
      }
}
