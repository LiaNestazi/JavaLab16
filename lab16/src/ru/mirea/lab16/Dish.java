package ru.mirea.lab16;

public final class Dish extends MenuItem {
    public Dish(int cost, String name, String description) throws IllegalArgumentException{
        if (cost<0){
            throw new IllegalArgumentException("Cost<0");
        }
        if (name.equals("")){
            throw new IllegalArgumentException("Name is empty");
        }
        if (description.equals("")){
            throw new IllegalArgumentException("Description is empty");
        }
        setCost(cost);
        setName(name);
        setDescription(description);
    }
}
