package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class CreateUserMenu extends Menu {
    public static final String USER_ID="USER_ID";
    public CreateUserMenu(UserService userService) {
        super("Create User", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();

       String username = printAndGet("Username: ");
       String password = printAndGet("Password: ");
       String firstName  = printAndGet("FirstName: ");
       String lastName  = printAndGet("LastName: ");
       String address = printAndGet("Address: ");
       String postcode = printAndGet("Postcode: ");
       String city = printAndGet("City: ");
       String email = printAndGet("Email: ");

       Customer newCustomer = new Customer((null),
               username, password, firstName,
               lastName,
               address,
               postcode,
               city,
               email);

       getUserService().createUser(newCustomer);
        System.out.println();
        SystemContext.removeProperty(USER_ID);
        println("User is successfully created");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }



}
