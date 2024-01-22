package com.emre.project.library.menu.customer.book;

import com.emre.project.library.menu.generic.BookMenu;
import com.emre.project.library.menu.generic.ConsoleReader;
import com.emre.project.library.menu.generic.Menu;
import com.emre.project.library.menu.generic.MenuName;
import com.emre.project.library.repo.book.Book;
import com.emre.project.library.service.BookService;
import com.emre.project.library.system.SystemContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class ReturnBooksMenu extends BookMenu {
    public ReturnBooksMenu(BookService bookService) {
        super("Return Books", bookService);
    }

    @Override
    public MenuName execute() {
        printTitle();
        List<Book> books = getBookService().searchBooksBorrowedByUserId(SystemContext.getLoggedInUserId());
        if (books.isEmpty()){
              println("No borrowed books found, Press ENTER to continue");
              return MenuName.USER_MAIN_MENU;
        }else {
             showBookResults(books);
        }
        String choice=  printAndGet("Enter book ID to return or 'X' to go back to main menu: ");
          if ("X".equals(choice)){
              return MenuName.ADMIN_MAIN_MENU;
          }else {
              Optional<Book> optionalBook = books.stream()
                      .filter(c->c.getId().toString().equals(choice))
                      .findFirst();

              if (optionalBook.isPresent()){
                  Book book = optionalBook.get();
                  book.returnBook();
                  getBookService().updateBook(book);
                  System.out.println();
                  System.out.printf("Book: %s. Press enter to go back to main menu", book.getTitle());
                  ConsoleReader.readLine();

                  return MenuName.USER_MAIN_MENU;
              }else {
                  return execute();
              }
          }
      }
    }

