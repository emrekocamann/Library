package com.emre.project.library.menu.admin.book;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;

import static com.emre.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;

public class CreateBookMenu extends Menu {

    public CreateBookMenu(BookService bookService) {
        super("Create Book", bookService);
    }


    @Override
    public MenuName execute() {
        printTitle();

        String title = printAndGet("Title");
        Integer year  = Integer.valueOf(printAndGet("Year"));
        String author  = printAndGet("Author");

        Book newBook = new Book(null, title, year, author);

       getBookService().createBook(newBook);
        System.out.println();
        SystemContext.removeProperty(BOOK_ID);
        println("Book is successfully created");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }


}
