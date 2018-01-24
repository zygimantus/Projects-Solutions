package com.zygimantus.projects.solutions;

import com.beust.jcommander.JCommander;
import java.util.Optional;
import java.util.Scanner;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

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

            Scanner console = new Scanner(System.in);
            boolean correct = false;

            TextIO textIO = TextIoFactory.getTextIO();

            Projects p = textIO.newEnumInputReader(Projects.class)
                    .read("Which project you want to do?");

            return p;
        }));
    }

    public static void run(Projects projects) {
        System.out.println("Running: " + projects);
        projects.solve();
        System.out.println("Solved: " + projects);
    }
}
