package MavsDatabase;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class MainPage implements ActionListener {

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        addALabel("Please Select a Command", pane);
        
        File file = new File("Menu.dat");
        Scanner input = new Scanner(System.in);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("Error: FILE NOT FOUND");

        }
        while(input.hasNext()) {
        addAButton(input.nextLine(), pane);
        }
        addAButton("Close", pane, new ExitCommand());
        input.close();
    }

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        
    }

    private static void addAButton(String text, Container container, Command command) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        
    }
    private static void addALabel(String text,Container container) {
        JLabel label = new JLabel(text);
       // label.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(label);
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Dallas Mavericks Player Statisics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public MainPage() {
        createAndShowGUI();
    }  


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}
