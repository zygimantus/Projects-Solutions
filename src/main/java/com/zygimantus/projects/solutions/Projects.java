package com.zygimantus.projects.solutions;

import com.zygimantus.projects.solutions.impl.AlarmClockSolver;
import com.zygimantus.projects.solutions.impl.CalculatorSolver;
import com.zygimantus.projects.solutions.impl.CreditCardValidatorSolver;
import com.zygimantus.projects.solutions.impl.DistanceBetweenTwoCitiesSolver;
import com.zygimantus.projects.solutions.impl.FactorialFinderSolver;
import com.zygimantus.projects.solutions.impl.FibonacciSeqSolverImpl;
import com.zygimantus.projects.solutions.impl.FindESolverImpl;
import com.zygimantus.projects.solutions.impl.FindPiSolverImpl;
import com.zygimantus.projects.solutions.impl.FindTileCostSolver;
import com.zygimantus.projects.solutions.impl.NextPrimeSolver;
import com.zygimantus.projects.solutions.impl.PrimeFactSolver;
import com.zygimantus.projects.solutions.impl.UnitConvSolver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            new FindPiSolverImpl()
    ),
    FIND_E(
            "Find e to the Nth Digit",
            ProjectsCategory.NUMBERS,
            new FindESolverImpl()
    ),
    FIBONACCI_SEQ(
            "Fibonacci Sequence",
            ProjectsCategory.NUMBERS,
            new FibonacciSeqSolverImpl()
    ),
    PRIME_FACT(
            "Prime Factorization",
            ProjectsCategory.NUMBERS,
            new PrimeFactSolver()
    ),
    NEXT_PRIME(
            "Next Prime Number",
            ProjectsCategory.NUMBERS,
            new NextPrimeSolver()
    ),
    FIND_COST_OF_TILE(
            "Find Cost of Tile to Cover W x H Floor",
            ProjectsCategory.NUMBERS,
            new FindTileCostSolver()
    ),
    MORTAGE_CALC(
            "Mortgage Calculator",
            ProjectsCategory.NUMBERS,
            new FindTileCostSolver()
    ),
    CALCULATOR(
            "Calculator",
            ProjectsCategory.NUMBERS,
            new CalculatorSolver()
    ),
    UNIT_CONV(
            "Unit Converter (temp, currency, volume, mass and more)",
            ProjectsCategory.NUMBERS,
            new UnitConvSolver()
    ),
    ALARM_CLOCK(
            "Alarm Clock",
            ProjectsCategory.NUMBERS,
            new AlarmClockSolver()
    ),
    DISTANCE_BETWEEN_TWO_CITIES(
            "Distance Between Two Cities",
            ProjectsCategory.NUMBERS,
            new DistanceBetweenTwoCitiesSolver()
    ),
    CREDIT_CARD_VALIDATOR(
            "Credit Card Validator",
            ProjectsCategory.NUMBERS,
            new CreditCardValidatorSolver()
    ),
    TAX_CALCULATOR(
            "Tax Calculator",
            ProjectsCategory.NUMBERS,
            new CreditCardValidatorSolver()
    ),
    FACTORIAL_FINDER(
            "Factorial Finder",
            ProjectsCategory.NUMBERS,
            new FactorialFinderSolver()
    ),
    // placeholder for exit
    EXIT(
            "Exit",
            null,
            (t) -> {
                System.exit(0);
                return null;
            }
    );

    private final String title;
    private final ProjectsCategory category;
    private final Solver solver;

    private String description;

    private Projects(String title, ProjectsCategory category,
            Solver solver) {
        this.title = title;
        this.category = category;
        this.solver = solver;
    }

    public void solve() {
        solver.apply(null);
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
                    this.description = parts[1];
                }
            }

        } catch (IOException e) {
        }
        this.description = "(description is not available)";
        return this.description;
    }
}
