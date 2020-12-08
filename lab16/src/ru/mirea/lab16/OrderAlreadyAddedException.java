package ru.mirea.lab16;

public class OrderAlreadyAddedException extends Throwable {
    @Override
    public String getMessage() {
        return "Order already added";
    }
}
