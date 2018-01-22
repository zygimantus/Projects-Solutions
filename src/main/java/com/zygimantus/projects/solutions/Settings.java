package com.zygimantus.projects.solutions;

import com.beust.jcommander.Parameter;
import lombok.Getter;

/**
 *
 * @author Zygimantus
 */
@Getter
public class Settings {

    @Parameter(names = "-p", description = "Project name that needs to be solved")
    private Projects projects;

}
