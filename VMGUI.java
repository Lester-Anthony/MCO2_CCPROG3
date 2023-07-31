import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainMenuView {

    public void MainMenuView() {
        JFrame menuFrame = new JFrame("Main Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);
        menuFrame.setSize(720,420);
        menuFrame.setLayout(new BorderLayout(10,10));


        // BORDER PANELS
        JPanel northPanel = new JPanel();
        // northPanel.setBackground(Color.red);
        northPanel.setPreferredSize(new Dimension(20,20));
        menuFrame.add(northPanel,BorderLayout.NORTH);
        JPanel southPanel = new JPanel();
        // southPanel.setBackground(Color.green);
        southPanel.setPreferredSize(new Dimension(20,20));
        menuFrame.add(southPanel,BorderLayout.SOUTH);
        JPanel westPanel = new JPanel();
        // westPanel.setBackground(Color.yellow);
        westPanel.setPreferredSize(new Dimension(20,20));
        menuFrame.add(westPanel,BorderLayout.WEST);
        JPanel eastPanel = new JPanel();
        // eastPanel.setBackground(Color.magenta);
        eastPanel.setPreferredSize(new Dimension(20,20));
        menuFrame.add(eastPanel,BorderLayout.EAST);

        // SCREEN PANEL
        JPanel screenPanel = new JPanel();
        // screenPanel.setBackground(Color.gray);
        screenPanel.setLayout(new GridBagLayout());

        GridBagConstraints g = new GridBagConstraints();
        
        // BUTTONS
        JLabel menuLabel = new JLabel("MAIN MENU");
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        g.gridx = 1;
        g.gridy = 0;
        screenPanel.add(menuLabel,g);
        JButton btn1 = new JButton("Create Vending Machine");
        g.gridx = 1;
        g.gridy = 2;
        screenPanel.add(btn1,g);
        JButton btn2 = new JButton("Test Vending Machine");
        btn2.addActionListener(e -> menuFrame.dispose());
        // btn2.addActionListener(e -> VendingMachineGUI);
        g.gridx = 1;
        g.gridy = 3;
        screenPanel.add(btn2,g);
        JButton btn3 = new JButton("Exit");
        btn3.addActionListener(e -> menuFrame.dispose());
        g.gridx = 1;
        g.gridy = 4;
        screenPanel.add(btn3,g);
        
        menuFrame.add(screenPanel);
        menuFrame.setVisible(true);
    }

}