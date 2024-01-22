package com.emre.project.library;

import com.emre.project.library.menu.admin.AdminMainMenu;
import com.emre.project.library.menu.admin.book.*;
import com.emre.project.library.menu.admin.user.*;
import com.emre.project.library.menu.customer.UserMainMenu;
import com.emre.project.library.menu.customer.profile.MyProfileMenu;
import com.emre.project.library.menu.customer.profile.SeeMyProfileMenu;
import com.emre.project.library.menu.customer.profile.UpdateMyProfileMenu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.login.AdminLoginMenu;
import com.emre.project.library.menu.login.MainLoginMenu;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.login.UserLoginMenu;
import com.emre.project.library.repo.book.BookRepository;
import com.emre.project.library.repo.user.AdminUser;
import com.emre.project.library.repo.user.Customer;
import com.emre.project.library.repo.user.UserRepository;
import com.emre.project.library.service.*;

public class LibraryApp {

    public static void main(String[] args)  {

        UserRepository userRepository = new UserRepository();
        BookRepository bookRepository = new BookRepository();
        createDummyUsers(userRepository);
        MailService mailService = new MailServiceImpl();
        UserService userService = new UserServiceImpl(userRepository,mailService);
        BookService bookService = new BookServiceImpl(bookRepository);

        Menu mainLoginMenu = new MainLoginMenu();
        UserLoginMenu userLoginMenu = new UserLoginMenu(userService);
        AdminMainMenu adminMainMenuMenu = new AdminMainMenu();
        AdminLoginMenu adminLoginMenu = new AdminLoginMenu(userService);

        SearchUsersMenu  searchUsersMenu = new SearchUsersMenu(userService);
        ViewUsersMenu viewUsersMenu = new ViewUsersMenu(userService);
        EditUserMenu editUserMenu = new EditUserMenu(userService);
        DeleteUserMenu deleteUserMenu = new DeleteUserMenu(userService);
        CreateUserMenu createUserMenu = new CreateUserMenu(userService);

        // -- book menus
        SearchBookMenu searchBookMenu = new SearchBookMenu(bookService);
        ViewBookMenu viewBookMenu = new ViewBookMenu(bookService);
        EditBookMenu editBookMenu = new EditBookMenu(bookService);
        DeleteBookMenu deleteBookMenu = new DeleteBookMenu(bookService);
        CreateBookMenu createBookMenu = new CreateBookMenu(bookService);

        // -- user menus
        UserMainMenu userMainMenu = new UserMainMenu();
        MyProfileMenu myProfileMenu = new MyProfileMenu();
        UpdateMyProfileMenu updateMyProfileMenu = new UpdateMyProfileMenu(userService);
        SeeMyProfileMenu seeMyProfileMenu = new SeeMyProfileMenu(userService);



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
             case ADMIN_CREATE_USER ->createUserMenu.execute();
             case ADMIN_SEARCH_BOOKS -> searchBookMenu.execute();
             case ADMIN_VIEW_BOOK-> viewBookMenu.execute();
             case ADMIN_EDIT_BOOK->editBookMenu.execute();
             case ADMIN_CREATE_BOOK->createBookMenu.execute();
             case ADMIN_DELETE_BOOK->deleteBookMenu.execute();
             case USER_MAIN_MENU -> userMainMenu.execute();
             case MY_PROFILE -> myProfileMenu.execute();
             case UPDATE_MY_PROFILE -> updateMyProfileMenu.execute();
             case SEE_MY_PROFILE -> seeMyProfileMenu.execute();
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
