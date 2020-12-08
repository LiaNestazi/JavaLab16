package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.*;
import ru.mirea.lab16.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllOrders extends JFrame {
    JLabel tableOrders=new JLabel("Table orders:");
    JLabel internetOrders=new JLabel("Internet orders:");
    JButton exit,ok;
    public AllOrders(JFrame prev, Customer customer,TableOrdersManager tm, InternetOrdersManager im){
        setTitle("All orders");
        setSize(550,600);
        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel main=new JPanel();
        JPanel card=new JPanel();
        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        tableOrders.setFont(new Font("Serif", Font.PLAIN, 18));
        internetOrders.setFont(new Font("Serif", Font.PLAIN, 18));
        exit=new JButton("Exit");
        ok=new JButton("Ok");
        exit.setFont(new Font("Serif", Font.PLAIN, 14));
        ok.setFont(new Font("Serif", Font.PLAIN, 14));
        card.add(tableOrders);
        for (int i=0;i<tm.getSize();i++){
            Order temp=new TableOrder();
            MenuItem []items;
            try {
                temp=tm.getOrder(i);
            } catch (IllegalTableNumber ex){
                JOptionPane.showMessageDialog(getContentPane(),"Illegal table number");
            }
            catch (NullPointerException ex1){
                temp=null;
            }
            if (temp!=null){
                items=temp.getItems();
                JLabel lbl=new JLabel("Order for table "+(i+1)+":");
                lbl.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(lbl);
                for (int j=0;j<items.length;j++){
                    JLabel it = new JLabel(items[j].toString());
                    it.setFont(new Font("Serif", Font.PLAIN, 14));
                    card.add(it);
                }
                int sum=temp.costTotal();
                JLabel total=new JLabel("Total="+sum+"rub");
                total.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(total);
                JLabel cst=new JLabel("Customer:");
                cst.setFont(new Font("Serif", Font.PLAIN, 14));
                JLabel info=new JLabel(temp.getCustomer().toString());
                info.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(cst);
                card.add(info);
            }
        }
        Order []orders=im.getOrders();
        card.add(internetOrders);
        for (int i=0;i<im.getSize();i++){
            MenuItem []items;
            if (orders!=null){
                items=orders[i].getItems();
                JLabel lbl=new JLabel("Internet order "+(i+1)+":");
                lbl.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(lbl);
                for (int j=0;j<items.length;j++){
                    JLabel it=new JLabel(items[j].toString());
                    it.setFont(new Font("Serif", Font.PLAIN, 14));
                    card.add(it);
                }
                int sum=orders[i].costTotal();
                JLabel total=new JLabel("Total="+sum+"rub");
                total.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(total);
                JLabel cst=new JLabel("Customer:");
                cst.setFont(new Font("Serif", Font.PLAIN, 14));
                JLabel info=new JLabel(orders[i].getCustomer().toString());
                info.setFont(new Font("Serif", Font.PLAIN, 14));
                JLabel custAdd=new JLabel("Address:");
                custAdd.setFont(new Font("Serif", Font.PLAIN, 14));
                Address ad=orders[i].getCustomer().getAddress();
                JLabel address=new JLabel(ad.toString());
                address.setFont(new Font("Serif", Font.PLAIN, 14));
                card.add(cst);
                card.add(info);
                card.add(custAdd);
                card.add(address);
            }
        }
        main.add(card);
        JScrollPane scrollPane = new JScrollPane(main,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(500,400));
        add(scrollPane);
        add(ok);
        add(exit);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                prev.setVisible(true);
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

    public static void main(String[] args) {
        //new AllOrders(new TableOrdersManager(5),new InternetOrdersManager());
    }
}
