package com.emre.project.library.menu.customer.profile;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class UpdateMyProfileMenu extends Menu {
    public static final String USER_ID="USER_ID";
    public UpdateMyProfileMenu(UserService userService) {
        super("Update my Profile", userService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        Integer userId = SystemContext.getLoggedInUserId();
        Optional<Customer> customerOptional = getUserService().getById(userId);
        Customer customer =customerOptional.orElseThrow();

     //  String id = printfAndGet("ID",customer.getId().toString());
       String username = printfAndGet("Username",customer.getUsername());
       String password = printfAndGet("Password",customer.getPassword());
       String firstName  = printfAndGet("First Name",customer.getFirstname());
       String lastName  = printfAndGet("Last Name",customer.getLastname());
       String address = printfAndGet("Address",customer.getAddress());
       String postcode = printfAndGet("Postcode",customer.getPostcode());
       String city = printfAndGet("City",customer.getCity());
       String email = printfAndGet("Email",customer.getEmail());

       Customer updatedCustomer = new Customer(customer.getId(),
               username, password, firstName,
               lastName,
               address,
               postcode,
               city,
               email);

        getUserService().updateUser(updatedCustomer);
        System.out.println();
        println("Profile is successfully updated");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.USER_MAIN_MENU;
      }
}
