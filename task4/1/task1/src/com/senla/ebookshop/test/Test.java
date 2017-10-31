package com.senla.ebookshop.test;

import com.danco.training.TextFileWorker;
import com.senla.ebookshop.facade.Facade;
import com.senla.ebookshop.interfaces.IFacade;
import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.utils.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        IFacade facade = new Facade();

        Path filePath = Paths.get("books.txt");
        try {
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextFileWorker textFileWorker = new TextFileWorker("books.txt");

        Book book1 = new Book("I, Robot", "Isaac Asimov", 15.3,
                                LocalDate.of(1950,2,3),
                                LocalDate.of(2010,2,4));

        Book book2 = new Book("The Idiot", "Fyodor Dostoyevsky", 11.2,
                                LocalDate.of(1869,1,29),
                                LocalDate.of(2010,3,2));

        Book book3 = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 9.3,
                                LocalDate.of(1967,7,20),
                                LocalDate.of(2010,4,2));

        facade.addBook(book1);
        facade.addBook(book2);
        facade.addBook(book3);

        Printer.printArray(facade.sortBooksByPublishDate(facade.getAllBooks()));

        Book[] books = facade.getAllBooks();
        String[] strArray = new String[books.length];



        for(int i = 0; i < strArray.length; i++){
            if(books[i] == null)
                strArray[i] = null;
            else strArray[i] = books[i].toString();
        }
        textFileWorker.writeToFile(strArray);

        Printer.printArray(textFileWorker.readFromFile());
    }
}
