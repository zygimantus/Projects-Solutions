package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class NextPrimeSolver extends Solver {

    @Override
    public void solve() {

        int number = 1;
        Scanner scan = new Scanner(System.in);

        boolean findNext;

        do {

            System.out.println("Find next prime (enter Y/N)? ");

            findNext = scan.nextLine().equals("Y");

            if (findNext) {
                boolean isPrime = true;
                int k = 2;
                while (k <= number / 2) {
                    if (number % k == 0) {
                        isPrime = false;
                        break;
                    }
                    k++;
                }
                if (isPrime) {
                    System.out.println(number + " is a Prime Number");
                } else {
                    System.out.println(number + " is not a Prime Number");
                }
            }

            number++;

        } while (findNext);

        System.out.println();

    }

}
