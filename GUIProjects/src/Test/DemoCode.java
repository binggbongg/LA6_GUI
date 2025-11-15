package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoCode {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create different "cards" (JPanels)
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.add(new JLabel("Card 1"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.add(new JLabel("Card 2"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.add(new JLabel("Card 3"));

        // Add cards to the cardPanel with unique names
        cardPanel.add(panel1, "Card1Name");
        cardPanel.add(panel2, "Card2Name");
        cardPanel.add(panel3, "Card3Name");

        // Create buttons to switch cards
        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Previous");


        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel); // Show the next card
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel); // Show the previous card
            }
        });

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}