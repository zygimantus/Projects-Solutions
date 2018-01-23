package com.zygimantus.projects.solutions;

import com.zygimantus.projects.solutions.impl.FibonacciSeqSolverImpl;
import com.zygimantus.projects.solutions.impl.FindESolverImpl;
import com.zygimantus.projects.solutions.impl.FindPiSolverImpl;
import com.zygimantus.projects.solutions.impl.FindTileCostSolver;
import com.zygimantus.projects.solutions.impl.NextPrimeSolver;
import com.zygimantus.projects.solutions.impl.PrimeFactSolver;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;

/**
 *
 * @author Zygimantus
 */
@Getter
public enum Projects {

    FIND_PI("Find PI to the Nth Digit - Enter a number and have the program generate PI up to that many decimal places. Keep a limit to how far the program will go.",
            ProjectsCategory.NUMBERS,
            FindPiSolverImpl.class
    ),
    FIND_E("Find e to the Nth Digit - Just like the previous problem, but with e instead of PI. Enter a number and have the program generate e up to that many decimal places. Keep a limit to how far the program will go.",
            ProjectsCategory.NUMBERS,
            FindESolverImpl.class
    ),
    FIBONACCI_SEQ("Fibonacci Sequence - Enter a number and have the program generate the Fibonacci sequence to that number or to the Nth number.",
            ProjectsCategory.NUMBERS,
            FibonacciSeqSolverImpl.class
    ),
    PRIME_FACT("Prime Factorization - Have the user enter a number and find all Prime Factors (if there are any) and display them.",
            ProjectsCategory.NUMBERS,
            PrimeFactSolver.class
    ),
    NEXT_PRIME("Next Prime Number - Have the program find prime numbers until the user chooses to stop asking for the next one.",
            ProjectsCategory.NUMBERS,
            NextPrimeSolver.class
    ),
    FIND_TILE_COST("Find Cost of Tile to Cover W x H Floor - Calculate the total cost of tile it would take to cover a floor plan of width and height, using a cost entered by the user.",
            ProjectsCategory.NUMBERS,
            FindTileCostSolver.class
    );

    private final String description;
    private final ProjectsCategory category;
    private final Class<? extends Solver> solverClass;

    private Projects(String description, ProjectsCategory category,
            Class solver) {
        this.description = description;
        this.category = category;
        this.solverClass = solver;
    }

    public void solve() {

        try {
            Solver solver = solverClass.newInstance();
            solver.solve();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Projects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
