package com.emre.project.library.menu.admin.book;

import com.emre.project.library.menu.generic.BookMenu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;
import java.util.List;
import static com.emre.project.library.menu.admin.book.ViewBookMenu.BOOK_ID;


public class SearchBookMenu extends BookMenu {
    public SearchBookMenu(BookService bookService) {
        super("Search Books", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        String searchTerm= printAndGet("Enter search term: ");

      List<Book> books = getBookService().searchBooks(searchTerm);
      if (books.isEmpty()){
          println("No Book found, please try again");
          return execute();
      }else {
         showBookResults(books);
         String choice=  printAndGet("Enter book ID to see or 'X' to go back to main menu:");
          if ("X".equalsIgnoreCase(choice)){
              return MenuName.ADMIN_MAIN_MENU;
          }else {
              boolean isExists=    books.stream().anyMatch(c->c.getId().toString().equals(choice));

              if (isExists){
                  SystemContext.addProperty(BOOK_ID,choice);
                  return MenuName.ADMIN_VIEW_BOOK;
              }else {
                  return execute();
              }
          }
      }

    }
}
