package com.zygimantus.projects.solutions;
 
import com.beust.jcommander.JCommander;
 
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
                .build();
 
        run(settings.getProjects());
    }
 
    public static void run(Projects projects) {
        System.out.println("Running: " + projects);
    }
}