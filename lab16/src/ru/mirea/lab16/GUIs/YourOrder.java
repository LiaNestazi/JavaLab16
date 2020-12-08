package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.*;
import ru.mirea.lab16.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class YourOrder extends JFrame {
    private JLabel your=new JLabel("Your order");
    private JCheckBox []items;
    JButton delete, confirm,back,cancel;
    public YourOrder(Order order, JFrame custinfo,JFrame prev, Customer customer, boolean isTable, int tableNum, TableOrdersManager tm, InternetOrdersManager im){
        setTitle("Your order");
        setSize(580,600);
        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        your.setFont(new Font("Serif", Font.PLAIN, 20));
        MenuItem[] allItems=order.getItems();
        MenuItem[] menu=order.sortedItemsByCostDesc();
        items=new JCheckBox[menu.length];
        delete=new JButton("Delete selected");
        confirm=new JButton("Confirm Order");
        back=new JButton("Back");
        cancel=new JButton("Cancel order");
        delete.setFont(new Font("Serif", Font.PLAIN, 14));
        confirm.setFont(new Font("Serif", Font.PLAIN, 14));
        back.setFont(new Font("Serif", Font.PLAIN, 14));
        cancel.setFont(new Font("Serif", Font.PLAIN, 14));
        add(your);
        if (isTable){
            JLabel table=new JLabel("for table:"+tableNum);
            table.setFont(new Font("Serif", Font.PLAIN, 20));
            add(table);
        }
        JPanel main=new JPanel();
        JPanel card=new JPanel();
        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        for (int i=0;i<menu.length;i++){
            items[i]=new JCheckBox(menu[i].toString());
            items[i].setFont(new Font("Serif", Font.PLAIN, 14));
            card.add(items[i]);
        }
        main.add(card);
        JScrollPane scrollPane = new JScrollPane(main,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,400));
        add(scrollPane);
        add(back);
        add(delete);
        add(confirm);
        add(cancel);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<items.length;i++)
                    if (items[i].isSelected()){
                        order.remove(menu[i]);
                        card.remove(items[i]);
                        revalidate();
                        repaint();
                    }
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean exception=false;
                JPanel temp=new JPanel();
                if (card.getComponentCount()==0){
                    JOptionPane.showMessageDialog(getContentPane(),"Your order is empty. It will be cancelled.");
                    dispose();
                    new ChooseNewOrClose(custinfo,customer,tm,im);
                }
                else {
                    if (isTable){
                        try {
                            tm.add(order, tableNum-1);
                        }
                        catch (OrderAlreadyAddedException ex){
                            JOptionPane.showMessageDialog(getContentPane(),"Order for that table was already added");
                            exception=true;
                            order.clear();
                            prev.setVisible(true);
                            setVisible(false);
                        }
                        catch (IllegalTableNumber ex2){
                            exception=true;
                            JOptionPane.showMessageDialog(getContentPane(),"Table num is incorrect");
                        }
                    }
                    else{
                        im.add(order);
                    }
                    if (!exception) {
                        JOptionPane.showMessageDialog(getContentPane(), "Your order has been successfully placed.");
                        setVisible(false);
                        new ChooseNewOrClose(custinfo, customer, tm, im);
                    }
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order.clear();
                prev.setVisible(true);
                setVisible(false);
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(),"Your order has been cancelled.");
                dispose();
                new ChooseNewOrClose(custinfo,customer,tm,im);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
