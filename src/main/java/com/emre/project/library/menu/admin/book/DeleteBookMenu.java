package com.emre.project.library.menu.admin.book;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;

import java.util.Optional;

import static com.emre.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;


public class DeleteBookMenu extends Menu {

    public DeleteBookMenu(BookService bookService) {
        super("Delete Book", bookService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        String bookId = SystemContext.getProperty(BOOK_ID);
        Optional<Book> BookOptional = getBookService().getById(Integer.valueOf(bookId));
        Book book =BookOptional.orElseThrow();


        getBookService().deleteBookByBookId(book.id());
        System.out.printf("Book %s is successfully deleted. %n",book.id());
        SystemContext.removeProperty(BOOK_ID);
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }
}
