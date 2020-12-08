package ru.mirea.lab16;

import java.util.HashMap;

public class InternetOrder implements Order {
    private int size;
    private ListNode head;
    private ListNode tail;
    private Customer customer;
    public InternetOrder(){
        size=0;
        head=null;
        tail=null;
    }
    public boolean add(MenuItem item)
    {
        ListNode node = new ListNode(item);
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }
    public String[] itemsNames(){
        HashMap<Integer, String> priceName= new HashMap<>();
        ListNode temp=head;
        for (int i=0;i<size;i++){
            priceName.put(temp.getValue().getCost(),temp.getValue().getName());
            temp=temp.getNext();
        }
        int count=0;
        temp=head;
        for (int i=0;i<size;i++){
            if (!priceName.containsValue(temp.getValue().getName())){
                count++;
            }
            temp=temp.getNext();
        }
        String[] items= new String[count];
        temp=head;
        int j=0;
        for (int i=0;i<size;i++){
            if (!priceName.containsValue(temp.getValue().getName())){
                items[j]=temp.getValue().getName();
                j++;
            }
            temp=temp.getNext();
        }
        return items;
    }
    public int itemsQuantity(){
        return size;
    }
    public int itemQuantity(String itemName){
        int quantity=0;
        ListNode temp=head;
        for (int i=0;i<size;i++){
            if (temp.getValue().getName().equals(itemName))
                quantity++;
            temp=temp.getNext();
        }
        return quantity;
    }
    public int itemQuantity(MenuItem itemName){
        int quantity=0;
        ListNode temp=head;
        for (int i=0;i<size;i++){
            if (temp.getValue().equals(itemName))
                quantity++;
            temp=temp.getNext();
        }
        return quantity;
    }
    public MenuItem[] getItems(){
        MenuItem[] items = new MenuItem[size];
        ListNode temp = head;
        for (int i=0;i<size;i++){
            items[i]=temp.getValue();
            temp=temp.getNext();
        }
        return items;
    }
    public boolean remove (String itemName){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            if (curr.getValue().getName().equals(itemName)){
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
    public boolean remove (MenuItem itemName){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            if (curr.getValue().equals(itemName)){
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
    public int removeAll(String itemName){
        ListNode temp = head;
        int count=0;
        for (int i=0;i<size;i++){
            if (temp.getValue().getName().equals(itemName)){
                remove(itemName);
                count++;
            }
        }
        return count;
    }
    public int removeAll(MenuItem itemName){
        ListNode temp = head;
        int count=0;
        for (int i=0;i<size;i++){
            if (temp.getValue().equals(itemName)){
                remove(itemName);
                count++;
            }
        }
        return count;
    }
    private static void quickSort(MenuItem[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int supp = array[middle].getCost();

        int i = low, j = high;
        while (i <= j) {
            while (array[i].getCost() > supp) {
                i++;
            }

            while (array[j].getCost() < supp) {
                j--;
            }

            if (i <= j) {
                MenuItem temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public MenuItem[] sortedItemsByCostDesc(){
        MenuItem[] items=getItems();
        quickSort(items,0,size-1);
        return items;
    }
    public int costTotal(){
        int total=0;
        ListNode temp=head;
        for (int i=0;i<size;i++){
            total+=temp.getValue().getCost();
            temp=temp.getNext();
        }
        return total;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public void clear(){
        size=0;
        head=null;
        tail=null;
    }
}
