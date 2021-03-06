package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.Printer;

import static com.senla.bookshop.utils.ConsoleReader.*;
import static com.senla.bookshop.utils.Printer.*;
import java.time.LocalDate;

public class ChangeOrderInfo implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();

        printArray(facade.getAllOrders());
        printMessage("\nChoose order to change (enter order id): ");
        Order order = (Order) facade.getOrder(getNextLong());
        if(order == null){
            Printer.printMessage("There is no order with such id");
        }else {
            printMessage("\n1.Change execution date");
            printMessage("2.Change status");
            int choice = getNextInt();
            if (choice == 1) {
                printMessage("Enter order execution date (yyyy-MM-dd): ");
                LocalDate executionDate = getDate();
                if (executionDate.isAfter(order.getSubmissionDate())) {
                    order.setExecutionDate(executionDate);
                } else printMessage("Execution date can't be before submission date! Date doesn't changed.");
            } else if (choice == 2) {
                printMessage("Choose status:\n1.Accepted\n2.Performed\n3.Canceled");
                int statusNumber = getNextInt();
                switch (statusNumber) {
                    case 1: {
                        order.setOrderStatus(OrderStatus.ACCEPTED);
                        break;
                    }
                    case 2: {
                        order.setOrderStatus(OrderStatus.PERFORMED);
                        break;
                    }
                    case 3: {
                        order.setOrderStatus(OrderStatus.CANCELED);
                        break;
                    }
                }
            } else printMessage("Nothing changed.");
        }
    }
}