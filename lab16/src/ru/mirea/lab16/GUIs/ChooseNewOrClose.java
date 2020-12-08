package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.Customer;
import ru.mirea.lab16.InternetOrdersManager;
import ru.mirea.lab16.TableOrdersManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseNewOrClose extends JFrame {
    JButton newOrder, exit,allOrders;
    JLabel choose;
    public ChooseNewOrClose(JFrame custinfo, Customer customer, TableOrdersManager tm, InternetOrdersManager im){
        setTitle("New order?");
        setSize(240,170);
        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        choose=new JLabel("Do you want to place a new order?");
        newOrder=new JButton("New order");
        exit=new JButton("Exit");
        allOrders=new JButton("Check all orders");
        choose.setFont(new Font("Serif", Font.PLAIN, 16));
        newOrder.setFont(new Font("Serif", Font.PLAIN, 14));
        exit.setFont(new Font("Serif", Font.PLAIN, 14));
        allOrders.setFont(new Font("Serif", Font.PLAIN, 14));
        add(choose);
        add(newOrder);
        add(exit);
        add(allOrders);
        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerChoose(custinfo,customer,tm,im);
                dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        allOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AllOrders(ChooseNewOrClose.this,customer,tm,im);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
