package com.emre.project.library;

import com.emre.project.library.menu.admin.AdminMainMenu;
import com.emre.project.library.menu.admin.user.DeleteUserMenu;
import com.emre.project.library.menu.admin.user.EditUserMenu;
import com.emre.project.library.menu.admin.user.SearchUsersMenu;
import com.emre.project.library.menu.admin.user.ViewUsersMenu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.login.AdminLoginMenu;
import com.emre.project.library.menu.login.MainLoginMenu;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.login.UserLoginMenu;
import com.emre.project.library.repo.user.AdminUser;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.UserRepository;
import com.emre.project.library.service.MailService;
import com.emre.project.library.service.MailServiceImpl;
import com.emre.project.library.service.UserService;
import com.emre.project.library.service.UserServiceImpl;

public class LibraryApp {

    public static void main(String[] args)  {

        UserRepository userRepository = new UserRepository();
        createDummyUsers(userRepository);
        MailService mailService = new MailServiceImpl();
        UserService userService = new UserServiceImpl(userRepository,mailService);
        UserLoginMenu userLoginMenu = new UserLoginMenu(userService);
        AdminMainMenu adminMainMenuMenu = new AdminMainMenu();
        Menu mainLoginMenu = new MainLoginMenu();
        SearchUsersMenu  searchUsersMenu = new SearchUsersMenu(userService);
        AdminLoginMenu adminLoginMenu = new AdminLoginMenu(userService);
        ViewUsersMenu viewUsersMenu = new ViewUsersMenu(userService);
        EditUserMenu editUserMenu = new EditUserMenu(userService);
        DeleteUserMenu deleteUserMenu = new DeleteUserMenu(userService);

        MenuName menuName =MenuName.MAIN_LOGIN;

        while (true){
         menuName =   switch (menuName){
             case  USER_LOGIN -> userLoginMenu.execute();
             case  ADMIN_LOGIN -> adminLoginMenu.execute();
             case ADMIN_MAIN_MENU ->adminMainMenuMenu.execute();
             case SEARCH_USERS -> searchUsersMenu.execute();
             case ADMIN_VIEW_USER -> viewUsersMenu.execute();
             case ADMIN_EDIT_USER -> editUserMenu.execute();
             case ADMIN_DELETE_USER ->deleteUserMenu.execute();
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
