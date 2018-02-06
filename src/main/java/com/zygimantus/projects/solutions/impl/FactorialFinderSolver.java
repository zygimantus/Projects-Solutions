package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class FactorialFinderSolver implements Solver {

    public void solution1() {

        TextIO textIO = TextIoFactory.getTextIO();

        Long number = textIO.newLongInputReader().read("Enter a number for factorial finder");
        long factorial = findFactorial(number);
        textIO.getTextTerminal().printf("Factorial of %s is %s", number, factorial);
    }

    // solution that uses recursion
    private long findFactorial(Long number) {
        if (number == 0) {
            return 1;
        } else {
            return number * findFactorial(number - 1);
        }
    }

    @Override
    public Void apply(Void t) {
        solution1();
        return null;
    }

}
