package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class ViewUsersMenu extends Menu {
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
        Optional<Customer> customerOptional = getUserService().getById(Integer.valueOf(userId));
        Customer customer =customerOptional.orElseThrow();

        printfItem("ID",customer.getId().toString());
        printfItem("Username",customer.getUsername());
        printfItem("First Name",customer.getFirstname());
        printfItem("Last Name",customer.getLastname());
        printfItem("Address",customer.getAddress());
        printfItem("Postcode",customer.getPostcode());
        printfItem("City",customer.getCity());
        printfItem("Email",customer.getEmail());

        System.out.println();
        printOptions();

        return run();
      }


    private void printfItem(String label,String value){
        System.out.printf("%-13s: %s %n", label, value);
    }
}
