package com.senla.bookshop.utils;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IEntity;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.entities.requeststatus.RequestStatus;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final String SEPARATOR = ",";

    public static String[] entitiesToStrings(List<? extends IEntity> entityList) {
        String[] strEntities = new String[entityList.size()];

        for (int i = 0; i < strEntities.length; i++) {
            strEntities[i] = convertEntityToString(entityList.get(i));
        }
        return strEntities;
    }

    private static String convertEntityToString(IEntity entity){
        StringBuilder str = new StringBuilder();
        if(entity.getClass() == Book.class){
            IBook book = (Book) entity;
            str.append(book.getId()).append(SEPARATOR).append(book.getTitle()).append(SEPARATOR)
                    .append(book.getAuthor()).append(SEPARATOR).append(book.getPrice()).append(SEPARATOR)
                    .append(book.getInStoke()).append(SEPARATOR).append(book.getPublishDate()).append(SEPARATOR)
                    .append(book.getReceiptDate());
            return str.toString();
        }else if(entity.getClass() == Order.class){
            IOrder order = (Order) entity;
            str.append(order.getId()).append(SEPARATOR).append(order.getBookId()).append(SEPARATOR)
                    .append(order.getPrice()).append(SEPARATOR).append(order.getSubmissionDate()).append(SEPARATOR)
                    .append(order.getExecutionDate()).append(SEPARATOR).append(order.getOrderStatus());
            return str.toString();
        }else if(entity.getClass() == Request.class){
            IRequest request = (Request) entity;
            str.append(request.getId()).append(SEPARATOR).append(request.getBookId()).append(SEPARATOR)
                    .append(request.getRequestDate()).append(SEPARATOR).append(request.getRequestStatus());
            return str.toString();
        }
        return null;
    }

    public static List<IBook> stringsToBooks(String[] strArray) throws FormatException {
        List<IBook> books = new ArrayList<>();
        for (String string: strArray)
            books.add(convertStringToBook(string));
        return books;
    }

    public static List<IOrder> stringsToOrders(String[] strArray) throws FormatException {
        List<IOrder> orders = new ArrayList<>();
        for (String string : strArray)
            orders.add(convertStringToOrder(string));
        return orders;
    }

    public static List<IRequest> stringsToRequests(String[] strArray) throws FormatException {
        List<IRequest> requests = new ArrayList<>();
        for (String string : strArray)
            requests.add(convertStringToRequest(string));
        return requests;
    }

    private static IBook convertStringToBook(String string) throws FormatException {
        try {
            String[] values = string.split(SEPARATOR);
            return new Book(Long.valueOf(values[0]),values[1], values[2],
                    Double.valueOf(values[3]), Boolean.parseBoolean(values[4]),
                    LocalDate.parse(values[5]),LocalDate.parse(values[6]));
        }catch (NumberFormatException e){
            throw new FormatException("Wrong file/format.");
        }

    }

    private static IOrder convertStringToOrder(String string) throws FormatException {
        try {
            String[] values = string.split(SEPARATOR);
            return new Order(Long.valueOf(values[0]),Long.valueOf(values[1]),
                    Double.valueOf(values[2]),LocalDate.parse(values[3]),LocalDate.parse(values[4]),
                    OrderStatus.valueOf(values[5]));
        }catch (NumberFormatException e){
            throw new FormatException("Wrong file/format.");
        }
    }

    private static IRequest convertStringToRequest(String string) throws FormatException {
        try {
            String[] values = string.split(SEPARATOR);
            return new Request(Long.valueOf(values[0]), Long.valueOf(values[1]),
                    LocalDate.parse(values[2]), RequestStatus.valueOf(values[3]));
        }catch (NumberFormatException e){
            throw new FormatException("Wrong file/format.");
        }
    }
}
