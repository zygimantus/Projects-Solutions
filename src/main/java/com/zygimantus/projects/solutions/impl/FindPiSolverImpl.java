package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.math.BigDecimal;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class FindPiSolverImpl implements Solver {

    public static BigDecimal pi = BigDecimal.ZERO;

    public void solution1() {

        TextIO textIO = TextIoFactory.getTextIO();

        int digits = textIO.newIntInputReader().read("How many digits of PI");
        pi = (new BigDecimal(Math.PI)).setScale(digits, BigDecimal.ROUND_HALF_UP);

        textIO.getTextTerminal().printf("PI: %s", pi);
    }

    @Override
    public Void apply(Void t) {
        solution1();
        return null;
    }

}
