package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class DeleteUserMenu extends Menu {
    public static final String USER_ID="USER_ID";
    public DeleteUserMenu(UserService userService) {
        super("Delete User", userService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        String userId = SystemContext.getProperty(USER_ID);
        Optional<Customer> customerOptional = getUserService().getById(Integer.valueOf(userId));
        Customer customer =customerOptional.orElseThrow();


        getUserService().deleteUserByUserId(customer.getId());
        System.out.printf("User %s is successfully deleted. %n",customer.getId());
        SystemContext.removeProperty(USER_ID);
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }
}
