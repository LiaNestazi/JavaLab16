package ru.mirea.lab16;

public class MenuItem {
    private int cost;
    private String name;
    private String description;

    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String toString(){
        return "Name:"+this.name+" Description:"+this.description+" Price:"+this.cost+"rub";
    }
}
