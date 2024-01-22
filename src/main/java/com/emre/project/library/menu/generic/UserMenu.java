package com.emre.project.library.menu.generic;

import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

public class UserMenu extends Menu{

    public UserMenu(String title, UserService userService) {
        super(title, userService);
    }
    protected void viewUser(Integer userId){
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
    }
    protected void editUser(Integer userId) {
        Optional<Customer> customerOptional = getUserService().getById(userId);
        Customer customer =customerOptional.orElseThrow();

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
        println("User is successfully updated");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
    }
}
