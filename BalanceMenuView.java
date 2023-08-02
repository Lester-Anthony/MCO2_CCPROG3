import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BalanceMenuView {
    private RegularVMModel vm;
    private ArrayList<Denomination> balance;
    
    GridBagConstraints gbc = new GridBagConstraints();

    Denomination currentDenomination;
    
    // Fonts
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 15);

    // Elements
    JFrame frame = new JFrame("Vending Machine");
    
    JPanel panelDenominationList = new JPanel();
    JPanel panelDenominationInfo = new JPanel();
    
    JLabel labelDenominationNameLabel = new JLabel("Name  :  ");
    JLabel labelDenominationValueLabel = new JLabel("Value  :  ");
    JLabel labelDenominationQuantityLabel = new JLabel("Quantity  :  ");
    
    JLabel labelDenominationName = new JLabel(" ");
    JLabel labelDenominationValue = new JLabel(" ");
    JLabel labelDenominationQuantity = new JLabel(" ");
        
    JTextField textFieldQuantity = new JTextField("1");
    
    public BalanceMenuView(RegularVMModel vm, ArrayList<Denomination> balance) {

        this.vm = vm;
        
        // Item List Panel
        panelDenominationList.setBounds(10,10,450,940);
        panelDenominationList.setBackground(Color.GRAY);
        panelDenominationList.setLayout(new GridLayout(3,3));
        frame.add(panelDenominationList);
        
        JButton buttonPHP1 = new JButton("PHP 1");
        buttonPHP1.setFocusable(false);
        panelDenominationList.add(buttonPHP1);
        buttonPHP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = balance.get(8);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP5 = new JButton("PHP 5");
        buttonPHP5.setFocusable(false);
        panelDenominationList.add(buttonPHP5);
        buttonPHP5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(7);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP10 = new JButton("PHP 10");
        buttonPHP10.setFocusable(false);
        panelDenominationList.add(buttonPHP10);
        buttonPHP10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(6);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP20 = new JButton("PHP 20");
        buttonPHP20.setFocusable(false);
        panelDenominationList.add(buttonPHP20);
        buttonPHP20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(5);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP50 = new JButton("PHP 50");
        buttonPHP50.setFocusable(false);
        panelDenominationList.add(buttonPHP50);
        buttonPHP50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(4);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP100 = new JButton("PHP 100");
        buttonPHP100.setFocusable(false);
        panelDenominationList.add(buttonPHP100);
        buttonPHP100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(3);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP200 = new JButton("PHP 200");
        buttonPHP200.setFocusable(false);
        panelDenominationList.add(buttonPHP200);
        buttonPHP200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(2);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP500 = new JButton("PHP 500");
        buttonPHP500.setFocusable(false);
        panelDenominationList.add(buttonPHP500);
        buttonPHP500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(1);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        JButton buttonPHP1000 = new JButton("PHP 1000");
        buttonPHP1000.setFocusable(false);
        panelDenominationList.add(buttonPHP1000);
        buttonPHP1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                currentDenomination = vm.getBalance().get(0);
                labelDenominationName.setText(currentDenomination.getName());
                labelDenominationValue.setText(String.valueOf(currentDenomination.getValue()));
                labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                frame.revalidate();
            }
        });
        
        panelDenominationList.revalidate();
        // Item Info Panel
        panelDenominationInfo.setBounds(470, 10, 305, 300);
        panelDenominationInfo.setBackground(Color.gray);
        panelDenominationInfo.setLayout(new GridBagLayout());
        frame.add(panelDenominationInfo);
        
        // Item Info Panel Elements
            // Labels
            gbc.gridx = 0;
            gbc.gridy = 0;
            labelDenominationNameLabel.setHorizontalAlignment(JLabel.LEFT);
            labelDenominationNameLabel.setFont(font2);
            panelDenominationInfo.add(labelDenominationNameLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            labelDenominationValueLabel.setHorizontalAlignment(JLabel.LEFT);
            labelDenominationValueLabel.setFont(font2);
            panelDenominationInfo.add(labelDenominationValueLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            labelDenominationQuantityLabel.setHorizontalAlignment(JLabel.LEFT);
            labelDenominationQuantityLabel.setFont(font2);
            panelDenominationInfo.add(labelDenominationQuantityLabel, gbc);
        
            // Values
            labelDenominationName.setText(" ");
            labelDenominationName.setHorizontalAlignment(JLabel.CENTER);
            labelDenominationName.setForeground(new Color(0xeeeeee));
            labelDenominationName.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panelDenominationInfo.add(labelDenominationName, gbc);
            
            labelDenominationValue.setText(" ");
            labelDenominationValue.setHorizontalAlignment(JLabel.CENTER);
            labelDenominationValue.setForeground(new Color(0xeeeeee));
            labelDenominationValue.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panelDenominationInfo.add(labelDenominationValue, gbc);
            
            labelDenominationQuantity.setText(" ");
            labelDenominationQuantity.setHorizontalAlignment(JLabel.CENTER);
            labelDenominationQuantity.setForeground(new Color(0xeeeeee));
            labelDenominationQuantity.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 2;
            panelDenominationInfo.add(labelDenominationQuantity, gbc);

        // Item Price Text Field
        textFieldQuantity.setBounds(470, 320, 305, 50);
        textFieldQuantity.setHorizontalAlignment(JTextField.CENTER);
        textFieldQuantity.setEditable(true);
        textFieldQuantity.setFont(font1);
        textFieldQuantity.setFocusable(true);
        frame.add(textFieldQuantity);

        JButton buttonDeposit = new JButton("Deposit Denomination");
        JButton buttonWithdraw = new JButton("Withdraw Denomination");
        JButton buttonExit = new JButton("Exit");

        buttonDeposit.setBounds(470,380,305,100);
        buttonDeposit.setFocusable(false);
        frame.add(buttonDeposit);
        
        buttonWithdraw.setBounds(470,490,305,100);
        buttonWithdraw.setFocusable(false);
        frame.add(buttonWithdraw);
        
        buttonExit.setBounds(470,605,300,100);
        buttonExit.setFocusable(false);
        frame.add(buttonExit);

        int quantity = 0;

        buttonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    int quantity = Integer.parseInt(textFieldQuantity.getText());

                    currentDenomination.setQuantity(currentDenomination.getQuantity() + quantity);
                    labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
            }
        });
        buttonWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    int quantity = Integer.parseInt(textFieldQuantity.getText());

                    if(quantity > currentDenomination.getQuantity()) {
                        JOptionPane.showMessageDialog(null, "Insufficient quantity in machine.", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                    else {
                        currentDenomination.setQuantity(currentDenomination.getQuantity() - quantity);
                        labelDenominationQuantity.setText(String.valueOf(currentDenomination.getQuantity()));
                    }
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
            }
        });

        // Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.pack();
        frame.setVisible(true);
        
    }
}

