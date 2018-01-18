package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class FindPiSolverImpl extends Solver {

    public static BigDecimal pi = BigDecimal.ZERO;

    public void solution1() {
        System.out.println("How many digits of Pi");

        Scanner scanner = new Scanner(System.in);
        final int scale = Integer.parseInt(scanner.nextLine());

        pi = (new BigDecimal(Math.PI)).setScale(scale, BigDecimal.ROUND_HALF_UP);

        System.out.println("Pi: " + pi);
    }

    @Override
    public void solve() {

        // 
        solution1();
        //
    }

}
