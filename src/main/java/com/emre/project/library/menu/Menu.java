package com.emre.project.library.menu;

import lombok.AccessLevel;
import lombok.Setter;


import java.util.List;
import java.util.Optional;

public class Menu {
    private final String title;
    @Setter(AccessLevel.PROTECTED)
    private List<MenuOption> options;

    public Menu(String title) {
        this.title = title;
    }
    public void printOptions(){
        System.out.println(title);
        for (MenuOption option : options) {
//            System.out.println("("+option.choice()+") - "+option.title());
            System.out.printf("(%s) - %s %n", option.choice(),option.title());
        }
        System.out.print("Enter your choice:");
    }
    protected MenuOption getOption(){
        final String choice = ConsoleReader.readLine();
        Optional<MenuOption> option = options.stream()
                .filter(o -> o.choice().equalsIgnoreCase(choice))
                .findFirst();
        if (option.isEmpty()) {
            System.out.print("Invalid option, please try again: ");
         return    getOption();
        } else{
        return option.get();
        }
    }
    public void execute(){
        printOptions();
        MenuOption option = getOption();
        option.handler().handle();
    }
}
