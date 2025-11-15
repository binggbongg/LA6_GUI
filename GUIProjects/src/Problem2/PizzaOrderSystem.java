package Problem2;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PizzaOrderSystem {
    private JPanel mainPanel;
    private JComboBox<String> sizeChoices;
    private JComboBox<String> toppingsChoices;
    private JComboBox<String> cheeseOption;
    private JButton totalButton;
    private JLabel pizzaSize;
    private JLabel pizzaToppings;
    private JLabel cheese;
    private JLabel totalLabel;

    public PizzaOrderSystem(){
        sizeChoices.setName("pizzaSizeChoice");
        toppingsChoices.setName("pizzaToppingsChoice");
        cheeseOption.setName("extraCheeseChoice");
        totalLabel.setName("totalLabel");
        totalButton.setName("calculateButton");

        totalButton.setText("Calculate Total");
        totalLabel.setText("0");
        totalLabel.setVisible(false);

        String[] sizes = {"Small", "Medium", "Large"};
        for(String s : sizes) sizeChoices.addItem(s);

        String[] toppings = {"Mushrooms", "Pepperoni", "Onions"};
        for(String s : toppings) toppingsChoices.addItem(s);

        cheeseOption.addItem("Yes");
        cheeseOption.addItem("No");

        totalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int total = 2;
                String size = sizeChoices.getSelectedItem().toString();
                String cheese = cheeseOption.getSelectedItem().toString();

                if(size.equals("Small")){
                    total += 10;
                } else if(size.equals("Medium")){
                    total += 15;
                } else {
                    total += 20;
                }

                if(cheese.equals("Yes")){
                    total += 3;
                }

                totalLabel.setText("" + total);
                totalLabel.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pizza Order System");
        frame.setContentPane(new PizzaOrderSystem().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
