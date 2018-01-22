package com.zygimantus.projects.solutions;

import com.beust.jcommander.JCommander;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author Zygimantus
 */
public class Main {

    public static void main(String[] args) {

        Settings settings = new Settings();

        JCommander.newBuilder()
                .programName("Projects-Solutions")
                .addObject(settings)
                .build()
                .parse(args);

        run(Optional.ofNullable(settings.getProjects()).orElseGet(() -> {

            Projects p = null;
            Scanner console = new Scanner(System.in);
            boolean correct = false;

            System.out.println("Below are the list of projects that can be solved:");

            // list of all Projects
            for (ProjectsCategory pc : ProjectsCategory.values()) {
                System.out.println("== " + pc + " ==");
                Projects[] projects = pc.getProjects();
                for (int i = 0; i < projects.length; i++) {
                    System.out.println(i + ") [" + projects[i].name() + "] - " + projects[i].getDescription());
                }
            }

            do {
                System.out.print("Enter a code for a problem (project) to be solved: ");
                String value = console.nextLine();
                System.out.println();
                try {
                    p = Projects.valueOf(value);
                    correct = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Illegal code was entered, please try again!");
                }
            } while (!correct);

            return p;
        }));
    }

    public static void run(Projects projects) {
        System.out.println("Running: " + projects);
        projects.solve();
        System.out.println("Solved: " + projects);
    }
}
