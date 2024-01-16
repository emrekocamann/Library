package com.emre.project.library;

import com.emre.project.library.menu.login.MainLoginMenu;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.login.UserLoginMenu;
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
        Menu menu = new MainLoginMenu(userLoginMenu);

        while (true){
            menu = menu.execute();
        }

    }

    private  static void createDummyUsers(UserRepository userRepository) {
        userRepository.createUser(
                new Customer(1,"test1","123456",
                        "test1F","test1L","addr",
                        "p1","Istanbul","test@test.com"));
    }
}
