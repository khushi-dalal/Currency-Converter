import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class currencyconverter {

    public static void converter() {

        JFrame f = new JFrame("Currency Converter");
        f.getContentPane().setBackground(new Color(51, 153, 255));
        f.getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField t1, t2;
        JButton b1, b2, b3;

        // Add heading in cursive font
        JLabel heading = new JLabel("Currency Converter");
        heading.setFont(new Font("Montserrat", Font.BOLD, 28));
        heading.setForeground(new Color(255, 213, 128));
        heading.setBounds(100, 10, 300, 50);
        f.add(heading);

        JComboBox<String> currencySelectorFrom = new JComboBox<String>();
        currencySelectorFrom.addItem("Rupees");
        currencySelectorFrom.addItem("Dollars");
        currencySelectorFrom.addItem("Euros");
        currencySelectorFrom.addItem("Pounds");
        currencySelectorFrom.addItem("Dirhams");
        currencySelectorFrom.setFont(new Font("Arial", Font.PLAIN, 14));
        currencySelectorFrom.setBounds(20, 80, 100, 30);

        JComboBox<String> currencySelectorTo = new JComboBox<String>();
        currencySelectorTo.addItem("Rupees");
        currencySelectorTo.addItem("Dollars");
        currencySelectorTo.addItem("Euros");
        currencySelectorTo.addItem("Pounds");
        currencySelectorTo.addItem("Dirhams");
        currencySelectorTo.setFont(new Font("Arial", Font.PLAIN, 14));
        currencySelectorTo.setBounds(250, 80, 100, 30);

        t1 = new JTextField("0");
        t1.setBounds(122, 80, 80, 30);
        t2 = new JTextField("0");
        t2.setBounds(352, 80, 80, 30);

        b1 = new JButton("Convert");
        b1.setBounds(120, 150, 100, 30);
        b1.setBackground(new Color(255, 153, 51));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.PLAIN, 14));

        b3 = new JButton("Close");
        b3.setBounds(240, 150, 100, 30);
        b3.setBackground(new Color(255, 153, 51));
        b3.setFont(new Font("Arial", Font.PLAIN, 14));
        b3.setForeground(Color.WHITE);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double input = Double.parseDouble(t1.getText());
                double output = 0;
                double dollarAmount = 0; // Conversion to dollar first

                String selectedCurrencyFrom = (String) currencySelectorFrom.getSelectedItem();
                String selectedCurrencyTo = (String) currencySelectorTo.getSelectedItem();

                // Convert input to dollar
                switch (selectedCurrencyFrom) {
                    case "Rupees":
                        dollarAmount = input / 82.11;
                        break;
                    case "Dollars":
                        dollarAmount = input;
                        break;
                    case "Euros":
                        dollarAmount = input / 0.84; // Conversion rate for Euros
                        break;
                    case "Pounds":
                        dollarAmount = input / 0.76; // Conversion rate for Pounds
                        break;
                    case "Dirhams":
                        dollarAmount = input / 3.67; // Conversion rate for Dirhams
                }

                // Convert dollar amount to selected output currency
                switch (selectedCurrencyTo) {
                    case "Rupees":
                        output = dollarAmount * 82.11;
                        break;
                    case "Dollars":
                        output = dollarAmount;
                        break;
                    case "Euros":
                        output = dollarAmount * 0.84; // Conversion rate for Euros
                        break;
                    case "Pounds":
                        output = dollarAmount * 0.76; // Conversion rate for Pounds
                    case "Dirhams":
                        output = dollarAmount * 3.67; // Conversion rate for Dirhams
                        break;
                }

                t2.setText(String.format("%.2f", output));
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.add(currencySelectorFrom);
        f.add(t1);
        f.add(currencySelectorTo);
        f.add(t2);

        f.add(b1);
        f.add(b3);

        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        converter();
    }
}