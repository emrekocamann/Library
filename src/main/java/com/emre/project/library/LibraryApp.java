package com.emre.project.library;

import com.emre.project.library.menu.admin.user.SearchUsersMenu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.login.AdminLoginMenu;
import com.emre.project.library.menu.login.MainLoginMenu;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.login.UserLoginMenu;
import com.emre.project.library.repo.user.AdminUser;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.UserRepository;
import com.emre.project.library.service.UserService;
import com.emre.project.library.service.UserServiceImpl;

public class LibraryApp {

    public static void main(String[] args)  {

        UserRepository userRepository = new UserRepository();
        createDummyUsers(userRepository);
        UserService userService = new UserServiceImpl(userRepository);
        UserLoginMenu userLoginMenu = new UserLoginMenu(userService);
        Menu mainLoginMenu = new MainLoginMenu();
        SearchUsersMenu  searchUsersMenu = new SearchUsersMenu(userService);
        AdminLoginMenu adminLoginMenu = new AdminLoginMenu(userService);

        MenuName menuName =MenuName.MAIN_LOGIN;

        while (true){
         menuName =   switch (menuName){
             case  USER_LOGIN -> userLoginMenu.execute();
             case  ADMIN_LOGIN -> adminLoginMenu.execute();
             case SEARCH_USERS -> searchUsersMenu.execute();
                default -> mainLoginMenu.execute();
            };
        }

    }

    private  static void createDummyUsers(UserRepository userRepository) {
        userRepository.createUser(
                new Customer(1,"test1","123456",
                        "test1F","test1L","addr",
                        "p1","Istanbul","test@test.com"));
        userRepository.createUser(
                new Customer(2,"test2","123456",
                        "Emre","Kocaman","addr",
                        "15400","Denizli","admin@test.com"));
        userRepository.createUser(
                new AdminUser(1001,"admin1","123456"));
    }
}
