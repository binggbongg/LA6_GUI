package Problem9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Geography {
    private static boolean answeredQ1 = false;
    private static boolean answeredQ2 = false;
    private static boolean answeredQ3 = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Geography Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
        frame.setLocationRelativeTo(null);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JPanel scorePanel = new JPanel();
        scorePanel.add(new JLabel("Your Score: "));
        JLabel scoreLabel = new JLabel();
        scoreLabel.setText("0");
        scorePanel.add(scoreLabel);
        scorePanel.add(new JLabel("/ 3"));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label1 = new JLabel("What is the capital of France?");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(label1);

        JTextField q1 = new JTextField(22);
        q1.setName("question1TextField");
        q1.setMaximumSize(q1.getPreferredSize());
        q1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(q1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label2 = new JLabel("What is the capital of Japan?");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(label2);

        JTextField q2 = new JTextField(22);
        q2.setName("question2TextField");
        q2.setMaximumSize(q2.getPreferredSize());
        q2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(q2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label3= new JLabel("What is the capital of Germany?");
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(label3);

        JTextField q3 = new JTextField(22);
        q3.setName("question3TextField");
        q3.setMaximumSize(q3.getPreferredSize());
        q3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel3.add(q3);

        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("Congratulations! You have finished the quiz."));

        cardPanel.add(panel1, "panel1");
        cardPanel.add(panel2, "panel2");
        cardPanel.add(panel3, "panel3");
        cardPanel.add(panel4, "panel4");

        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Next");
        JButton prevButton = new JButton("Back");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score = Integer.parseInt(scoreLabel.getText());

                if(q1.getText().equals("Paris") && !answeredQ1){
                    scoreLabel.setText(++score + "");
                    answeredQ1 = true;
                }

                if(q2.getText().equals("Tokyo") && !answeredQ2){
                    scoreLabel.setText(++score + "");
                    answeredQ2 = true;
                }

                if(q3.getText().equals("Berlin") && !answeredQ3){
                    scoreLabel.setText(++score + "");
                    answeredQ3 = true;
                }

                q1.setText("");
                q2.setText("");
                q3.setText("");

                cardLayout.next(cardPanel); // Show the next card
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
