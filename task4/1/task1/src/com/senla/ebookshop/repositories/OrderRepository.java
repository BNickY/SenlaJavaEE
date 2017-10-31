package com.senla.ebookshop.repositories;

import com.senla.ebookshop.comparators.order.ExecutionDateComparator;
import com.senla.ebookshop.comparators.order.OrderPriceComparator;
import com.senla.ebookshop.comparators.order.OrderStatusComparator;
import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.model.orderstatus.OrderStatus;
import com.senla.ebookshop.utils.ArrayWorker;
import com.senla.ebookshop.utils.Printer;
import java.time.LocalDate;
import java.util.Arrays;

public class OrderRepository {
    private Order[] orders = new Order[ArrayWorker.getStartSize()];
    private static int id = 0;

    public Order[] getAllOrders() {
        return orders;
    }

    public void addOrder(Order order){
        if(!ArrayWorker.hasEmptySpace(orders))
            orders = (Order[]) ArrayWorker.expandArray(orders);

        int position = ArrayWorker.getNextFreePosition(orders);
        order.setId(id);
        id++;
        order.setOrderStatus(OrderStatus.ACCEPTED);
        orders[position] = order;
    }

    public void deleteOrder(int id){
        for (int i = 0; i < orders.length; i++)
            if(orders[i] != null && orders[i].getId() == id)
                orders[i].setOrderStatus(OrderStatus.CANCELED);
    }

    public Order getOrder(int id){
        return (Order) ArrayWorker.findById(orders,id);
    }

    public void refreshOrderArray(){
        orders = (Order[]) ArrayWorker.compressArray(orders);
    }

    public Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate){
        Order[] performedOrders = new Order[orders.length];
        for(int i = 0; i < orders.length; i++){
            if(orders[i] == null)
                performedOrders[i] = null;
            else if(orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate))
                performedOrders[i] = orders[i];
            else performedOrders[i] = null;
        }
        performedOrders = (Order[]) ArrayWorker.compressArray(performedOrders);
        return performedOrders;
    }

    public double getEarnedMoney(LocalDate startDate, LocalDate endDate){
        double sum = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i] != null && (orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate)))
                sum += orders[i].getPrice();
        }
        return sum;
    }

    public int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate){
        int amount = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i] != null && (orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate)))
                amount++;
        }
        return amount;
    }

    public void completeAnOrder(Order order, BookRepository bookRepository){
        if(bookRepository.getBook(order.getBook().getId()).getInStoke()){
            bookRepository.deleteBook(order.getBook().getId());
            order.setOrderStatus(OrderStatus.PERFORMED);
        }else{
            Printer.printMessage("Can't complete the order! No such book in stock.");
            order.setOrderStatus(OrderStatus.CANCELED);
        }
    }

    public Order[] sortOrdersByExecutionDate(Order[] ordersArray) {
        Arrays.sort(ordersArray, new ExecutionDateComparator());
        Printer.printMessage("Sorted by execution date");
        return ordersArray;
    }

    public Order[] sortOrdersByPrice(Order[] ordersArray) {
        Arrays.sort(ordersArray, new OrderPriceComparator());
        Printer.printMessage("Sorted by price");
        return ordersArray;
    }

    public Order[] sortOrdersByStatus(Order[] ordersArray) {
        Arrays.sort(ordersArray, new OrderStatusComparator());
        Printer.printMessage("Sorted by status");
        return ordersArray;
    }
}
