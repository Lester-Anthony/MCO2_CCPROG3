import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * The TransactionSummaryView class represents the view or user interface for displaying transaction summaries in a vending machine.
 * It provides methods to show transaction details and summaries to the user.
 * This class is responsible for presenting transaction information in a user-friendly format.
 * It communicates with the vending machine's TransactionSummaryController to retrieve transaction data and update the display.
 */
public class TransactionSummaryView {
    private RegularVM vm;
    private ArrayList<ItemSlot> itemList;
    
    GridBagConstraints gbc = new GridBagConstraints();

    ItemSlot currentItemSlot;
    
    // Fonts
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 15);

    // Elements
    JFrame frame = new JFrame("Vending Machine");
    
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);

    JButton exit = new JButton("Exit");
    
    public TransactionSummaryView(RegularVM vm, Transaction transaction) {

        this.vm = vm;
        
        scrollPane.setBounds(10,10,265,380);
        textArea.setEditable(false);
        
        textArea.append("\n\n =========== Transaction History ===========\n");
        
        for(ItemSlot itemSlot : transaction.getItemsSold()) {
            textArea.append("\n                 " + itemSlot.getItemName());
            textArea.append("\n                 PHP " + itemSlot.getItemCost() + " | " + itemSlot.getItemCalories() + " calories\n");
        }

        textArea.append("\n                 TOTAL COST     : " + transaction.getTotalCost());
        textArea.append("\n                 TOTAL CALORIES : " + transaction.getTotalCalories());
        textArea.append("\n                 TOTAL PAYMENT  : " + transaction.getTotalPayment());
        textArea.append("\n                 TOTAL CHANGE   : " + transaction.getTotalChange() +  "\n\n");

        exit.setBounds(10, 400, 265, 50);
        exit.addActionListener(e -> frame.dispose());
        frame.add(exit);
        // Frame
        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(300, 500));
        frame.pack();
        frame.setVisible(true);
        
    }
}

