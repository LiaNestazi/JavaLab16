package ru.mirea.lab16.GUIs;

import ru.mirea.lab16.Address;
import ru.mirea.lab16.Customer;
import ru.mirea.lab16.InternetOrdersManager;
import ru.mirea.lab16.TableOrdersManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfo extends JFrame {
    Customer customer;
    Address custAdd;
    private JTextField firstName=new JTextField(15);
    private JTextField secondName=new JTextField(15);
    private JTextField age=new JTextField(15);
    private JLabel info, first, second, ageLabel, addressLabel,cityLabel, streetLabel, buildNumLabel, buildLetLabel, apartNumLabel, zipCodeLabel;
    private JTextField cityName=new JTextField(15);
    private JTextField streetName=new JTextField(15);
    private JTextField buildingNumber=new JTextField(15);
    private JTextField buildingLetter=new JTextField(15);
    private JTextField apartNumber=new JTextField(15);
    private JTextField zipCode=new JTextField(15);
    private JButton clearName, clearAdd,next;
    public CustomerInfo(TableOrdersManager tm,InternetOrdersManager im){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Customer info");
        setSize(550,350);
        setResizable(false);
        setLayout(new FlowLayout());
        info=new JLabel("Customer information:");
        first=new JLabel("First name:");
        second=new JLabel("Second name:");
        ageLabel=new JLabel("Age:");
        addressLabel= new JLabel("Customer address:");
        cityLabel=new JLabel("City:");
        streetLabel=new JLabel("Street:");
        buildNumLabel=new JLabel("Building number:");
        buildLetLabel=new JLabel("Building letter (optional):");
        apartNumLabel=new JLabel("Apartment number:");
        zipCodeLabel=new JLabel("Zip Code:");
        clearName=new JButton("Clear Info");
        clearAdd=new JButton("Clear Address");
        next=new JButton("Next");
        info.setFont(new Font("Serif", Font.PLAIN, 20));
        first.setFont(new Font("Serif", Font.PLAIN, 14));
        second.setFont(new Font("Serif", Font.PLAIN, 14));
        ageLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        addressLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cityLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        streetLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        buildNumLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        buildLetLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        apartNumLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        zipCodeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        clearName.setFont(new Font("Serif", Font.PLAIN, 14));
        clearAdd.setFont(new Font("Serif", Font.PLAIN, 14));
        next.setFont(new Font("Serif", Font.PLAIN, 14));
        JPanel card=new JPanel();
        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        JPanel card2=new JPanel();
        card2.setLayout(new BoxLayout(card2,BoxLayout.Y_AXIS));
        JPanel card3=new JPanel();
        JPanel card4=new JPanel();
        JPanel card5=new JPanel();
        JPanel card6=new JPanel();
        card.add(info);
        card.add(first);
        card.add(firstName);
        card.add(second);
        card.add(secondName);
        card.add(ageLabel);
        card.add(age);
        card2.add(addressLabel);
        card2.add(cityLabel);
        card2.add(cityName);
        card2.add(streetLabel);
        card2.add(streetName);
        card2.add(buildNumLabel);
        card2.add(buildingNumber);
        card2.add(buildLetLabel);
        card2.add(buildingLetter);
        card2.add(apartNumLabel);
        card2.add(apartNumber);
        card2.add(zipCodeLabel);
        card2.add(zipCode);
        card3.add(clearName);
        card3.add(clearAdd);
        card3.add(next);
        add(card);
        add(card2);
        add(card3);
        clearName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName.setText("");
                secondName.setText("");
                age.setText("");
            }
        });
        clearAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cityName.setText("");
                streetName.setText("");
                buildingNumber.setText("");
                buildingLetter.setText("");
                apartNumber.setText("");
                zipCode.setText("");
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!buildingLetter.getText().equals(""))
                        custAdd = new Address(cityName.getText(), streetName.getText(), Integer.parseInt(buildingNumber.getText()), buildingLetter.getText().charAt(0), Integer.parseInt(apartNumber.getText()), Integer.parseInt(zipCode.getText()));
                    else
                        custAdd = new Address(cityName.getText(), streetName.getText(), Integer.parseInt(buildingNumber.getText()), ' ', Integer.parseInt(apartNumber.getText()), Integer.parseInt(zipCode.getText()));
                }
                catch (IllegalArgumentException ex1){
                    if (buildingNumber.getText().length()>0) {
                        JOptionPane.showMessageDialog(getContentPane(), "Building number is filled incorrectly");
                        buildingNumber.setText("");
                    }
                    if (buildingLetter.getText().length()>1){
                        JOptionPane.showMessageDialog(getContentPane(),"Building letter is filled incorrectly");
                        buildingLetter.setText("");
                    }
                    if (apartNumber.getText().length()>0) {
                        JOptionPane.showMessageDialog(getContentPane(), "Apartment number is filled incorrectly");
                        apartNumber.setText("");
                    }
                    if (zipCode.getText().length()>0) {
                        JOptionPane.showMessageDialog(getContentPane(), "Zip code is filled incorrectly");
                        zipCode.setText("");
                    }
                }
                if (cityName.getText().equals("")||streetName.getText().equals("")||buildingNumber.getText().equals("")||apartNumber.getText().equals("")||zipCode.getText().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "Address is not filled");
                    cityName.setText("");
                    streetName.setText("");
                    buildingNumber.setText("");
                    buildingLetter.setText("");
                    apartNumber.setText("");
                    zipCode.setText("");
                }
                try{
                    customer=new Customer(firstName.getText(),secondName.getText(),Integer.parseInt(age.getText()),custAdd);
                }catch (IllegalArgumentException ex){
                    if (firstName.getText().length()<1||secondName.getText().length()<1)
                        JOptionPane.showMessageDialog(getContentPane(),"Name fields cannot be empty");
                    if (age.getText().length()==0)
                        JOptionPane.showMessageDialog(getContentPane(),"Age field cannot be empty");
                    else {
                        if (ex.getClass().equals(NumberFormatException.class)) {
                            JOptionPane.showMessageDialog(getContentPane(), "Age field is filled incorrectly");
                            age.setText("");
                        }
                    }
                }
                if (!firstName.getText().equals("")&&!secondName.getText().equals("")&&!age.getText().equals("")){
                    new ChooseOrder(CustomerInfo.this,CustomerInfo.this, customer,tm,im);
                    setVisible(false);
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TableOrdersManager tableManager=new TableOrdersManager(5);
        InternetOrdersManager internetManager=new InternetOrdersManager();
        new CustomerInfo(tableManager,internetManager);
    }
}
