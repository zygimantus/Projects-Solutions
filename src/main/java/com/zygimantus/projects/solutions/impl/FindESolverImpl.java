package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.math.BigDecimal;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class FindESolverImpl implements Solver {

    public static BigDecimal e = BigDecimal.ZERO;

    public void solution1() {

        TextIO textIO = TextIoFactory.getTextIO();

        int digits = textIO.newIntInputReader().read("How many digits of e");
        e = (new BigDecimal(Math.E)).setScale(digits, BigDecimal.ROUND_HALF_UP);

        textIO.getTextTerminal().printf("e: %s", e);
    }

    @Override
    public Void apply(Void t) {
        solution1();
        return null;
    }

}
