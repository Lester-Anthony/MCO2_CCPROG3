import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ItemVMView {
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
        
    JTextField textFieldItemPrice = new JTextField("0.0");
    
    public ItemVMView(RegularVM vm) {

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

        // Item Price Text Field
        textFieldItemPrice.setBounds(470, 320, 305, 50);
        textFieldItemPrice.setHorizontalAlignment(JTextField.CENTER);
        textFieldItemPrice.setEditable(true);
        textFieldItemPrice.setFont(font1);
        textFieldItemPrice.setFocusable(true);
        frame.add(textFieldItemPrice);


        // Frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.pack();
        frame.setVisible(true);
        
    }
}

