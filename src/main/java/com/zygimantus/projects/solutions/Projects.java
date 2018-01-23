package com.zygimantus.projects.solutions;

import com.zygimantus.projects.solutions.impl.FibonacciSeqSolverImpl;
import com.zygimantus.projects.solutions.impl.FindESolverImpl;
import com.zygimantus.projects.solutions.impl.FindPiSolverImpl;
import com.zygimantus.projects.solutions.impl.PrimeFactSolver;
import lombok.Getter;

/**
 *
 * @author Zygimantus
 */
@Getter
public enum Projects {

    FIND_PI("Find PI to the Nth Digit - Enter a number and have the program generate PI up to that many decimal places. Keep a limit to how far the program will go.",
            ProjectsCategory.NUMBERS) {
        @Override
        public void solve() {
            System.out.println("Solving now");

            FindPiSolverImpl findPiSolverImpl = new FindPiSolverImpl();
            findPiSolverImpl.solve();
        }
    },
    FIND_E("Find e to the Nth Digit - Just like the previous problem, but with e instead of PI. Enter a number and have the program generate e up to that many decimal places. Keep a limit to how far the program will go.",
            ProjectsCategory.NUMBERS) {
        @Override
        public void solve() {
            System.out.println("Solving now");

            FindESolverImpl findESolverImpl = new FindESolverImpl();
            findESolverImpl.solve();
        }
    },
    FIBONACCI_SEQ("Fibonacci Sequence - Enter a number and have the program generate the Fibonacci sequence to that number or to the Nth number.",
            ProjectsCategory.NUMBERS) {
        @Override
        public void solve() {
            System.out.println("Solving now");

            FibonacciSeqSolverImpl solverImpl = new FibonacciSeqSolverImpl();
            solverImpl.solve();
        }
    },
    PRIME_FACT("Prime Factorization - Have the user enter a number and find all Prime Factors (if there are any) and display them.",
            ProjectsCategory.NUMBERS) {
        @Override
        public void solve() {
            System.out.println("Solving now");

            PrimeFactSolver solverImpl = new PrimeFactSolver();
            solverImpl.solve();
        }
    };

    private final String description;
    private final ProjectsCategory category;

    private Projects(String description, ProjectsCategory category) {
        this.description = description;
        this.category = category;
    }

    public abstract void solve();
}
