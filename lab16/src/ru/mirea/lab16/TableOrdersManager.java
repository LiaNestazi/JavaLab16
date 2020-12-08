package ru.mirea.lab16;

public class TableOrdersManager implements OrdersManager{
    private Order[] orders;
    private int size;
    public TableOrdersManager(int size){
        this.size=size;
    }
    public void add(Order order, int tableNumber) throws IllegalTableNumber, OrderAlreadyAddedException{
        if (tableNumber>size){
            throw new IllegalTableNumber("Illegal table number:"+tableNumber);
        }
        if (orders == null){
            orders=new Order[size];
            orders[tableNumber]=order;
        }
        else{
            if (orders[tableNumber]!=null){
                throw new OrderAlreadyAddedException();
            }
            else{
                orders[tableNumber]=order;
            }
        }
    }
    public void add(MenuItem item,int tableNumber) throws IllegalTableNumber,OrderAlreadyAddedException{
        if (tableNumber>size){
            throw new IllegalTableNumber("Illegal table number:"+tableNumber);
        }
        if (orders == null){
            orders=new Order[size];
            orders[tableNumber].add(item);
        }
        else{
            if (orders[tableNumber]!=null){
                throw new OrderAlreadyAddedException();
            }
            else{
                orders[tableNumber].add(item);
            }
        }
    }
    public int freeTableNumber(){
        int number=-1;
        for (int i=0;i<orders.length;i++){
            if (orders[i].getItems()==null){
                number=i;
            }
        }
        return number;
    }
    public int[] freeTableNumbers(){
        int []numbers=new int[orders.length];
        int j=0;
        for (int i=0;i<orders.length;i++){
            if (orders[i].getItems()==null){
                numbers[j]=i;
                j++;
            }
        }
        return numbers;
    }
    public Order getOrder(int tableNumber) throws IllegalTableNumber, NullPointerException{
        if (size>tableNumber)
            return orders[tableNumber];
        else{
            throw new IllegalTableNumber("Illegal table number:"+tableNumber);
        }
    }

    public void remove(int tableNumber) throws IllegalTableNumber{
        if (size>tableNumber)
            orders[tableNumber]=null;
        else{
            throw new IllegalTableNumber("Illegal table number:"+tableNumber);
        }
    }
    public int remove(Order order){
        int number=-1;
        for (int i=0;i<orders.length;i++){
            if (orders[i].equals(order)){
                orders[i]=null;
                number=i;
                break;
            }
        }
        return number;
    }
    public int removeAll(Order order){
        int quantity=0;
        for (int i=0;i<orders.length;i++){
            if (orders[i].equals(order)){
                orders[i]=null;
                quantity++;
            }
        }
        return quantity;
    }
    public int itemsQuantity(String itemName){
        int quantity=0;
        for (int i=0;i<orders.length;i++){
            quantity+=orders[i].itemQuantity(itemName);
        }
        return quantity;
    }
    public int itemsQuantity(MenuItem item){
        int quantity=0;
        for (int i=0;i<orders.length;i++){
            quantity+=orders[i].itemQuantity(item);
        }
        return quantity;
    }
    public Order[] getOrders(){
        return orders;
    }
    public int ordersCostSummary(){
        int summary=0;
        for (int i=0;i<orders.length;i++){
            summary+=orders[i].costTotal();
        }
        return summary;
    }
    public int ordersQuantity(){
        int quantity=0;
        for (int i=0;i<orders.length;i++){
            if (orders[i]!=null){
                quantity++;
            }
        }
        return quantity;
    }

    public int getSize() {
        return size;
    }
}
