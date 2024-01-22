package com.emre.project.library.menu.customer.profile;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class SeeMyProfileMenu extends Menu {
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
        Optional<Customer> customerOptional = getUserService().getById(userId);
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
}
