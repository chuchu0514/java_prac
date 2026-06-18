package ui;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        setTitle("계산기");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttons) {
            add(new JButton(label));
        }

        setVisible(true);
    }
}