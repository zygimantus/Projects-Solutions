package com.zygimantus.projects.solutions;

/**
 *
 * @author Zygimantus
 */
public enum Projects {

    FIND_PI("Find PI to the Nth Digit - Enter a number and have the program generate PI up to that many decimal places. Keep a limit to how far the program will go.",
            "numbers") {
        @Override
        public void solve() {
            System.out.println("Solving now");

            FindPiSolverImpl findPiSolverImpl = new FindPiSolverImpl();
            findPiSolverImpl.solve();
        }
    },
    FIND_E("Find e to the Nth Digit - Just like the previous problem, but with e instead of PI. Enter a number and have the program generate e up to that many decimal places. Keep a limit to how far the program will go.",
            "numbers") {
        @Override
        public void solve() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    private final String description;
    private final String category;

    private Projects(String description, String category) {
        this.description = description;
        this.category = category;
    }

    public abstract void solve();
}
