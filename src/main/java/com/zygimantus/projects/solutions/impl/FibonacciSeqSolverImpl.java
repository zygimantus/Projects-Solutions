package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class FibonacciSeqSolverImpl implements Solver {

    public static int numberOf;

    @Override
    public Void apply(Void t) {
        System.out.println("Enter the number to that Fibonacci sequence is generated: ");

        Scanner input = new Scanner(System.in);
        numberOf = input.nextInt();
        if (numberOf > 0) {
            for (int i = 1; i <= numberOf; i++) {

                System.out.print(fibonacciSeq(i) + " ");
            }
            System.out.println();
        }
        return null;
    }

    protected static int fibonacciSeq(int index) {
        if (index == 1 || index == 2) {
            return 1;
        }

        return fibonacciSeq(index - 1) + fibonacciSeq(index - 2);
    }
}
