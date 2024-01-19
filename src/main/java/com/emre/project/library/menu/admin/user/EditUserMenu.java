package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class EditUserMenu extends Menu {
    public static final String USER_ID="USER_ID";
    public EditUserMenu(UserService userService) {
        super("Edit User", userService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        String userId = SystemContext.getProperty(USER_ID);
        Optional<Customer> customerOptional = getUserService().getById(Integer.valueOf(userId));
        Customer customer =customerOptional.orElseThrow();

     //  String id = printfAndGet("ID",customer.getId().toString());
       String username = printfAndGet("Username",customer.getUsername());
       String firstName  = printfAndGet("First Name",customer.getFirstname());
       String lastName  = printfAndGet("Last Name",customer.getLastname());
       String address = printfAndGet("Address",customer.getAddress());
       String postcode = printfAndGet("Postcode",customer.getPostcode());
       String city = printfAndGet("City",customer.getCity());
       String email = printfAndGet("Email",customer.getEmail());

       Customer updatedCustomer = new Customer(customer.getId(),
               username, customer.getPassword(), firstName,
               lastName,
               address,
               postcode,
               city,
               email);

       getUserService().updateUser(updatedCustomer);
        System.out.println();
        SystemContext.removeProperty(USER_ID);
        println("User is successfully updated");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }


    private String printfAndGet(String label,String value){
        System.out.printf("%-13s: %s -> New value: ", label, value);
        String input=  ConsoleReader.readLine();

        if (input == null||input.trim().equals("")){
            return value;
        }else {
            return input;
        }
    }
}
