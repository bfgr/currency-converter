import javax.swing.*;
import java.awt.*;

public class CurrencyConverter {

    JFrame frame;
    JTextField amountField;
    JComboBox<String> fromCurrency;
    JComboBox<String> toCurrency;
    JLabel resultLabel;

    public CurrencyConverter() {

        frame = new JFrame("Currency Converter");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");

        amountField = new JTextField(10);

        String[] currencies = {
                "USD",
                "EUR",
                "RUB",
                "GBP",
                "JPY"
        };

        fromCurrency =
                new JComboBox<>(currencies);

        toCurrency =
                new JComboBox<>(currencies);

        JButton convertButton =
                new JButton("Convert");

        resultLabel =
                new JLabel("Result: ");

        convertButton.addActionListener(
                e -> convertCurrency()
        );

        frame.add(amountLabel);
        frame.add(amountField);

        frame.add(new JLabel("From"));
        frame.add(fromCurrency);

        frame.add(new JLabel("To"));
        frame.add(toCurrency);

        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void convertCurrency() {

        try {

            double amount =
                    Double.parseDouble(
                            amountField.getText()
                    );

            String from =
                    fromCurrency
                            .getSelectedItem()
                            .toString();

            String to =
                    toCurrency
                            .getSelectedItem()
                            .toString();

            double result = amount;

            if(from.equals("USD") && to.equals("EUR"))
                result = amount * 0.88;

            else if(from.equals("EUR") && to.equals("USD"))
                result = amount * 1.13;

            else if(from.equals("USD") && to.equals("RUB"))
                result = amount * 79;

            else if(from.equals("RUB") && to.equals("USD"))
                result = amount * 0.013;

            else if(from.equals("GBP") && to.equals("USD"))
                result = amount * 1.35;

            else if(from.equals("USD") && to.equals("GBP"))
                result = amount * 0.74;

            resultLabel.setText(
                    "Result: " +
                    String.format("%.2f",result)
                    + " " + to
            );

        }

        catch(Exception e){

            JOptionPane.showMessageDialog(
                    frame,
                    "Enter a valid number!"
            );
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new CurrencyConverter()
        );
    }
}
