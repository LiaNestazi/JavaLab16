package ru.mirea.lab16;

public class ListNode {
    private ListNode next;
    private MenuItem value;

    public ListNode(MenuItem value){
        this.value=value;
    }
    public void setValue(MenuItem value) {
        this.value = value;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    public MenuItem getValue() {
        return value;
    }
    public ListNode getNext() {
        return next;
    }
    public String toString(){
        return value.getName();
    }
}
