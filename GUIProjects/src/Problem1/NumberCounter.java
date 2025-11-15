package Problem1;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NumberCounter {
    private JButton decrease;
    private JButton increase;
    private JLabel count;
    private JPanel mainPanel;

    public NumberCounter(){
        decrease.setName("decreaseButton");
        increase.setName("increaseButton");
        count.setName("countLabel");

        count.setText("0");
        decrease.setText("Decrease");
        increase.setText("Increase");

        decrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ctr = Integer.parseInt(count.getText());
                count.setText((--ctr) + "");
            }
        });


        increase.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int ctr = Integer.parseInt(count.getText());
                count.setText((++ctr) + "");
            }
        });
    }

    public static void main(String[] args) {
        JFrame jframe = new JFrame("Number Counter");
        jframe.setContentPane(new NumberCounter().mainPanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
    }
}
