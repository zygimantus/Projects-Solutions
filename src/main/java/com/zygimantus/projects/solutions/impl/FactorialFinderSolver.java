package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.math.BigInteger;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class FactorialFinderSolver implements Solver {

    // solution that uses recursion
    private BigInteger solution1(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return number.multiply(solution1(number.subtract(BigInteger.ONE)));
        }
    }

    // solution that uses iteration
    private BigInteger solution2(BigInteger number) {
        BigInteger result = BigInteger.ONE;
        if (number.equals(BigInteger.ZERO)) {
            return result;
        } else {

            for (BigInteger bi = BigInteger.ONE;
                    bi.compareTo(number) <= 0;
                    bi = bi.add(BigInteger.ONE)) {
                result = result.multiply(bi);
            }
            return result;
        }
    }

    @Override
    public Void apply(Void t) {
        TextIO textIO = TextIoFactory.getTextIO();

        Long number = textIO.newLongInputReader().read("Enter a number for factorial finder");
        BigInteger factorial = solution1(BigInteger.valueOf(number));
        textIO.getTextTerminal().printf("Factorial using recursion of %s is %s\n", number, factorial);
        factorial = solution2(BigInteger.valueOf(number));
        textIO.getTextTerminal().printf("Factorial using iteration of %s is %s", number, factorial);
        return null;
    }

}
