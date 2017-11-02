package com.senla.bookshop.utils;


import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Entity;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.orderstatus.OrderStatus;
import com.senla.bookshop.entities.requeststatus.RequestStatus;

import java.time.LocalDate;
import java.util.Arrays;

public class TextParser {

    public static Book[] booksArray;

    public static String[] parseEntities(Entity[] entities) {
        String[] strEntities = new String[entities.length];
        for (int i = 0; i < entities.length; i++) {
            strEntities[i] = convertEntityToString(entities[i]);
        }
        return strEntities;
    }

    private static String convertEntityToString(Entity entity){

        if(entity.getClass() == Book.class){
            Book book = (Book) entity;
            return book.getId() + "/" +
                    book.getAuthor() + "/" +
                    book.getTitle() + "/" +
                    book.getPrice() + "/" +
                    book.getInStoke() + "/" +
                    book.getPublishDate() + "/" +
                    book.getReceiptDate() + "/" +
                    book.getAmountOfRequests();
        }else if(entity.getClass() == Order.class){
            Order order = (Order) entity;
            return order.getId() + "/" +
                    order.getBook().getId() + "/" +
                    order.getPrice() + "/" +
                    order.getOrderStatus() + "/" +
                    order.getSubmissionDate() + "/" +
                    order.getExecutionDate();
        }else if(entity.getClass() == Request.class){
            Request request = (Request) entity;
            return request.getId() + "/" +
                    request.getBook().getId() + "/" +
                    request.getRequestStatus() + "/" +
                    request.getRequestDate();
        }
        return null;
    }

    public static Book[] parseBookStrings(String[] strArray){
        Book[] books = new Book[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            books[i] = convertStringsToBooks(strArray[i]);
        }
        return books;
    }

    public static Order[] parseOrderStrings(String[] strArray){
        Order[] orders = new Order[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            orders[i] = convertStringsToOrders(strArray[i]);
        }
        return orders;
    }

    public static Request[] parseRequsestStrings(String[] strArray){
        Request[] requests = new Request[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            requests[i] = convertStringsToRequests(strArray[i]);
        }
        return requests;
    }

    private static Book convertStringsToBooks(String string){
            String[] values = string.split("/");
            Book book = new Book(values[1],values[2],Double.valueOf(values[3]),
                                LocalDate.parse(values[5]),LocalDate.parse(values[6]));
            book.setId(Long.valueOf(values[0]));
            book.setInStoke(Boolean.valueOf(values[4]));
            book.setAmountOfRequests(Integer.valueOf(values[7]));
            return book;

    }

    private static Order convertStringsToOrders(String string){
        String[] values = string.split("/");
        Order order = new Order((Book) ArrayWorker.findById(booksArray,Long.valueOf(values[1])),
                LocalDate.parse(values[4]),LocalDate.parse(values[5]));
        order.setId(Long.valueOf(values[0]));
        order.setPrice(Double.valueOf(values[2]));
        order.setOrderStatus(OrderStatus.valueOf(values[3]));
        return order;
    }

    private static Request convertStringsToRequests(String string) {
        String[] values = string.split("/");
        Request request = new Request((Book)ArrayWorker.findById(booksArray,Long.valueOf(values[1])),
                LocalDate.parse(values[3]));
        request.setId(Long.valueOf(values[0]));
        request.setRequestStatus(RequestStatus.valueOf(values[2]));
        return request;
    }
}
