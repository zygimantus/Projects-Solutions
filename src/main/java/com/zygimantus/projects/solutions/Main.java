package com.zygimantus.projects.solutions;

import com.beust.jcommander.JCommander;
import java.util.Optional;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.jline.JLineTextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;

/**
 *
 * @author Zygimantus
 */
public class Main {

    public static TextIO textIO = TextIoFactory.getTextIO();

    public static void main(String[] args) {

        Settings settings = new Settings();

        JCommander.newBuilder()
                .programName("Projects-Solutions")
                .addObject(settings)
                .build()
                .parse(args);

        Optional.ofNullable(settings.getProjects()).orElseGet(() -> {

            Projects p;
            do {
                TextTerminal terminal = textIO.getTextTerminal();
                clearScreen(terminal);
                p = textIO.newEnumInputReader(Projects.class)
                        .read("\nWhich project you want to do?");

                p.solve();
            } while (!p.equals(Projects.EXIT));

            return p;
        });
    }

    public static void clearScreen(TextTerminal terminal) {
        if (terminal instanceof JLineTextTerminal) {
            terminal.print("\033[H\033[2J");
        } else if (terminal instanceof SwingTextTerminal) {
            ((SwingTextTerminal) terminal).resetToOffset(0);
        }
    }

}
