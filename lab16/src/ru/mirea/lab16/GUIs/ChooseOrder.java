package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChooseOrder extends JFrame {
    JButton internet, table,back;
    JLabel choose;
    public ChooseOrder(JFrame custinfo, JFrame prev, Customer customer, TableOrdersManager tm, InternetOrdersManager im){
        setTitle("Order Type");
        setSize(160,200);
        setResizable(false);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        choose=new JLabel("Choose type of order:");
        internet=new JButton("Internet order");
        table=new JButton("Table Order");
        back=new JButton("Back");
        choose.setFont(new Font("Serif", Font.PLAIN, 16));
        internet.setFont(new Font("Serif", Font.PLAIN, 14));
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        back.setFont(new Font("Serif", Font.PLAIN, 14));
        add(choose);
        add(internet);
        add(table);
        add(back);
        internet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Address empty=new Address();
                if (customer.getAddress()==null){
                    JOptionPane.showMessageDialog(getContentPane(),"You can't make internet orders without address");
                    setVisible(false);
                    dispose();
                    custinfo.setVisible(true);
                }
                else {
                    new InternetOrderUI(custinfo,ChooseOrder.this, customer,tm,im);
                    setVisible(false);
                }
            }
        });
        table.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableOrderUI(custinfo,ChooseOrder.this,customer,tm,im);
                setVisible(false);
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
}
