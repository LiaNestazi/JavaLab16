package ru.mirea.lab16;

public class InternetOrdersManager implements OrdersManager{
    private QueueNode head;
    private QueueNode tail;
    private int size;
    public InternetOrdersManager(){
        size=0;
        head=null;
        tail=null;
    }
    public boolean add(Order order){
        QueueNode node = new QueueNode(order);
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            tail.setPrev(tail);
            tail = node;
        }
        size++;
        return true;
    }
    public boolean remove(int point){
        QueueNode temp=head;
        for (int i=0;i<point;i++){
            temp=temp.getNext();
        }
        QueueNode prev = null;
        QueueNode curr = head;
        while (curr != null){
            if (curr.getValue().equals(temp.getValue())){
                if (prev != null){
                    prev.setNext(curr.getNext());
                    if (curr.getNext() == null)
                        tail=prev;
                }
                else {
                    head=head.getNext();
                    if (head == null){
                        tail=null;
                    }
                }
                size--;
                return true;
            }
            prev=curr;
            curr=curr.getNext();
        }
        return false;
    }
    public Order order(int point){
        QueueNode temp = head;
        for (int i=0;i<point;i++){
            temp=temp.getNext();
        }
        return temp.getValue();
    }
    public int itemsQuantity(String itemName){
        QueueNode temp = head;
        int quantity=0;
        for (int i=0;i<size;i++){
            quantity+=temp.getValue().itemQuantity(itemName);
            temp=temp.getNext();
        }
        return quantity;
    }
    public int itemsQuantity(MenuItem item){
        QueueNode temp = head;
        int quantity=0;
        for (int i=0;i<size;i++){
            quantity+=temp.getValue().itemQuantity(item);
            temp=temp.getNext();
        }
        return quantity;
    }
    public Order[] getOrders(){
        Order[] items = new Order[size];
        QueueNode temp = head;
        for (int i=0;i<size;i++){
            items[i]=temp.getValue();
            temp=temp.getNext();
        }
        return items;
    }
    public int ordersCostSummary(){
        int total=0;
        QueueNode temp=head;
        for (int i=0;i<size;i++){
            total+=temp.getValue().costTotal();
            temp=temp.getNext();
        }
        return total;
    }
    public int ordersQuantity(){
        return size;
    }

    public int getSize() {
        return size;
    }
}
