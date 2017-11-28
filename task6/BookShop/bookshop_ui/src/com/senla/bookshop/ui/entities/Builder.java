package com.senla.bookshop.ui.entities;

import com.senla.bookshop.ui.actions.book.*;
import com.senla.bookshop.ui.actions.exit.ExitAction;
import com.senla.bookshop.ui.actions.order.*;
import com.senla.bookshop.ui.actions.request.*;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public void buildMenu(){
        Menu mainMenu = new Menu("==================================\nMain menu");

        //Books entities
        Menu booksMenu = new Menu("==================================\nBooks menu");

        Menu sortAllBooksMenu = new Menu("==================================\nSort books menu");
        List<MenuItem> sortAllBooksMI = new ArrayList<>();
        sortAllBooksMI.add(new MenuItem("Sort by title", new SortBooksByTitle(),sortAllBooksMenu));
        sortAllBooksMI.add(new MenuItem("Sort by publish date",
                new SortBooksByPublishDate(),sortAllBooksMenu));
        sortAllBooksMI.add(new MenuItem("Sort by price", new SortBooksByPrice(),sortAllBooksMenu));
        sortAllBooksMI.add(new MenuItem("Sort by existence in stoke",
                                        new SortBooksByExistenceInStoke(),sortAllBooksMenu));
        sortAllBooksMI.add(new MenuItem("Back", null, booksMenu));
        sortAllBooksMenu.setMenuItems(sortAllBooksMI);

        Menu sortUnsoldBooksMenu = new Menu("==================================\nSort unsold books menu");
        List<MenuItem> sortUnsoldBooksMI = new ArrayList<>();
        sortUnsoldBooksMI.add(new MenuItem("Sort by receipt date", new SortUnsoldBooksByReceiptDate(),sortUnsoldBooksMenu));
        sortUnsoldBooksMI.add(new MenuItem("Sort by price", new SortUnsoldBooksByPrice(),sortUnsoldBooksMenu));
        sortUnsoldBooksMI.add(new MenuItem("Back", null, booksMenu));
        sortUnsoldBooksMenu.setMenuItems(sortUnsoldBooksMI);

        List<MenuItem> booksMenuItems = new ArrayList<>();
        booksMenuItems.add(new MenuItem("Add book", new AddBook(),booksMenu));
        booksMenuItems.add(new MenuItem("Delete book", new DeleteBook(),booksMenu));
        booksMenuItems.add(new MenuItem("Get all books", new GetAllBooks(),sortAllBooksMenu));
        booksMenuItems.add(new MenuItem("Get book", new GetBook(),booksMenu));
        booksMenuItems.add(new MenuItem("Get unsold books", new GetUnsoldBooks(),sortUnsoldBooksMenu));
        booksMenuItems.add(new MenuItem("Export books to CSV file", new ExportBooks(),booksMenu));
        booksMenuItems.add(new MenuItem("Import books from CSV file", new ImportBooks(),booksMenu));
        booksMenuItems.add(new MenuItem("Back", null, mainMenu));
        booksMenu.setMenuItems(booksMenuItems);

        //Orders menu
        Menu orderMenu = new Menu("==================================\nOrders menu");

        Menu sortOrdersMenu = new Menu("==================================\nSort orders menu");
        List<MenuItem> sortOrdersMI = new ArrayList<>();
        sortOrdersMI.add(new MenuItem("Sort by execution date", new SortOrdersByExecutionDate(), sortOrdersMenu));
        sortOrdersMI.add(new MenuItem("Sort by price", new SortOrdersByPrice(), sortOrdersMenu));
        sortOrdersMI.add(new MenuItem("Sort by status", new SortOrdersByStatus(), sortOrdersMenu));
        sortOrdersMI.add(new MenuItem("Back", null, orderMenu));
        sortOrdersMenu.setMenuItems(sortOrdersMI);

        Menu sortPerformedOrdersMenu = new Menu("==================================\nSort performed orders menu");
        List<MenuItem> sortPerformedOrdersMI = new ArrayList<>();
        sortPerformedOrdersMI.add(new MenuItem("Sort by execution date",
                                                new SortPerformedOrdersByDate(), sortPerformedOrdersMenu));
        sortPerformedOrdersMI.add(new MenuItem("Sort by price",
                                                new SortPerformedOrdersByPrice(), sortPerformedOrdersMenu));
        sortPerformedOrdersMI.add(new MenuItem("Back", null, orderMenu));
        sortPerformedOrdersMenu.setMenuItems(sortPerformedOrdersMI);

        List<MenuItem> ordersMenuItems = new ArrayList<>();
        ordersMenuItems.add(new MenuItem("Add order", new AddOrder(), orderMenu));
        ordersMenuItems.add(new MenuItem("Copy order", new CopyOrder(), orderMenu));
        ordersMenuItems.add(new MenuItem("Change information about the order", new ChangeOrderInfo(), orderMenu));
        ordersMenuItems.add(new MenuItem("Cancel order", new CancelOrder(), orderMenu));
        ordersMenuItems.add(new MenuItem("Complete an order", new CompleteAnOrder(), orderMenu));
        ordersMenuItems.add(new MenuItem("Get all orders", new GetAllOrders(), sortOrdersMenu));
        ordersMenuItems.add(new MenuItem("Get amount of performed orders",
                                            new GetAmountOfPerformedOrders(), orderMenu));
        ordersMenuItems.add(new MenuItem("Get earned money", new GetEarnedMoney(), orderMenu));
        ordersMenuItems.add(new MenuItem("Get order", new GetOrder(), orderMenu));
        ordersMenuItems.add(new MenuItem("Get performed orders",
                                            new GetPerformedOrders(), sortPerformedOrdersMenu));
        ordersMenuItems.add(new MenuItem("Export orders to CSV file", new ExportOrders(), orderMenu));
        ordersMenuItems.add(new MenuItem("Import orders from CSV file", new ImportOrders(), orderMenu));
        ordersMenuItems.add(new MenuItem("Back", null, mainMenu));
        orderMenu.setMenuItems(ordersMenuItems);

        //Requests menu
        Menu requestMenu = new Menu("==================================\nRequests menu");

        Menu sortRequestsMenu = new Menu("==================================\nSort requests menu");
        List<MenuItem> sortRequestsMI = new ArrayList<>();
        sortRequestsMI.add(new MenuItem("Sort by alphabet", new SortRequestsByAlphabet(), sortRequestsMenu));
        sortRequestsMI.add(new MenuItem("Sort by amount", new SortRequestsByAmount(), sortRequestsMenu));
        sortRequestsMI.add(new MenuItem("Back", null, requestMenu));
        sortRequestsMenu.setMenuItems(sortRequestsMI);

        List<MenuItem> requestsMenuItems = new ArrayList<>();
        requestsMenuItems.add(new MenuItem("Add request", new AddRequest(), requestMenu));
        requestsMenuItems.add(new MenuItem("Get all requests ", new GetAllRequests(), sortRequestsMenu));
        requestsMenuItems.add(new MenuItem("Export requests to CSV file", new ExportRequests(), requestMenu));
        requestsMenuItems.add(new MenuItem("Import requests from CSV file", new ImportRequests(), requestMenu));
        requestsMenuItems.add(new MenuItem("Back", null, mainMenu));
        requestMenu.setMenuItems(requestsMenuItems);


        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Books", null, booksMenu));
        menuItems.add(new MenuItem("Orders", null, orderMenu));
        menuItems.add(new MenuItem("Requests", null, requestMenu));
        menuItems.add(new MenuItem("Exit", new ExitAction(), null));

        mainMenu.setMenuItems(menuItems);

        rootMenu = mainMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
