package ru.mirea.lab16;

public final class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    private Customer MATURE_UNKNOWN_CUSTOMER;
    private Customer NOT_MATURE_UNKNOWN_CUSTOMER;
    public Customer(String firstName, String secondName, int age, Address address) throws IllegalArgumentException{
        if (firstName.equals("")||secondName.equals("")){
            throw new IllegalArgumentException("First or second name is empty");
        }
        if (age<0){
            throw new IllegalArgumentException("Age<0");
        }
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
        this.address=address;
        if (age<18){
            NOT_MATURE_UNKNOWN_CUSTOMER=this;
        }
        else {
            MATURE_UNKNOWN_CUSTOMER=this;
        }
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() {
        return address;
    }
    public String toString(){
        return "First name:"+firstName+" Second name:"+secondName+" Age:"+age;
    }
}
