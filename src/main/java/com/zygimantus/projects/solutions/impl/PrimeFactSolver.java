package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class PrimeFactSolver extends Solver {

    @Override
    public void solve() {

        int num = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter number to find Prime factors of: ");

        num = scan.nextInt();

        primeFactors(num);

        System.out.println();
    }

    // see: https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
    public static void primeFactors(int n) {
        // 1) While n is divisible by 2, print 2 and divide n by 2.        
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // 2) After step 1, n must be odd. Now start a loop from i = 3 
        // to square root of n. While i divides n, print i and divide n by i, 
        // increment i by 2 and continue.        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        //3) If n is a prime number and is greater than 2, then n will not 
        // become 1 by above two steps. So print n if it is greater than 2.        
        if (n > 2) {
            System.out.print(n);
        }
    }
}
