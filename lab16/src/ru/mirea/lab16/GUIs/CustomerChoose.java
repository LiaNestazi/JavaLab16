package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.Customer;
import ru.mirea.lab16.InternetOrder;
import ru.mirea.lab16.InternetOrdersManager;
import ru.mirea.lab16.TableOrdersManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerChoose extends JFrame {
    JButton old, newCust, exit;
    JLabel choose;
    public CustomerChoose(JFrame custinfo, Customer customer, TableOrdersManager tm, InternetOrdersManager im){
        setTitle("Order Type");
        setSize(250,170);
        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        choose=new JLabel("Do you want to create new customer?");
        newCust=new JButton("Yes");
        old=new JButton("No");
        exit=new JButton("Exit");
        choose.setFont(new Font("Serif", Font.PLAIN, 16));
        newCust.setFont(new Font("Serif", Font.PLAIN, 14));
        old.setFont(new Font("Serif", Font.PLAIN, 14));
        exit.setFont(new Font("Serif", Font.PLAIN, 14));
        add(choose);
        add(newCust);
        add(old);
        add(exit);
        newCust.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerInfo(tm,im);
                setVisible(false);
                dispose();
            }
        });
        old.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChooseOrder(custinfo,CustomerChoose.this,customer,tm,im);
                setVisible(false);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
