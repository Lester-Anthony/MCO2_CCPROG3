import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    private RegularVM vm = new RegularVM("Vending Machine");

    private RegularVMView regularVMView;

    ItemSlot currentItemSlot;

    // Fonts
    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    Font font2 = new Font("SansSerif", Font.BOLD, 15);

    JFrame frame = new JFrame();

    JPanel panelCont = new JPanel();
    JPanel panelMainMenu = new JPanel();

    JPanel panelCreateVendingMachine = new JPanel();
    JPanel panelTestVendingMachine = new JPanel();

    JPanel panelCreateRVM = new JPanel();
    JPanel panelCreateSVM = new JPanel();

    JPanel panelVendingFeatures = new JPanel();
    JPanel panelMaintenanceFeatures = new JPanel();

    JPanel panelStockItem = new JPanel();
    JPanel panelSetItemPrice = new JPanel();
    JPanel panelCollectEarnings = new JPanel();
    JPanel panelReplenishMoney = new JPanel();
    JPanel panelTransactionSummary = new JPanel();

    // Main Menu Elements
        JButton buttonCreateVendingMachine = new JButton("Create Vending Machine");
        JButton buttonTestVendingMachine = new JButton("Test Vending Machine");
        JButton buttonExit = new JButton("Exit");
    // Create Vending Machine Menu Elements
        JButton buttonRegularVM = new JButton("Create Regular Vending Machine");
        JButton buttonSpecialVM = new JButton("Create Special Vending Machine");
        JButton buttonExitToMainMenu = new JButton("Exit");
    // Create Regular Vending Machine Elements
        JLabel labelRVM = new JLabel("Vending Machine");

        JLabel labelRVMName = new JLabel("Vending Machine Name  :  ");
        JTextField textFieldRVMName = new JTextField();

        JLabel labelRVMAddItem = new JLabel("Add Item");

        JLabel labelRVMItemName = new JLabel("Item Name  :  ");
        JTextField textFieldRVMItemName = new JTextField();

        JLabel labelRVMItemCost = new JLabel("Cost  :  ");
        JTextField textFieldRVMItemCost = new JTextField("0");

        JLabel labelRVMItemCalories = new JLabel("Calories  :  ");
        JTextField textFieldRVMItemCalories = new JTextField("0");

        JLabel labelRVMItemQuantity = new JLabel("Quantity  :  ");
        JTextField textFieldRVMItemQuantity = new JTextField("0");

        JButton buttonRVMAddItem = new JButton("Add Item");

        JButton buttonRVMExitToCreateVM = new JButton("Exit");
    // Create Special Vending Machine Elements
        JLabel labelSVM = new JLabel("Vending Machine");

        JLabel labelSVMName = new JLabel("Vending Machine Name  :  ");
        JTextField textFieldSVMName = new JTextField();

        JLabel labelSVMAddItem = new JLabel("Add Item");

        JLabel labelSVMItemName = new JLabel("Item Name  :  ");
        JTextField textFieldSVMItemName = new JTextField();

        JLabel labelSVMItemCost = new JLabel("Cost  :  ");
        JTextField textFieldSVMItemCost = new JTextField("0");

        JLabel labelSVMItemCalories = new JLabel("Calories  :  ");
        JTextField textFieldSVMItemCalories = new JTextField("0");

        JLabel labelSVMItemQuantity = new JLabel("Quantity  :  ");
        JTextField textFieldSVMItemQuantity = new JTextField("0");

        JLabel labelSVMItemIndependence = new JLabel("Independence  :  ");
        JRadioButton radioButtonSVMIndependent = new JRadioButton("Independent");
        JRadioButton radioButtonSVMDependent = new JRadioButton("Dependent");
        ButtonGroup buttonGroupSVM = new ButtonGroup();

        JLabel labelSVMItemProcess = new JLabel("Process  :  ");
        JTextField textFieldSMVItemProcess = new JTextField("");

        JButton buttonSVMAddItem = new JButton("Add Item");

        JButton buttonSVMExitToCreateVM = new JButton("Exit");
    // Test Vending Machine Elements
        JButton buttonTestVendingFeatures = new JButton("Test Vending Features");
        JButton buttonTestMaintenanceFeatures = new JButton("Test Maintenance Features");
        JButton buttonTVMExit = new JButton("Exit");
    // Maintenance Features Elements
        JButton buttonGoStockItem = new JButton("Stock Item");
        JButton buttonGoSetItemPrice = new JButton("Set Item Price");
        JButton buttonGoCollectEarnings = new JButton("Collect Earnings");
        JButton buttonGoReplenishMoney = new JButton("Replenish Money");
        JButton buttonGoTransactionSummary = new JButton("Transaction Summary");
        JButton buttonTMFExit = new JButton("Exit");
    // Stock Item Panel
        JPanel panelStockItemItemList = new JPanel();
        JPanel panelStockItemItemInfo = new JPanel();
        JPanel panelStockItemMenu = new JPanel();

        JLabel labelStockItemItemNameLabel = new JLabel();
        JLabel labelStockItemItemPriceLabel = new JLabel();
        JLabel labelStockItemItemCaloriesLabel = new JLabel();
        JLabel labelStockItemItemStockLabel = new JLabel();
        JLabel labelStockItemItemIndexLabel = new JLabel();

        JLabel labelStockItemItemName = new JLabel();
        JLabel labelStockItemItemPrice = new JLabel();
        JLabel labelStockItemItemCalories = new JLabel();
        JLabel labelStockItemItemStock = new JLabel();
        JLabel labelStockItemItemIndex = new JLabel();

    




    CardLayout cl = new CardLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    Font headingFont = new Font("SansSerif", 1, 20);

    public Controller() {
        // Panel Container
        panelCont.setLayout(cl);
        cl.show(panelCont, "Main Menu");

        panelCont.add(panelMainMenu, "Main Menu");

        panelCont.add(panelCreateVendingMachine, "Create Vending Machine");
        panelCont.add(panelTestVendingMachine, "Test Vending Machine");

        panelCont.add(panelCreateRVM, "Create RVM");
        panelCont.add(panelCreateSVM, "Create SVM");

        panelCont.add(panelStockItem, "Stock Item");
        panelCont.add(panelSetItemPrice, "Set Item Price");
        panelCont.add(panelCollectEarnings, "Collect Earnings");
        panelCont.add(panelReplenishMoney, "Replenish Money");
        panelCont.add(panelTransactionSummary, "Transaction Summary");
        
        // panelCont.add(panelVendingFeatures, "Test Vending Features");
        panelCont.add(panelMaintenanceFeatures, "Test Maintenance Features");


        gbc.insets = new Insets(10,10,10,10);

        // Main Menu
            panelMainMenu.setLayout(new GridBagLayout());

            buttonCreateVendingMachine.setPreferredSize(new Dimension(400, 75));
            buttonCreateVendingMachine.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 1;
            panelMainMenu.add(buttonCreateVendingMachine, gbc);
            
            buttonTestVendingMachine.setPreferredSize(new Dimension(400, 75));
            buttonTestVendingMachine.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 2;
            panelMainMenu.add(buttonTestVendingMachine, gbc);
            
            buttonExit.setPreferredSize(new Dimension(400, 75));
            buttonExit.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 3;
            panelMainMenu.add(buttonExit, gbc);

            // Main Menu Buttons
            buttonCreateVendingMachine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    cl.show(panelCont, "Create Vending Machine");
                }
            });
            buttonTestVendingMachine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    cl.show(panelCont, "Test Vending Machine");
                }
            });
            buttonExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                }
            });

        // Create Vending Machine Menu
            panelCreateVendingMachine.setLayout(new GridBagLayout());

            buttonRegularVM.setPreferredSize(new Dimension(400, 75));
            buttonRegularVM.setFocusable(false);
            gbc.gridx = 0; gbc.gridy = 1;
            panelCreateVendingMachine.add(buttonRegularVM, gbc);
            
            buttonSpecialVM.setPreferredSize(new Dimension(400, 75));
            buttonSpecialVM.setFocusable(false);
            gbc.gridx = 0; gbc.gridy = 2;
            panelCreateVendingMachine.add(buttonSpecialVM, gbc);
            
            buttonExitToMainMenu.setPreferredSize(new Dimension(400, 75));
            buttonExitToMainMenu.setFocusable(false);
            gbc.gridx = 0; gbc.gridy = 3;
            panelCreateVendingMachine.add(buttonExitToMainMenu, gbc);

            // Create Vending Machine Menu Buttons
            buttonRegularVM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Initializes vm as a Regular VM
                    vm = new RegularVM(null);
                    cl.show(panelCont, "Create RVM");
                }
            });
            buttonSpecialVM.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // Initializes vm as a Special VM
                    vm = new SpecialVM(null);
                    cl.show(panelCont, "Create SVM");
                }
            });
            buttonExitToMainMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    cl.show(panelCont, "Main Menu");
                }
            });
            
        // Create Regular Vending Machine Menu
            panelCreateRVM.setLayout(new GridBagLayout());

            gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
            labelRVM.setFont(headingFont);
            panelCreateRVM.add(labelRVM, gbc);

            gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
            panelCreateRVM.add(labelRVMName, gbc);
            gbc.gridx = 1; gbc.gridy = 1; 
            textFieldRVMName.setPreferredSize(new Dimension(250, 40));
            panelCreateRVM.add(textFieldRVMName, gbc);
            
            gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
            labelRVMAddItem.setFont(headingFont);
            panelCreateRVM.add(labelRVMAddItem, gbc);
            
            gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
            panelCreateRVM.add(labelRVMItemName, gbc); 
            gbc.gridx = 1; gbc.gridy = 3;
            textFieldRVMItemName.setPreferredSize(new Dimension(250, 40));
            panelCreateRVM.add(textFieldRVMItemName, gbc);
            
            gbc.gridx = 0; gbc.gridy = 4;
            panelCreateRVM.add(labelRVMItemCost, gbc); 
            gbc.gridx = 1; gbc.gridy = 4;
            textFieldRVMItemCost.setPreferredSize(new Dimension(250, 40));
            panelCreateRVM.add(textFieldRVMItemCost, gbc);
            
            gbc.gridx = 0; gbc.gridy = 5;
            panelCreateRVM.add(labelRVMItemCalories, gbc); 
            gbc.gridx = 1; gbc.gridy = 5;
            textFieldRVMItemCalories.setPreferredSize(new Dimension(250, 40));
            panelCreateRVM.add(textFieldRVMItemCalories, gbc);
            
            gbc.gridx = 0; gbc.gridy = 6;
            panelCreateRVM.add(labelRVMItemQuantity, gbc); 
            gbc.gridx = 1; gbc.gridy = 6;
            textFieldRVMItemQuantity.setPreferredSize(new Dimension(250, 40));
            panelCreateRVM.add(textFieldRVMItemQuantity, gbc);
            
            gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 3;
            buttonRVMAddItem.setFocusable(false);
            panelCreateRVM.add(buttonRVMAddItem, gbc);
            
            gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 3;
            buttonRVMExitToCreateVM.setFocusable(false);
            panelCreateRVM.add(buttonRVMExitToCreateVM, gbc);

                // Create Regular Vending Machine Element Properties
                textFieldRVMItemCost.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldRVMItemCost.setEditable(true);
                        }
                        else {
                            textFieldRVMItemCost.setEditable(false);
                        }
                    }
                });
                textFieldRVMItemCalories.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldRVMItemCalories.setEditable(true);
                        }
                        else {
                            textFieldRVMItemCalories.setEditable(false);
                        }
                    }
                });
                textFieldRVMItemQuantity.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldRVMItemQuantity.setEditable(true);
                        }
                        else {
                            textFieldRVMItemQuantity.setEditable(false);
                        }
                    }
                });

                buttonRVMAddItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        String name = textFieldRVMItemName.getText();
                        float cost = Float.parseFloat(textFieldRVMItemCost.getText());
                        float calories = Float.parseFloat(textFieldRVMItemCalories.getText());
                        int quantity = Integer.parseInt(textFieldRVMItemQuantity.getText());

                        if(!name.equals("") && cost != 0 && quantity != 0)
                            vm.addItemSlot(new Item(name, calories, true, null), cost, quantity);
                        else
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);

                        textFieldRVMItemName.setText("");
                        textFieldRVMItemCost.setText("0");
                        textFieldRVMItemCalories.setText("0");
                        textFieldRVMItemQuantity.setText("0");
                    }
                });
                buttonRVMExitToCreateVM.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if(vm.getItemSlots().size() >= 1 && !textFieldRVMName.getText().equals("")) {
                            vm.setName(textFieldRVMName.getText());   
                            cl.show(panelCont, "Create Vending Machine");
                        }
                        else if(textFieldRVMName.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please enter Vending Machine name.", "Error", JOptionPane.ERROR_MESSAGE);
                        else 
                            JOptionPane.showMessageDialog(null, "A Vending Machine requires at least 8 items.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

        // Create Special Vending Machine Menu
            panelCreateSVM.setLayout(new GridBagLayout());

            gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
            labelSVM.setFont(headingFont);
            panelCreateSVM.add(labelSVM, gbc);

            gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMName, gbc);
            gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2;
            textFieldSVMName.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSVMName, gbc);
            
            gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
            labelSVMAddItem.setFont(headingFont);
            panelCreateSVM.add(labelSVMAddItem, gbc);
            
            gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMItemName, gbc); 
            gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2;
            textFieldSVMItemName.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSVMItemName, gbc);
            
            gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMItemCost, gbc); 
            gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 2;
            textFieldSVMItemCost.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSVMItemCost, gbc);
            
            gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMItemCalories, gbc); 
            gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2;
            textFieldSVMItemCalories.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSVMItemCalories, gbc);
            
            gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMItemQuantity, gbc); 
            gbc.gridx = 1; gbc.gridy = 6; gbc.gridwidth = 2;
            textFieldSVMItemQuantity.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSVMItemQuantity, gbc);
            
            gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 1;
            panelCreateSVM.add(labelSVMItemIndependence, gbc); 
            gbc.gridx = 1; gbc.gridy = 7; 
            radioButtonSVMIndependent.setFocusable(false);
            buttonGroupSVM.add(radioButtonSVMIndependent);
            panelCreateSVM.add(radioButtonSVMIndependent, gbc); 
            gbc.gridx = 2; gbc.gridy = 7; 
            radioButtonSVMDependent.setFocusable(false);
            buttonGroupSVM.add(radioButtonSVMDependent);
            panelCreateSVM.add(radioButtonSVMDependent, gbc); 
            
            gbc.gridx = 0; gbc.gridy = 8;
            panelCreateSVM.add(labelSVMItemProcess, gbc);
            gbc.gridx = 1; gbc.gridy = 8; gbc.gridwidth = 2;
            textFieldSMVItemProcess.setPreferredSize(new Dimension(250, 40));
            panelCreateSVM.add(textFieldSMVItemProcess, gbc);

            
            gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 3;
            buttonSVMAddItem.setFocusable(false);
            panelCreateSVM.add(buttonSVMAddItem, gbc);
            
            gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 3;
            buttonSVMExitToCreateVM.setFocusable(false);
            panelCreateSVM.add(buttonSVMExitToCreateVM, gbc);

                // Create Regular Vending Machine Element Properties
                textFieldSVMItemCost.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldSVMItemCost.setEditable(true);
                        }
                        else {
                            textFieldSVMItemCost.setEditable(false);
                        }
                    }
                });
                textFieldSVMItemCalories.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldSVMItemCalories.setEditable(true);
                        }
                        else {
                            textFieldSVMItemCalories.setEditable(false);
                        }
                    }
                });
                textFieldSVMItemQuantity.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                            textFieldSVMItemQuantity.setEditable(true);
                        }
                        else {
                            textFieldSVMItemQuantity.setEditable(false);
                        }
                    }
                });

                buttonSVMAddItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {

                        // Adds item to itemSlots
                        String name = textFieldSVMItemName.getText();
                        float cost = Float.parseFloat(textFieldSVMItemCost.getText());
                        float calories = Float.parseFloat(textFieldSVMItemCalories.getText());
                        int quantity = Integer.parseInt(textFieldSVMItemQuantity.getText());
                        boolean isIndependent = true;
                        String process = textFieldSMVItemProcess.getText();

                        if(radioButtonSVMIndependent.isSelected())
                            isIndependent = true;
                        if(radioButtonSVMDependent.isSelected())
                            isIndependent = false;

                        if(!name.equals("") && cost != 0 && quantity != 0 && (radioButtonSVMDependent.isSelected() || radioButtonSVMIndependent.isSelected()) && !process.equals(""))
                            vm.addItemSlot(new Item(name, calories, isIndependent, process), cost, quantity);
                        else
                            JOptionPane.showMessageDialog(null, "Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);

                        textFieldSVMItemName.setText("");
                        textFieldSVMItemCost.setText("0");
                        textFieldSVMItemCalories.setText("0");
                        textFieldSVMItemQuantity.setText("0");
                        textFieldSMVItemProcess.setText("");
                    }
                });
                buttonSVMExitToCreateVM.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        if(vm.getItemSlots().size() >= 1 && !textFieldSVMName.getText().equals("")) {
                            vm.setName(textFieldSVMName.getText());   
                            cl.show(panelCont, "Create Vending Machine");
                        }
                        else if(textFieldSVMName.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please enter Vending Machine name.", "Error", JOptionPane.ERROR_MESSAGE);
                        else 
                            JOptionPane.showMessageDialog(null, "A Vending Machine requires at least 8 items.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });

        // Test Vending Machine Menu
            panelTestVendingMachine.setLayout(new GridBagLayout());

            buttonTestVendingFeatures.setPreferredSize(new Dimension(400, 75));
            buttonTestVendingFeatures.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 1;
            panelTestVendingMachine.add(buttonTestVendingFeatures, gbc);
            
            buttonTestMaintenanceFeatures.setPreferredSize(new Dimension(400, 75));
            buttonTestMaintenanceFeatures.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 2;
            panelTestVendingMachine.add(buttonTestMaintenanceFeatures, gbc);
            
            buttonTVMExit.setPreferredSize(new Dimension(400, 75));
            buttonTVMExit.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 3;
            panelTestVendingMachine.add(buttonTVMExit, gbc);

            

                // Test Vending Machine Element Properties
                buttonTestVendingFeatures.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        int denominations[] = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

                        for(int denomination : denominations) {
                            vm.addDenomination(new Denomination("PHP " + denomination, denomination, 100));
                        }

                        if(vm instanceof RegularVM) {

                            RegularVMView RegularVMView = new RegularVMView(vm);    
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Creation of Vending Machine is required.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                buttonTestMaintenanceFeatures.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Test Maintenance Features");

                    }
                });
                buttonTVMExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Main Menu");

                    }
                });

        // Test Maintenance Features Elements
        panelMaintenanceFeatures.setLayout(new GridBagLayout());

        buttonGoStockItem.setPreferredSize(new Dimension(400, 75));
        buttonGoStockItem.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelMaintenanceFeatures.add(buttonGoStockItem, gbc);

        buttonGoSetItemPrice.setPreferredSize(new Dimension(400, 75));
        buttonGoSetItemPrice.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelMaintenanceFeatures.add(buttonGoSetItemPrice, gbc);

        buttonGoCollectEarnings.setPreferredSize(new Dimension(400, 75));
        buttonGoCollectEarnings.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelMaintenanceFeatures.add(buttonGoCollectEarnings, gbc);

        buttonGoReplenishMoney.setPreferredSize(new Dimension(400, 75));
        buttonGoReplenishMoney.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelMaintenanceFeatures.add(buttonGoReplenishMoney, gbc);

        buttonGoTransactionSummary.setPreferredSize(new Dimension(400, 75));
        buttonGoTransactionSummary.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelMaintenanceFeatures.add(buttonGoTransactionSummary, gbc);

        buttonTMFExit.setPreferredSize(new Dimension(400, 75));
        buttonTMFExit.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelMaintenanceFeatures.add(buttonTMFExit, gbc);
        
                // Test Maintenance Features Element Properties
                buttonGoStockItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        ItemVMView itemVMView = new ItemVMView(vm);
                        // cl.show(panelCont, "Stock Item");
                    }
                });
                buttonGoSetItemPrice.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Set Item Price");
                    }
                });
                buttonGoCollectEarnings.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Collect Earnings");
                    }
                });
                buttonGoReplenishMoney.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Replenish Money");
                    }
                });
                buttonGoTransactionSummary.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Transaction Summary");
                    }
                });
                buttonTMFExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        cl.show(panelCont, "Test Vending Machine");
                    }
                });

        // // Stock Item Panel
        // panelStockItem.setLayout(null);
        // // Item List Panel
        // panelStockItemItemList.setBounds(10,10,450,940);
        // panelStockItemItemList.setBackground(Color.GRAY);
        // panelStockItemItemList.setLayout(new GridLayout());
        // // panelStockItemItemList.setLayout(new GridLayout(5,4,10,10));
        // panelStockItem.add(panelStockItemItemList);


        
        // // Item List Panel Buttons
        // for (int i = 0; i < vm.getItemSlots().size(); i++) {

        //     final Integer innerI = Integer.valueOf(i);

        //     String name = vm.getItemSlots().get(i).getItemName();
        //     float cost = vm.getItemSlots().get(i).getItemCost();
        //     float calories = vm.getItemSlots().get(i).getItemCalories();
        //     int stock = vm.getItemSlots().get(i).getItems().size();
        //     ItemSlot itemSlot = vm.getItemSlots().get(i);
        
        //     JButton buttonSelect = new JButton(name);

        //     buttonSelect.setFocusable(false);
        //     buttonSelect.setVerticalAlignment(JButton.CENTER);
        //     buttonSelect.setHorizontalAlignment(JButton.CENTER);

        //     buttonSelect.addActionListener(new ActionListener() {
        //         @Override
        //         public void actionPerformed(ActionEvent arg0) {
        //             labelStockItemItemName.setText(name);
        //             labelStockItemItemPrice.setText(String.valueOf(cost));
        //             labelStockItemItemCalories.setText(String.valueOf(calories));
        //             labelStockItemItemStock.setText(String.valueOf(stock));
        //             currentItemSlot = itemSlot;
        //         }
        //     });
        //     panelStockItemItemList.add(buttonSelect);
        // }

        // // Item Info Panel
        // panelStockItemItemInfo.setBounds(470, 10, 305, 300);
        // panelStockItemItemInfo.setBackground(Color.gray);
        // panelStockItemItemInfo.setLayout(new GridBagLayout());
        // panelStockItem.add(panelStockItemItemInfo);

      

        // Item Info Panel Elements
            // Labels
            gbc.gridx = 0;
            gbc.gridy = 0;
            labelStockItemItemNameLabel.setHorizontalAlignment(JLabel.LEFT);
            labelStockItemItemNameLabel.setFont(font2);
            panelStockItemItemInfo.add(labelStockItemItemNameLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            labelStockItemItemPriceLabel.setHorizontalAlignment(JLabel.LEFT);
            labelStockItemItemPriceLabel.setFont(font2);
            panelStockItemItemInfo.add(labelStockItemItemPriceLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            labelStockItemItemCaloriesLabel.setHorizontalAlignment(JLabel.LEFT);
            labelStockItemItemCaloriesLabel.setFont(font2);
            panelStockItemItemInfo.add(labelStockItemItemCaloriesLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            labelStockItemItemStockLabel.setHorizontalAlignment(JLabel.LEFT);
            labelStockItemItemStockLabel.setFont(font2);
            panelStockItemItemInfo.add(labelStockItemItemStockLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            labelStockItemItemIndexLabel.setHorizontalAlignment(JLabel.LEFT);
            labelStockItemItemIndexLabel.setFont(font2);
            panelStockItemItemInfo.add(labelStockItemItemIndexLabel, gbc);
        
            // Values
            // labelStockItemItemName.setText(vm.getItemSlots().get(0).getItemName());
            // labelStockItemItemName.setText("");
            labelStockItemItemName.setHorizontalAlignment(JLabel.CENTER);
            labelStockItemItemName.setForeground(new Color(0xeeeeee));
            labelStockItemItemName.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panelStockItemItemInfo.add(labelStockItemItemName, gbc);
            
            // labelStockItemItemPrice.setText(String.valueOf(vm.getItemSlots().get(0).getItemCost()));
            labelStockItemItemPrice.setHorizontalAlignment(JLabel.CENTER);
            labelStockItemItemPrice.setForeground(new Color(0xeeeeee));
            labelStockItemItemPrice.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panelStockItemItemInfo.add(labelStockItemItemPrice, gbc);
            
            // labelStockItemItemCalories.setText(String.valueOf(vm.getItemSlots().get(0).getItemCalories()));
            labelStockItemItemCalories.setHorizontalAlignment(JLabel.CENTER);
            labelStockItemItemCalories.setForeground(new Color(0xeeeeee));
            labelStockItemItemCalories.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 2;
            panelStockItemItemInfo.add(labelStockItemItemCalories, gbc);

            // labelStockItemItemStock.setText(String.valueOf(vm.getItemSlots().get(0).getItems().size()));
            labelStockItemItemStock.setHorizontalAlignment(JLabel.CENTER);
            labelStockItemItemStock.setForeground(new Color(0xeeeeee));
            labelStockItemItemStock.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 3;
            panelStockItemItemInfo.add(labelStockItemItemStock, gbc);

            // labelStockItemItemIndex.setText("0");
            labelStockItemItemIndex.setHorizontalAlignment(JLabel.CENTER);
            labelStockItemItemIndex.setForeground(new Color(0xeeeeee));
            labelStockItemItemIndex.setFont(font2);
            gbc.gridx = 1;
            gbc.gridy = 4;
            panelStockItemItemInfo.add(labelStockItemItemIndex, gbc);






        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(0,0,800,1000);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelCont() {
        return panelCont;
    }

    public void setRegularVMView(RegularVMView regularVMView) {
        this.regularVMView = regularVMView;
    }
}
