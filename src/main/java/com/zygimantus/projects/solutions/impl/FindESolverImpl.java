package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class FindESolverImpl extends Solver {

    public static BigDecimal e = BigDecimal.ZERO;

    public void solution1() {
        System.out.println("How many digits of e");

        Scanner scanner = new Scanner(System.in);
        final int scale = Integer.parseInt(scanner.nextLine());

        e = (new BigDecimal(Math.E)).setScale(scale, BigDecimal.ROUND_HALF_UP);

        System.out.println("e: " + e);
    }

    @Override
    public void solve() {

        // 
        solution1();
        //
    }

}
