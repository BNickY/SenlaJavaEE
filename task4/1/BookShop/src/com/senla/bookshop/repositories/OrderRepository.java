package com.senla.bookshop.repositories;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.orderstatus.OrderStatus;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.TextFileUtil;
import com.senla.bookshop.utils.TextParser;

public class OrderRepository {
    private static final String filePath = "data_files/orders.txt";
    private TextFileUtil textFileUtil = new TextFileUtil(filePath);
    private Order[] orders;
    private static long nextId = 0;

    public OrderRepository() {
        orders = new Order[ArrayWorker.START_SIZE];
    }

    public Order[] getAllOrders() {
        return orders;
    }

    public void addOrder(Order order){
        if(!ArrayWorker.hasEmptySpace(orders))
            orders = (Order[]) ArrayWorker.expandArray(orders);

        int position = ArrayWorker.getNextFreePosition(orders);
        order.setId(nextId);
        order.setPrice(order.getBook().getPrice());
        nextId++;
        order.setOrderStatus(OrderStatus.ACCEPTED);
        orders[position] = order;
    }

    public void deleteOrder(long id){
        for (int i = 0; i < orders.length; i++)
            if(orders[i] != null && orders[i].getId() == id)
                orders[i].setOrderStatus(OrderStatus.CANCELED);
    }

    public Order getOrder(long id){
        return (Order) ArrayWorker.findById(orders,id);
    }

    public void saveToFile(){
        orders = (Order[]) ArrayWorker.compressArray(orders);
        textFileUtil.writeDataToFile(TextParser.parseEntities(orders));
    }

    public void readFromFile(){
        orders = TextParser.parseOrderStrings(textFileUtil.readDataFromFile());
        nextId = orders[orders.length-1].getId() + 1;
    }
}
