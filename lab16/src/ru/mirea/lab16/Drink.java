package ru.mirea.lab16;

public final class Drink extends MenuItem implements Alcoholable{
    private double alcoholVol;
    private DrinkTypeEnum type;
    public Drink(String name, String description, DrinkTypeEnum type,double alcoholVol) throws IllegalArgumentException{
        if (name.equals("")){
            throw new IllegalArgumentException("Name is empty");
        }
        if (description.equals("")){
            throw new IllegalArgumentException("Description is empty");
        }
        if (alcoholVol<0){
            throw new IllegalArgumentException("Alcohol volume<0");
        }
        setCost(0);
        setName(name);
        setDescription(description);
        this.type=type;
        this.alcoholVol=alcoholVol;
    }
    public Drink(int cost, String name, String description, DrinkTypeEnum type, double alcoholVol){
        if (cost<0){
            throw new IllegalArgumentException("Cost<0");
        }
        if (name.equals("")){
            throw new IllegalArgumentException("Name is empty");
        }
        if (description.equals("")){
            throw new IllegalArgumentException("Description is empty");
        }
        if (alcoholVol<0){
            throw new IllegalArgumentException("Alcohol volume<0");
        }
        setCost(cost);
        setName(name);
        setDescription(description);
        this.type=type;
        this.alcoholVol=alcoholVol;
    }
    public DrinkTypeEnum getType() {
        return type;
    }
    public double getAlcoholVol() {
        return alcoholVol;
    }
    public boolean isAlcoholicDrink(){
        if (type == DrinkTypeEnum.JUICE ||
                type == DrinkTypeEnum.COFFEE ||
                type == DrinkTypeEnum.GREEN_TEA ||
                type == DrinkTypeEnum.BLACK_TEA ||
                type == DrinkTypeEnum.MILK ||
                type == DrinkTypeEnum.WATER ||
                type == DrinkTypeEnum.SODA)
            return false;
        else return true;
    }
}
