package com.senla.bookshop.utils;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IEntity;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.entities.requeststatus.RequestStatus;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static String[] entitiesToStrings(List<? extends IEntity> entityList) {
        String[] strEntities = new String[entityList.size()];

        for (int i = 0; i < strEntities.length; i++) {
            strEntities[i] = convertEntityToString(entityList.get(i));
        }
        return strEntities;
    }

    private static String convertEntityToString(IEntity entity){
        if(entity.getClass() == Book.class){
            IBook book = (Book) entity;
            return book.getId() + "/" +
                    book.getTitle() + "/" +
                    book.getAuthor() + "/" +
                    book.getPrice() + "/" +
                    book.getInStoke() + "/" +
                    book.getPublishDate() + "/" +
                    book.getReceiptDate();
        }else if(entity.getClass() == Order.class){
            IOrder order = (Order) entity;
            return order.getId() + "/" +
                    order.getBookId() + "/" +
                    order.getPrice() + "/" +
                    order.getSubmissionDate() + "/" +
                    order.getExecutionDate() + "/" +
                    order.getOrderStatus();
        }else if(entity.getClass() == Request.class){
            IRequest request = (Request) entity;
            return request.getId() + "/" +
                    request.getBookId() + "/" +
                    request.getRequestDate() + "/" +
                    request.getRequestStatus();
        }
        return null;
    }

    public static List<IBook> stringsToBooks(String[] strArray) {
        List<IBook> books = new ArrayList<>();
        for (String string: strArray)
            books.add(convertStringToBook(string));
        return books;
    }

    public static List<IOrder> stringsToOrders(String[] strArray) {
        List<IOrder> orders = new ArrayList<>();
        for (String string : strArray)
            orders.add(convertStringToOrder(string));
        return orders;
    }

    public static List<IRequest> stringsToRequests(String[] strArray) {
        List<IRequest> requests = new ArrayList<>();
        for (String string : strArray)
            requests.add(convertStringToRequest(string));
        return requests;
    }

    private static IBook convertStringToBook(String string){
        String[] values = string.split("/");
        return new Book(Long.valueOf(values[0]),values[1], values[2],
                Double.valueOf(values[3]), Boolean.parseBoolean(values[4]),
                LocalDate.parse(values[5]),LocalDate.parse(values[6]));
    }

    private static IOrder convertStringToOrder(String string){
        String[] values = string.split("/");
        return new Order(Long.valueOf(values[0]),Long.valueOf(values[1]),
                Double.valueOf(values[2]),LocalDate.parse(values[3]),LocalDate.parse(values[4]),
                OrderStatus.valueOf(values[5]));
    }

    private static IRequest convertStringToRequest(String string){
        String[] values = string.split("/");
        return new Request(Long.valueOf(values[0]), Long.valueOf(values[1]),
                LocalDate.parse(values[2]), RequestStatus.valueOf(values[3]));
    }
}
