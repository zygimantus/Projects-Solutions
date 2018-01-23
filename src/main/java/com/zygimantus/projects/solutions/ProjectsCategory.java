package com.zygimantus.projects.solutions;

import lombok.Getter;

/**
 *
 * @author Zygimantus
 */
@Getter
public enum ProjectsCategory {

    NUMBERS("numbers", new Projects[]{
        Projects.FIND_PI,
        Projects.FIND_E,
        Projects.FIBONACCI_SEQ,
        Projects.PRIME_FACT,
        Projects.NEXT_PRIME,
        Projects.FIND_TILE_COST,});

    private final String code;
    private final Projects[] projects;

    private ProjectsCategory(String code, Projects[] projects) {
        this.code = code;
        this.projects = projects;
    }

}
