package com.zygimantus.projects.solutions;

import com.zygimantus.projects.solutions.impl.CalculatorSolver;
import com.zygimantus.projects.solutions.impl.FibonacciSeqSolverImpl;
import com.zygimantus.projects.solutions.impl.FindESolverImpl;
import com.zygimantus.projects.solutions.impl.FindPiSolverImpl;
import com.zygimantus.projects.solutions.impl.FindTileCostSolver;
import com.zygimantus.projects.solutions.impl.NextPrimeSolver;
import com.zygimantus.projects.solutions.impl.PrimeFactSolver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;

/**
 *
 * @author Zygimantus
 */
@Getter
public enum Projects {

    FIND_PI(
            "Find PI to the Nth Digit",
            ProjectsCategory.NUMBERS,
            FindPiSolverImpl.class
    ),
    FIND_E(
            "Find e to the Nth Digit",
            ProjectsCategory.NUMBERS,
            FindESolverImpl.class
    ),
    FIBONACCI_SEQ(
            "Fibonacci Sequence",
            ProjectsCategory.NUMBERS,
            FibonacciSeqSolverImpl.class
    ),
    PRIME_FACT(
            "Prime Factorization",
            ProjectsCategory.NUMBERS,
            PrimeFactSolver.class
    ),
    NEXT_PRIME(
            "Next Prime Number",
            ProjectsCategory.NUMBERS,
            NextPrimeSolver.class
    ),
    FIND_COST_OF_TILE(
            "Find Cost of Tile to Cover W x H Floor",
            ProjectsCategory.NUMBERS,
            FindTileCostSolver.class
    ),
    MORTAGE_CALC(
            "Mortgage Calculator",
            ProjectsCategory.NUMBERS,
            FindTileCostSolver.class
    ),
    CALCULATOR(
            "Calculator",
            ProjectsCategory.NUMBERS,
            CalculatorSolver.class
    ),
    UNIT_CONV(
            "Unit Converter (temp, currency, volume, mass and more)",
            ProjectsCategory.NUMBERS,
            CalculatorSolver.class
    );

    private final String title;
    private final ProjectsCategory category;
    private final Class<? extends Solver> solverClass;

    private String description;

    private Projects(String title, ProjectsCategory category,
            Class solver) {
        this.title = title;
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

    public String getDescription() {
        ClassLoader classLoader = Projects.class.getClassLoader();
        File file = new File(classLoader.getResource("descriptions.txt").getFile());
        String line;
        String cvsSplitBy = " - ";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(cvsSplitBy);
                if (this.getTitle().equals(parts[0])) {
                    return parts[1];
                }
            }

        } catch (IOException e) {
        }
        return "(description is not available)";

    }
}
