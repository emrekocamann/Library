package com.emre.project.library.menu.admin.book;

import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.menu.generic.MenuOption;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;

import java.util.List;
import java.util.Optional;

public class ViewBookMenu extends Menu {
    public static final String BOOK_ID="BOOK_ID";
    public ViewBookMenu(BookService bookService) {
        super("View Books", bookService);
        setOptions(List.of(
                new MenuOption("E","Edit Book", MenuName.ADMIN_EDIT_BOOK),
                new MenuOption("D","Delete Book",MenuName.ADMIN_DELETE_BOOK),
                new MenuOption("M","Back to main menu",MenuName.ADMIN_MAIN_MENU)));
    }


    @Override
    public MenuName execute() {
        printTitle();
        String BookId = SystemContext.getProperty(BOOK_ID);
        Optional<Book> BookOptional = getBookService().getById(Integer.valueOf(BookId));
        Book book =BookOptional.orElseThrow();

        printfItem("ID",book.id().toString());
        printfItem("Title",book.title());
        printfItem("Year",book.year().toString());
        printfItem("Author",book.author());


        System.out.println();
        printOptions();

        return run();
      }
}
