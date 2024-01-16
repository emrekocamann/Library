package com.emre.project.library.menu.generic;

import com.emre.project.library.service.UserService;
import java.util.List;
import java.util.Optional;

public class Menu {
    private final String title;
    private List<MenuOption> options;
    private UserService userService;
    public Menu(String title) {
        this.title = title;
    }

    public Menu(String title, UserService userService) {
        this.title = title;
        this.userService = userService;
    }

    protected void printTitle(){
        System.out.println();
        println("============"+title+"============");
    }
    public void printOptions(){
        for (MenuOption option : options) {
//            System.out.println("("+option.choice()+") - "+option.title());
            System.out.printf("(%s) - %s %n", option.choice(),option.title());
        }
        println("----------------------------------");

        print("Enter your choice:");
    }
    protected MenuOption getOption(){
        final String choice = ConsoleReader.readLine();
        Optional<MenuOption> option = options.stream()
                .filter(o -> o.choice().equalsIgnoreCase(choice))
                .findFirst();
        if (option.isEmpty()) {
            print("Invalid option, please try again: ");
         return    getOption();
        } else{
        return option.get();
        }
    }
    public Menu execute(){
        printTitle();
        printOptions();
        MenuOption option = getOption();
       return option.handler().handle();
    }

    protected void setOptions(List<MenuOption> options) {
       this.options = options;
    }

    protected UserService getUserService() {
        return userService;
    }
    protected void print(String text){
        System.out.print(text);
    }
    protected void println(String text){
        System.out.println(text);
    }
    protected void error(String text){
        System.err.println(text);
    }
}
