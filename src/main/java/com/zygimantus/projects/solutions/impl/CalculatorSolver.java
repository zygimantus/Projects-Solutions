package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;

/**
 *
 * @author Zygimantus
 */
public class CalculatorSolver implements Solver {

    @Override
    public Void apply(Void t) {

        Calculator calculator = new Calculator();
        calculator.setVisible(true);

        return null;
    }

}
