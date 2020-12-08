package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InternetOrderUI extends JFrame {
    private InternetOrder order;
    private JLabel menu, drinks, dishes;
    private JCheckBox []drinksArray;
    private JTextField []drinksCount;
    private JTextField []dishesCount;
    private JCheckBox []dishesArray;
    private JButton confirm,clear,back;
    private Drink []drink=new Drink[18];
    private Dish []dish=new Dish[8];
    public InternetOrderUI(JFrame custinfo,JFrame prev, Customer customer,TableOrdersManager tm, InternetOrdersManager im){
        setTitle("Internet order");
        setSize(1100,600);
        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        order=new InternetOrder();
        drinksArray=new JCheckBox[18];
        drinksCount=new JTextField[18];
        dishesCount=new JTextField[8];
        dishesArray=new JCheckBox[8];
        confirm=new JButton("Confirm");
        clear=new JButton("Clear");
        back=new JButton("Back");
        confirm.setFont(new Font("Serif", Font.PLAIN, 14));
        clear.setFont(new Font("Serif", Font.PLAIN, 14));
        back.setFont(new Font("Serif", Font.PLAIN, 14));
        menu=new JLabel("Menu:");
        menu.setFont(new Font("Serif", Font.PLAIN, 20));
        drinks=new JLabel("Drinks:");
        drinks.setFont(new Font("Serif", Font.PLAIN, 20));
        dishes=new JLabel("Dishes:");
        dishes.setFont(new Font("Serif", Font.PLAIN, 20));
        createDrinksList();
        JPanel main=new JPanel();
        JPanel card=new JPanel();
        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        add(menu);
        card.add(drinks);
        for (int i=0;i<drinksArray.length;i++){
            drinksArray[i].setFont(new Font("Serif", Font.PLAIN, 14));
            card.add(drinksArray[i]);
            drinksCount[i]=new JTextField();
            JLabel count=new JLabel("Count:");
            count.setFont(new Font("Serif", Font.PLAIN, 12));
            card.add(count);
            card.add(drinksCount[i]);
        }
        main.add(card);
        JScrollPane scrollPane = new JScrollPane(main,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,400));
        add(scrollPane);
        JPanel main2=new JPanel();
        JPanel card2=new JPanel();
        card2.setLayout(new BoxLayout(card2,BoxLayout.Y_AXIS));
        card2.add(dishes);
        createDishesList();
        for (int i=0;i<dishesArray.length;i++){
            dishesArray[i].setFont(new Font("Serif", Font.PLAIN, 14));
            card2.add(dishesArray[i]);
            dishesCount[i]=new JTextField();
            JLabel count=new JLabel("Count:");
            count.setFont(new Font("Serif", Font.PLAIN, 12));
            card2.add(count);
            card2.add(dishesCount[i]);
        }
        main2.add(card2);
        JScrollPane scrollPane2 = new JScrollPane(main2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setPreferredSize(new Dimension(500,400));
        add(scrollPane2);
        add(back);
        add(confirm);
        add(clear);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order.setCustomer(customer);
                for (int i=0;i<drinksArray.length;i++){
                    if (drink[i].isAlcoholicDrink()&&drinksArray[i].isSelected()){
                        if (customer.getAge()<18){
                            drinksArray[i].setSelected(false);
                            JOptionPane.showMessageDialog(getContentPane(),"You can't order alcohol");
                        }
                    }
                    if (drinksArray[i].isSelected()){
                        if (drinksCount[i].getText().equals("")){
                            order.add(drink[i]);
                        }
                        else {
                            int count=1;
                            try {
                                count=Integer.parseInt(drinksCount[i].getText());
                            }
                            catch (IllegalArgumentException ex){
                                JOptionPane.showMessageDialog(getContentPane(), "Drink count field is incorrect");
                            }
                            for (int j = 0; j < count; j++) {
                                order.add(drink[i]);
                            }
                        }
                    }
                }
                for (int i=0;i<dishesArray.length;i++){
                    if (dishesArray[i].isSelected()){
                        if (dishesCount[i].getText().equals("")){
                            order.add(dish[i]);
                        }
                        else {
                            int count=1;
                            try {
                                count=Integer.parseInt(dishesCount[i].getText());
                            }
                            catch (IllegalArgumentException ex){
                                JOptionPane.showMessageDialog(getContentPane(), "Dish count field is incorrect");
                            }
                            for (int j = 0; j < count; j++) {
                                order.add(dish[i]);
                            }
                        }
                    }
                }
                new YourOrder(order,custinfo,InternetOrderUI.this,customer,false,0,tm, im);
                setVisible(false);
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<drinksArray.length;i++){
                    drinksArray[i].setSelected(false);
                }
                for (int i=0;i<dishesArray.length;i++){
                    dishesArray[i].setSelected(false);
                }
                for (int i=0;i<drinksCount.length;i++){
                    drinksCount[i].setText("");
                }
                for (int i=0;i<dishesCount.length;i++){
                    dishesCount[i].setText("");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                prev.setVisible(true);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void clearOrder(){
        order=new InternetOrder();
    }
    public void createDishesList(){
        dish[0]=new Dish(340,"Pibim Namyong", "Korean noodle dish");
        dishesArray[0]=new JCheckBox(dish[0].toString());
        dish[1]=new Dish(390,"Chapchhae", "Korean noodle dish");
        dishesArray[1]=new JCheckBox(dish[1].toString());
        dish[2]=new Dish(290,"Chaja Myong", "Korean noodle dish");
        dishesArray[2]=new JCheckBox(dish[2].toString());
        dish[3]=new Dish(490,"Tokpokki", "Korean beef dish");
        dishesArray[3]=new JCheckBox(dish[3].toString());
        dish[4]=new Dish(450,"Pulgogi", "Korean beef dish");
        dishesArray[4]=new JCheckBox(dish[4].toString());
        dish[5]=new Dish(490,"Chicken Fry", "Korean chicken dish");
        dishesArray[5]=new JCheckBox(dish[5].toString());
        dish[6]=new Dish(380,"Takogi Teriyaki", "Korean chicken dish");
        dishesArray[6]=new JCheckBox(dish[6].toString());
        dish[7]=new Dish(290,"Kanpongi", "Korean chicken dish");
        dishesArray[7]=new JCheckBox(dish[7].toString());
    }
    public void createDrinksList(){
        drink[0]=new Drink(150,"Beer","Usual Beer", DrinkTypeEnum.BEER,4.5);
        drinksArray[0]=new JCheckBox(drink[0].toString());
        drink[1]=new Drink(250,"Wine","Red Wine", DrinkTypeEnum.WINE,4.5);
        drinksArray[1]=new JCheckBox(drink[1].toString());
        drink[2]=new Drink(175,"Vodka","Usual Vodka", DrinkTypeEnum.VODKA,4.5);
        drinksArray[2]=new JCheckBox(drink[2].toString());
        drink[3]=new Drink(185,"Brandy","Usual Brandy", DrinkTypeEnum.BRANDY,4.5);
        drinksArray[3]=new JCheckBox(drink[3].toString());
        drink[4]=new Drink(265,"Champagne","Usual Champagne", DrinkTypeEnum.CHAMPAGNE,4.5);
        drinksArray[4]=new JCheckBox(drink[4].toString());
        drink[5]=new Drink(300,"Whiskey","Good Whiskey", DrinkTypeEnum.WHISKEY,4.5);
        drinksArray[5]=new JCheckBox(drink[5].toString());
        drink[6]=new Drink(255,"Tequila","Usual Tequila", DrinkTypeEnum.TEQUILA,4.5);
        drinksArray[6]=new JCheckBox(drink[6].toString());
        drink[7]=new Drink(220,"Rum","Usual Rum", DrinkTypeEnum.RUM,4.5);
        drinksArray[7]=new JCheckBox(drink[7].toString());
        drink[8]=new Drink(237,"Vermuth","Usual Vermuth", DrinkTypeEnum.VERMUTH,4.5);
        drinksArray[8]=new JCheckBox(drink[8].toString());
        drink[9]=new Drink(268,"Liquor","Usual Liquor", DrinkTypeEnum.LIQUOR,4.5);
        drinksArray[9]=new JCheckBox(drink[9].toString());
        drink[10]=new Drink(325,"Jagermeister","Usual Jagermeister", DrinkTypeEnum.JAGERMEISTER,4.5);
        drinksArray[10]=new JCheckBox(drink[10].toString());
        drink[11]=new Drink(150,"Juice","Orange juice", DrinkTypeEnum.JUICE,0);
        drinksArray[11]=new JCheckBox(drink[11].toString());
        drink[12]=new Drink(199,"Coffee","Usual Coffee", DrinkTypeEnum.COFFEE,0);
        drinksArray[12]=new JCheckBox(drink[12].toString());
        drink[13]=new Drink(125,"Green tea","Usual Green tea", DrinkTypeEnum.GREEN_TEA,0);
        drinksArray[13]=new JCheckBox(drink[13].toString());
        drink[14]=new Drink(110,"Black tea","Usual Black tea", DrinkTypeEnum.BLACK_TEA,0);
        drinksArray[14]=new JCheckBox(drink[14].toString());
        drink[15]=new Drink(160,"Milk","Usual Milk", DrinkTypeEnum.MILK,0);
        drinksArray[15]=new JCheckBox(drink[15].toString());
        drink[16]=new Drink(100,"Water","Usual Water", DrinkTypeEnum.WATER,0);
        drinksArray[16]=new JCheckBox(drink[16].toString());
        drink[17]=new Drink(140,"Soda","Usual Soda", DrinkTypeEnum.SODA,0);
        drinksArray[17]=new JCheckBox(drink[17].toString());
    }
}
