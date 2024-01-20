package com.emre.project.library.repo.book;



import java.util.*;

public class BookRepository {
    private  final Map<Integer, Book> books= new HashMap<>();

    public void createBook(Book newBook){
        Integer maxId = books.keySet().stream().max(Comparator.naturalOrder()).orElse(1);
        Integer newId= maxId+1;
        Book book =  new Book(newId,newBook.title(),newBook.year(), newBook.author());
        books.put(newId, book);
    }
    public void deleteUserById(Integer id){
       books.remove(id);
    }

    public Optional<Book> getById(Integer userId) {
        return Optional.ofNullable(books.get(userId));
    }



    public List<Book> searchBooks(String searchTerm) {
        return books.values().stream()
                .filter(u->searchBook(u,searchTerm))
                .toList();
    }

    private boolean searchBook(Book book, String searchTerm) {

           return  findId(searchTerm,
                   book.id(),
                   book.title(),
                   book.year(),
                   book.author()
                 );
    }

    private boolean findId(String searchTerm, Object ... values){
        return Arrays.stream(values)
                .anyMatch(s -> s.toString().contains(searchTerm));

    }

    public void updateBook(Book book) {
        books.put(book.id(),book);
    }
}
