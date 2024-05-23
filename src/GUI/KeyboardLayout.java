/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardLayout extends JFrame {
    public KeyboardLayout() {
        super("Keyboard Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 1));

        // First row: Numbers
        JPanel row1 = new JPanel();
        String[] row1Keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=","+"};
        addKeysToPanel(row1, row1Keys);

        // Second row: QWERTY
        JPanel row2 = new JPanel();
        String[] row2Keys = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]"};
        addKeysToPanel(row2, row2Keys);

        // Third row: ASDFGH
        JPanel row3 = new JPanel();
        String[] row3Keys = {"A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter"};
        addKeysToPanel(row3, row3Keys);

        // Fourth row: ZXCVBN
        JPanel row4 = new JPanel();
        String[] row4Keys = {"Z", "X", "C", "V", "B", "N", "M", ",", ".", "/"};
        addKeysToPanel(row4, row4Keys);

        // Fifth row: Space and modifiers
        JPanel row5 = new JPanel();
        String[] row5Keys = {" "   , "Shift"};
        addKeysToPanel(row5, row5Keys);

        keyboardPanel.add(row1);
        keyboardPanel.add(row2);
        keyboardPanel.add(row3);
        keyboardPanel.add(row4);
        keyboardPanel.add(row5);

        add(keyboardPanel, BorderLayout.CENTER);
    }

    private void addKeysToPanel(JPanel panel, String[] keys) {
        for (String key : keys) {
            JButton button = new JButton(key);
            button.addActionListener(new KeyButtonListener());
            panel.add(button);
        }
    }

    private class KeyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            System.out.println("Key pressed: " + source.getText());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KeyboardLayout().setVisible(true);
            }
        });
    }
}
