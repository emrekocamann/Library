package com.emre.project.library.menu.admin.user;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.service.UserService;
import com.emre.project.library.system.SystemContext;

import java.util.List;

import static com.emre.project.library.menu.admin.user.ViewUsersMenu.USER_ID;

public class SearchUsersMenu extends Menu {
    public SearchUsersMenu(UserService userService) {
        super("Search Users", userService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String searchTerm= printAndGet("Enter search term: ");

      List<Customer> customers = getUserService().searchUsers(searchTerm);
      if (customers.isEmpty()){
          println("No user found, please try again");
          return execute();
      }else {
          System.out.printf("%-5s|%-20s|%-20s|%-10s|%-15s %n","ID","Name","Address","Postcode","City");
          for (Customer c: customers){
              System.out.printf("%-5.5s|%-20.20s|%-20.20s|%-10.10s%-15.15s %n",
                      c.getId(),c.getFirstname(),c.getLastname(),c.getAddress(),c.getCity());
          }
            String choice=  printAndGet("Enter user ID to see or 'X' to go back to main menu:");
          if ("X".equals(choice)){
              return MenuName.ADMIN_MAIN_MENU;
          }else {
              boolean isExists=    customers.stream().anyMatch(c->c.getId().toString().equals(choice));

              if (isExists){
                  SystemContext.addProperty(USER_ID,choice);
                  return MenuName.ADMIN_VIEW_USER;
              }else {
                  return execute();
              }
          }
      }

    }
}
