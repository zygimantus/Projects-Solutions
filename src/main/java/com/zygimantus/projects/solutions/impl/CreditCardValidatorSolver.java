package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class CreditCardValidatorSolver extends JFrame implements Solver {

    public static TextIO textIO = TextIoFactory.getTextIO();

    @Override
    public Void apply(Void t) {

        String creditCard = JOptionPane.showInputDialog("Enter a credit card number to validate it");

        validateCreditCardNumber(creditCard);

        return null;
    }

    // see: https://www.journaldev.com/1443/java-credit-card-validation-luhn-algorithm-java
    private static void validateCreditCardNumber(String creditCardNumber) {

        int[] ints = new int[creditCardNumber.length()];
        for (int i = 0; i < creditCardNumber.length(); i++) {
            ints[i] = Integer.parseInt(creditCardNumber.substring(i, i + 1));
        }
        // using Luhn algorithm here
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        if (sum % 10 == 0) {
            textIO.getTextTerminal().printf("%s is a valid credit card number", creditCardNumber);
        } else {
            textIO.getTextTerminal().printf("%s is an invalid credit card number", creditCardNumber);
        }
    }
}
