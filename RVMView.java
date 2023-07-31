import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RVMView {

    RVMView(){};

    public void RVMView(ArrayList<Item> itemList) {

        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        Font font2 = new Font("SansSerif", Font.BOLD, 15);

        // ITEM SCREEN PANEL
        JPanel itemScreenPanel = new JPanel();
        itemScreenPanel.setBackground(Color.gray);
        itemScreenPanel.setBounds(520,10,250,235);
        itemScreenPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // btnA = new JButton("A");
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // keypadPanel.add(btnA,gbc);
        // btnA.addActionListener(e -> System.out.println("poo"));
        // btnA.setFocusable(false);

        JLabel itemNameLabel = new JLabel("Item Name :   ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        itemNameLabel.setHorizontalAlignment(JLabel.LEFT);
        itemNameLabel.setFont(font2);
        itemScreenPanel.add(itemNameLabel, gbc);
        JLabel itemPriceLabel = new JLabel("Price     :   ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        itemPriceLabel.setHorizontalAlignment(JLabel.LEFT);
        itemPriceLabel.setFont(font2);
        itemScreenPanel.add(itemPriceLabel, gbc);
        JLabel itemCaloriesLabel = new JLabel("Calories  :   ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        itemCaloriesLabel.setHorizontalAlignment(JLabel.LEFT);
        itemCaloriesLabel.setFont(font2);
        itemScreenPanel.add(itemCaloriesLabel, gbc);
        JLabel itemStockLabel = new JLabel("Stock     :   ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        itemStockLabel.setHorizontalAlignment(JLabel.LEFT);
        itemStockLabel.setFont(font2);
        itemScreenPanel.add(itemStockLabel, gbc);
        
        
        
        JLabel itemName = new JLabel();
        itemName.setHorizontalAlignment(JLabel.CENTER);
        itemName.setForeground(new Color(0xeeeeee));
        itemName.setFont(font2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        itemScreenPanel.add(itemName, gbc);
        JLabel itemPrice = new JLabel();
        itemPrice.setHorizontalAlignment(JLabel.CENTER);
        itemPrice.setForeground(new Color(0xeeeeee));
        itemPrice.setFont(font2);
        gbc.gridx = 1;
        gbc.gridy = 1;
        itemScreenPanel.add(itemPrice, gbc);
        JLabel itemCalories = new JLabel();
        itemCalories.setHorizontalAlignment(JLabel.CENTER);
        itemCalories.setForeground(new Color(0xeeeeee));
        itemCalories.setFont(font2);
        gbc.gridx = 1;
        gbc.gridy = 2;
        itemScreenPanel.add(itemCalories, gbc);
        JLabel itemStock = new JLabel();
        itemStock.setHorizontalAlignment(JLabel.CENTER);
        itemStock.setForeground(new Color(0xeeeeee));
        itemStock.setFont(font2);
        gbc.gridx = 1;
        gbc.gridy = 3;
        itemScreenPanel.add(itemStock, gbc);


        // ITEM PANEL
        JPanel itemListPanel = new JPanel();
        itemListPanel.setBackground(Color.gray);
        itemListPanel.setBounds(10,10,500,700);
        itemListPanel.setLayout(new GridLayout(5,4,10,10));
        
        for (int i = 1; i <= itemList.size(); i++) {

            // final Integer innerI = new Integer(i);
            final Integer innerI = Integer.valueOf(i);

            JPanel itemPanel = new JPanel();
            itemPanel.setBackground(new Color(0x424242));
            itemPanel.setLayout(new BorderLayout());

            JLabel label = new JLabel("Item " + i);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.TOP);
            label.setForeground(new Color(0xeeeeee));

            JButton btnSelect = new JButton(itemList.get(i-1).getName());
            // btnSelect.addActionListener(e -> System.out.println("poo"));
            btnSelect.addActionListener(e -> itemName.setText(itemList.get(innerI-1).getName()));
            btnSelect.addActionListener(e -> itemPrice.setText(String.valueOf(itemList.get(innerI-1).getPrice())));
            btnSelect.addActionListener(e -> itemCalories.setText(String.valueOf(itemList.get(innerI-1).getCalories())));
            btnSelect.addActionListener(e -> itemStock.setText(String.valueOf(itemList.get(innerI-1).getStock())));
            btnSelect.setFocusable(false);
            btnSelect.setVerticalAlignment(JButton.CENTER);
            btnSelect.setHorizontalAlignment(JButton.CENTER);

            itemPanel.add(label, BorderLayout.CENTER);
            itemPanel.add(btnSelect);
            itemListPanel.add(itemPanel);
        }



        // SCREEN PANEL
        JPanel screenPanel = new JPanel();
        screenPanel.setBackground(Color.gray);
        screenPanel.setBounds(520,315,250,395);


        
        // CHANGE PANEL
        JPanel changePanel = new JPanel();
        changePanel.setBackground(Color.gray);
        changePanel.setBounds(10, 790, 760, 160);
        changePanel.setLayout(new GridBagLayout());

        
        // BALANCE TEXT FIELD
        JTextField balTextfield = new JTextField("0.0");
        balTextfield.setBounds(520, 255, 250, 50);
        balTextfield.setEditable(false);
        balTextfield.setHorizontalAlignment(JTextField.CENTER);
        balTextfield.setFont(font1);
        balTextfield.setFocusable(false);
       
        // TEXT FIELD
        JTextField textfield = new JTextField("0.0");
        textfield.setBounds(10,725,760,50);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setFont(font1);
        textfield.setFocusable(false);



        JLabel moneyDisplay = new JLabel("Money : ");
        float money = 0;

        JButton btnPhp1 = new JButton("PHP 1");
        btnPhp1.setFocusable(false);
        btnPhp1.setPreferredSize(new Dimension(130,50));
        btnPhp1.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 1)));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp1,gbc);
        JButton btnPhp5 = new JButton("PHP 5");
        btnPhp5.setFocusable(false);
        btnPhp5.setPreferredSize(new Dimension(130,50));
        btnPhp5.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 5)));
        // btnPhp1.addActionListener(e -> money += 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp5,gbc);
        JButton btnPhp10 = new JButton("PHP 10");
        btnPhp10.setFocusable(false);
        btnPhp10.setPreferredSize(new Dimension(130,50));
        btnPhp10.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 10)));
        // btnPhp1.addActionListener(e -> money += 10);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp10,gbc);
        JButton btnPhp20 = new JButton("PHP 20");
        btnPhp20.setFocusable(false);
        btnPhp20.setPreferredSize(new Dimension(130,50));
        btnPhp20.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 20)));
        // btnPhp1.addActionListener(e -> money += 20);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        gbc.gridwidth = 1;
        changePanel.add(btnPhp20,gbc);
        JButton btnPhp50 = new JButton("PHP 50");
        btnPhp50.setFocusable(false);
        btnPhp50.setPreferredSize(new Dimension(130,50));
        btnPhp50.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 50)));
        // btnPhp1.addActionListener(e -> money += 50);
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp50,gbc);
        JButton btnPhp100 = new JButton("PHP 100");
        btnPhp100.setFocusable(false);
        btnPhp100.setPreferredSize(new Dimension(130,50));
        btnPhp100.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 100)));
        // btnPhp1.addActionListener(e -> money += 100);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp100,gbc);
        JButton btnPhp200 = new JButton("PHP 200");
        btnPhp200.setFocusable(false);
        btnPhp200.setPreferredSize(new Dimension(130,50));
        btnPhp200.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 200)));
        // btnPhp1.addActionListener(e -> money += 200);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp200,gbc);
        JButton btnPhp500 = new JButton("PHP 500");
        btnPhp500.setFocusable(false);
        btnPhp500.setPreferredSize(new Dimension(130,50));
        btnPhp500.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 500)));
        // btnPhp1.addActionListener(e -> money += 500);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp500,gbc);
        JButton btnPhp1000 = new JButton("PHP 1000");
        btnPhp1000.setFocusable(false);
        btnPhp1000.setPreferredSize(new Dimension(130,50));
        btnPhp1000.addActionListener(e -> textfield.setText(String.valueOf(Float.parseFloat(textfield.getText()) + 1000)));
        // btnPhp1.addActionListener(e -> money += 1000);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        changePanel.add(btnPhp1000,gbc);

        boolean enter = false;

        JButton btnEnter = new JButton(" Enter ");
        btnEnter.setFocusable(false);
        btnEnter.setPreferredSize(new Dimension(130,50));
        btnEnter.addActionListener(e -> textfield.setText("0.0"));
        btnEnter.addActionListener(e -> System.out.println(textfield.getText()));
        btnEnter.addActionListener(e -> balTextfield.setText(textfield.getText()));
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        changePanel.add(btnEnter,gbc);

        
        // FRAME
        JFrame vmFrame = new JFrame("Vending Machine");
        vmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vmFrame.setLayout(null);
        vmFrame.setSize(800,1000);
        vmFrame.setResizable(false);
        
        vmFrame.add(itemListPanel);
        vmFrame.add(itemScreenPanel);
        vmFrame.add(screenPanel);
        vmFrame.add(changePanel);
        vmFrame.add(textfield);
        vmFrame.add(balTextfield);
        vmFrame.setVisible(true);

    }
}
