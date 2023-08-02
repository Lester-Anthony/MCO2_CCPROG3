import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RegularVMView {
    private RegularVM vm;
    private ArrayList<ItemSlot> itemList;
    
    CardLayout cl = new CardLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    ItemSlot currentItemSlot;
    
    // Fonts
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 15);

    // Elements
    JFrame frame = new JFrame("Vending Machine");
    
    JPanel panelItemList = new JPanel();
    JPanel panelItemInfo = new JPanel();
    
    JLabel labelItemNameLabel = new JLabel("Name  :  ");
    JLabel labelItemPriceLabel = new JLabel("Price  :  ");
    JLabel labelItemCaloriesLabel = new JLabel("Calories  :  ");
    JLabel labelItemStockLabel = new JLabel("Stock  :  ");
    JLabel labelItemIndexLabel = new JLabel("Index  :  ");
    
    JLabel labelItemName = new JLabel();
    JLabel labelItemPrice = new JLabel();
    JLabel labelItemCalories = new JLabel();
    JLabel labelItemStock = new JLabel();
    JLabel labelItemIndex = new JLabel();
    
    JPanel panelCont = new JPanel();
        JPanel panelEnterPayment  = new JPanel();
            JButton buttonBuyButton = new JButton("Buy Item");
            JButton buttonGetChange = new JButton("Cancel");
            JButton buttonPaymentExit = new JButton("Exit");
        JPanel panelReceiveChange = new JPanel();
            JButton buttonBuyMore = new JButton("Return");
            JButton buttonChangeExit = new JButton("Exit");
        
    //     JButton buttonBuyItem = new JButton("Buy Item");
    //     JButton buttonGetChange = new JButton("Get Change");
        
    JTextField textFieldBalance = new JTextField("0.0");
    
    public RegularVMView(RegularVM vm) {


        this.vm = vm;
        this.itemList = vm.getItemSlots();
        
        // Item List Panel
        panelItemList.setBounds(10,10,450,940);
        panelItemList.setBackground(Color.GRAY);
        panelItemList.setLayout(new GridLayout(5,4,10,10));
        frame.add(panelItemList);
        
        // Item List Panel Buttons
        for (int i = 0; i < itemList.size(); i++) {

            final Integer innerI = Integer.valueOf(i);

            String name = vm.getItemSlots().get(i).getItemName();
            float cost = vm.getItemSlots().get(i).getItemCost();
            float calories = vm.getItemSlots().get(i).getItemCalories();
            int stock = vm.getItemSlots().get(i).getItems().size();
            ItemSlot itemSlot = vm.getItemSlots().get(i);
            int index = i;
        
            JButton buttonSelect = new JButton(name);

            buttonSelect.setFocusable(false);
            buttonSelect.setVerticalAlignment(JButton.CENTER);
            buttonSelect.setHorizontalAlignment(JButton.CENTER);

            buttonSelect.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    labelItemName.setText(name);
                    labelItemPrice.setText(String.valueOf(cost));
                    labelItemCalories.setText(String.valueOf(calories));
                    labelItemStock.setText(String.valueOf(stock));
                    labelItemIndex.setText(String.valueOf(index));
                    currentItemSlot = itemSlot;
                }
            });
        
            panelItemList.add(buttonSelect);
        }
            
        // Item Info Panel
        panelItemInfo.setBounds(470, 10, 305, 300);
        panelItemInfo.setBackground(Color.gray);
        panelItemInfo.setLayout(new GridBagLayout());
        frame.add(panelItemInfo);
        
        // Item Info Panel Elements
            // Labels
            gbc.gridx = 0;
            gbc.gridy = 0;
            labelItemNameLabel.setHorizontalAlignment(JLabel.LEFT);
            labelItemNameLabel.setFont(font2);
            panelItemInfo.add(labelItemNameLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            labelItemPriceLabel.setHorizontalAlignment(JLabel.LEFT);
            labelItemPriceLabel.setFont(font2);
            panelItemInfo.add(labelItemPriceLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            labelItemCaloriesLabel.setHorizontalAlignment(JLabel.LEFT);
            labelItemCaloriesLabel.setFont(font2);
            panelItemInfo.add(labelItemCaloriesLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            labelItemStockLabel.setHorizontalAlignment(JLabel.LEFT);
            labelItemStockLabel.setFont(font2);
            panelItemInfo.add(labelItemStockLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            labelItemIndexLabel.setHorizontalAlignment(JLabel.LEFT);
            labelItemIndexLabel.setFont(font2);
            panelItemInfo.add(labelItemIndexLabel, gbc);
        
            // Values
            labelItemName.setText("");
            labelItemName.setHorizontalAlignment(JLabel.CENTER);
            labelItemName.setForeground(new Color(0xeeeeee));
            labelItemName.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panelItemInfo.add(labelItemName, gbc);
            
            labelItemPrice.setText("");
            labelItemPrice.setHorizontalAlignment(JLabel.CENTER);
            labelItemPrice.setForeground(new Color(0xeeeeee));
            labelItemPrice.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panelItemInfo.add(labelItemPrice, gbc);
            
            labelItemCalories.setText("");
            labelItemCalories.setHorizontalAlignment(JLabel.CENTER);
            labelItemCalories.setForeground(new Color(0xeeeeee));
            labelItemCalories.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 2;
            panelItemInfo.add(labelItemCalories, gbc);

            labelItemStock.setText("");
            labelItemStock.setHorizontalAlignment(JLabel.CENTER);
            labelItemStock.setForeground(new Color(0xeeeeee));
            labelItemStock.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 3;
            panelItemInfo.add(labelItemStock, gbc);

            labelItemIndex.setText("");
            labelItemIndex.setHorizontalAlignment(JLabel.CENTER);
            labelItemIndex.setForeground(new Color(0xeeeeee));
            labelItemIndex.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 4;
            panelItemInfo.add(labelItemIndex, gbc);

        // Balance Text Field
        textFieldBalance.setBounds(470, 320, 305, 50);
        textFieldBalance.setEditable(false);
        textFieldBalance.setHorizontalAlignment(JTextField.CENTER);
        textFieldBalance.setFont(font1);
        textFieldBalance.setFocusable(false);
        frame.add(textFieldBalance);

        // Container Panel
        panelCont.setBounds(470, 380, 305, 400);
        panelCont.setLayout(cl);
        // panelEnterPayment.setBounds(470, 370, 305, 400);
        panelCont.add(panelEnterPayment, "Enter Payment");
        panelCont.add(panelReceiveChange, "Receive Change");
        
        panelCont.setBackground(Color.GRAY);

        panelEnterPayment.setBackground(Color.GRAY);
        panelEnterPayment.setLayout(new GridLayout(4,3,10,10));
        
        panelReceiveChange.setBackground(Color.GRAY);
        
        cl.show(panelCont, "Enter Payment");
        
        // Receive Change Panel
        panelReceiveChange.setLayout(new GridBagLayout());
        JTextArea textAreaReceiveChange = new JTextArea();

        textAreaReceiveChange.setLineWrap(true);
        textAreaReceiveChange.setEditable(false);
        textAreaReceiveChange.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaReceiveChange);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        scrollPane.setPreferredSize(new Dimension(305, 350));
        panelReceiveChange.add(scrollPane, gbc);
        
        buttonBuyMore.setPreferredSize(new Dimension(153, 50));
        buttonBuyMore.setFocusable(false);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        buttonBuyMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {        
                cl.show(panelCont, "Enter Payment");
            }
        });
        panelReceiveChange.add(buttonBuyMore, gbc);
        
        buttonChangeExit.setPreferredSize(new Dimension(152, 50));
        buttonChangeExit.setFocusable(false);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 1;
        buttonChangeExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        panelReceiveChange.add(buttonChangeExit, gbc);

        // Enter Payment Panel
        JButton buttonPhp1 = new JButton("PHP 1");
        buttonPhp1.setFocusable(false);
        buttonPhp1.setPreferredSize(new Dimension(130,50));
        
        buttonPhp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(8).setQuantity(vm.getBalance().get(8).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 1));
            }
        });
        panelEnterPayment.add(buttonPhp1);
        
        JButton buttonPhp5 = new JButton("PHP 5");
        buttonPhp5.setFocusable(false);
        buttonPhp5.setPreferredSize(new Dimension(130,50));
        
        buttonPhp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(7).setQuantity(vm.getBalance().get(7).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 5));
            }
        });
        panelEnterPayment.add(buttonPhp5);

        JButton buttonPhp10 = new JButton("PHP 10");
        buttonPhp10.setFocusable(false);
        buttonPhp10.setPreferredSize(new Dimension(130,50));
        
        buttonPhp10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(6).setQuantity(vm.getBalance().get(6).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 10));
            }
        });
        panelEnterPayment.add(buttonPhp10);

        JButton buttonPhp20 = new JButton("PHP 20");
        buttonPhp20.setFocusable(false);
        buttonPhp20.setPreferredSize(new Dimension(130,50));
        
        buttonPhp20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(5).setQuantity(vm.getBalance().get(5).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 20));
            }
        });
        panelEnterPayment.add(buttonPhp20);

        JButton buttonPhp50 = new JButton("PHP 50");
        buttonPhp50.setFocusable(false);
        buttonPhp50.setPreferredSize(new Dimension(130,50));
        
        buttonPhp50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(4).setQuantity(vm.getBalance().get(4).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 50));
            }
        });
        panelEnterPayment.add(buttonPhp50);

        JButton buttonPhp100 = new JButton("PHP 100");
        buttonPhp100.setFocusable(false);
        buttonPhp100.setPreferredSize(new Dimension(130,50));
        
        buttonPhp100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(3).setQuantity(vm.getBalance().get(3).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 100));
            }
        });
        panelEnterPayment.add(buttonPhp100);

        JButton buttonPhp200 = new JButton("PHP 200");
        buttonPhp200.setFocusable(false);
        buttonPhp200.setPreferredSize(new Dimension(130,50));
        
        buttonPhp200.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(2).setQuantity(vm.getBalance().get(2).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 200));
            }
        });
        panelEnterPayment.add(buttonPhp200);

        JButton buttonPhp500 = new JButton("PHP 500");
        buttonPhp500.setFocusable(false);
        buttonPhp500.setPreferredSize(new Dimension(130,50));
        
        buttonPhp500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(1).setQuantity(vm.getBalance().get(1).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 500));
            }
        });
        panelEnterPayment.add(buttonPhp500);

        JButton buttonPhp1000 = new JButton("PHP 1000");
        buttonPhp1000.setFocusable(false);
        buttonPhp1000.setPreferredSize(new Dimension(130,50));
        
        buttonPhp1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                vm.getBalance().get(2).setQuantity(vm.getBalance().get(2).getQuantity() + 1);
                textFieldBalance.setText(String.valueOf(Float.parseFloat(textFieldBalance.getText()) + 1000));
            }
        });
        panelEnterPayment.add(buttonPhp1000);

        buttonBuyButton.setFocusable(false);
        buttonBuyButton.setPreferredSize(new Dimension(130,50));
        buttonBuyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.revalidate();
                float payment = Float.parseFloat(textFieldBalance.getText());
                float cost = Float.parseFloat(labelItemPrice.getText());

                if(currentItemSlot == null) {
                    JOptionPane.showMessageDialog(null, "Must select item first.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(payment < cost) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(currentItemSlot.getItems().size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Item is out of stock.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    textFieldBalance.setText("0.0");
                    // Update Stock Label
                    labelItemStock.setText(String.valueOf(Integer.parseInt(labelItemStock.getText()) - 1));
                    // Decrements item stock by 1 and adds to total values in transaction history
                    vm.buyItem(currentItemSlot, payment);

                    System.out.println(vm.getTotalCost());

                    System.out.println(vm.getTotalPayment());
                    
                    ArrayList<Denomination> changeList = vm.produceChange(payment, cost);

                    float totalChange = 0;

                    textAreaReceiveChange.setText("");

                    textAreaReceiveChange.append("\n        Dispensing " + currentItemSlot.getItemName() + "...\n");

                    for(Denomination denomination : changeList) {
                        if(denomination.getQuantity() > 0) {
                            if(denomination.getValue() > 20) {
                                if(denomination.getQuantity() == 1) {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bill...");
                                }
                                else {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bills...");

                                }
                                }
                            else {
                                if(denomination.getQuantity() == 1) {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coin...");
                                }
                                else {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coins...");
                                }
                            }
                        }
                        totalChange += denomination.getValue() * denomination.getQuantity();
                    }
            
                    if(totalChange != payment - cost) {
                        textAreaReceiveChange.append("\n\nERROR! Machine has insufficient balance.");
                    }
                    textAreaReceiveChange.append("\n\n        TOTAL CHANGE : PHP " + totalChange);

                    cl.show(panelCont, "Receive Change");              

                }
            }
        });
        panelEnterPayment.add(buttonBuyButton);

        buttonGetChange.setFocusable(false);
        buttonGetChange.setPreferredSize(new Dimension(130,50));
        buttonGetChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {  
                float payment = Float.parseFloat(textFieldBalance.getText());
                float cost = 0;       
                
                textAreaReceiveChange.setText("");

                    textFieldBalance.setText("0.0");

                    System.out.println(vm.getTotalCost());
                    System.out.println(vm.getTotalPayment());
                    
                    ArrayList<Denomination> changeList = vm.produceChange(payment, cost);

                    float totalChange = 0;

                    for(Denomination denomination : changeList) {
                        if(denomination.getQuantity() > 0) {
                            if(denomination.getValue() > 20) {
                                if(denomination.getQuantity() == 1) {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bill...");
                                }
                                else {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bills...");

                                }
                                }
                            else {
                                if(denomination.getQuantity() == 1) {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coin...");
                                }
                                else {
                                    textAreaReceiveChange.append("\n        Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coins...");
                                }
                            }
                        }
                        totalChange += denomination.getValue() * denomination.getQuantity();
                    }
            
                    if(totalChange != payment - cost) {
                        textAreaReceiveChange.append("\n\nERROR! Machine has insufficient balance.");
                    }
                    textAreaReceiveChange.append("\n\n        TOTAL CHANGE : PHP " + totalChange);        

                cl.show(panelCont, "Receive Change");              
            }
        });
        panelEnterPayment.add(buttonGetChange);

        buttonPaymentExit.setFocusable(false);
        buttonPaymentExit.setPreferredSize(new Dimension(130,50));
        buttonPaymentExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {                
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        panelEnterPayment.add(buttonPaymentExit);

        frame.add(panelCont);

        // Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.pack();
        frame.setVisible(true);
        
    }
}
