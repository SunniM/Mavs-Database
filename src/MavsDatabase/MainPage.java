package MavsDatabase;

import java.awt.Component;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

import javax.swing.*;

public class MainPage {

    Connection connection;

    JTextField jTextField;
    JRadioButton rb;

    boolean allPlayers = false;
    String playerNum;

    private void addComponentsToPane(Container panel) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(1000, 400);

        
        addALabel("Please Select a Command", panel);
        
        File file = new File("Menu.dat");
        Scanner input = new Scanner(System.in);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Error: FILE NOT FOUND");

        }
        String text, commandName;
        String[] fileLine;
        while(input.hasNext()) {
            fileLine = input.nextLine().split(",");
            text = fileLine[0];
            commandName = fileLine[1].trim();
            addAButton(text,panel,Command.CreateCommandDynamically(commandName, connection));
        }
        addAButton("Close", panel, new ExitCommand(connection));
        input.close();
    }
   
    private void addAButton(String text, Container container, Command command) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                command.Execute();
            }        
        });
        
    }
    private void addALabel(String text,Container container) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
       // label.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(label);
    }
    
    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Dallas Mavericks Player Statisics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content panel.
        
        addComponentsToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public MainPage(Connection connection) {
        this.connection = connection;
        createAndShowGUI();
    }  



    
}
