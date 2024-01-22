package com.emre.project.library.menu.generic;

import com.emre.project.library.service.BookService;
import com.emre.project.library.service.UserService;
import java.util.List;
import java.util.Optional;

public class Menu {
    private final String title;
    private List<MenuOption> options;
    private UserService userService;
    private BookService bookService;
    public Menu(String title) {
        this.title = title;
    }

    public Menu(String title, UserService userService) {
        this.title = title;
        this.userService = userService;
    }
    public Menu(String title, BookService bookService) {
        this.title = title;
        this.bookService = bookService;
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
    protected String printAndGet(String text){
        print(text);
        return ConsoleReader.readLine();
    }
    public MenuName execute(){
        printTitle();
        printOptions();
        return run();
    }
    protected MenuName run(){
        MenuOption option = getOption();
        if (option.handler() != null){
            return option.handler().handle();
        }
        return option.menuName();
    }

    protected void setOptions(List<MenuOption> options) {
       this.options = options;
    }

    protected UserService getUserService() {
        return userService;
    }

    protected BookService getBookService() {
        return bookService;
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
    protected String printfAndGet(String label,String value){
        System.out.printf("%-13s: %s -> New value: ", label, value);
        String input=  ConsoleReader.readLine();

        if (input == null||input.trim().equals("")){
            return value;
        }else {
            return input;
        }
    }
    protected void printfItem(String label,String value){
        System.out.printf("%-13s: %s %n", label, value);
    }
}
