package com.emre.project.library.menu.admin.book;

import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;
import java.util.Optional;
import static com.emre.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;

public class EditBookMenu extends Menu {

    public EditBookMenu(BookService bookService) {
        super("Edit Book", bookService);
    }


    @Override
    public MenuName execute() {
        printTitle();
        String BookId = SystemContext.getProperty(BOOK_ID);
        Optional<Book> bookOptional = getBookService().getById(Integer.valueOf(BookId));
        Book book =bookOptional.orElseThrow();

        String title = printfAndGet("Title",book.getTitle());
        Integer year  = Integer.valueOf(printfAndGet("Year",book.getYear().toString()));
        String author  = printfAndGet("Author",book.getAuthor());

        Book updatedBook = new Book(book.getId(), title, year, author);

        getBookService().updateBook(updatedBook);
        System.out.println();
        SystemContext.removeProperty(BOOK_ID);
        println("Book is successfully updated");
        println("Press ENTER to continue");
        ConsoleReader.readLine();
        return MenuName.ADMIN_MAIN_MENU;
      }
}
