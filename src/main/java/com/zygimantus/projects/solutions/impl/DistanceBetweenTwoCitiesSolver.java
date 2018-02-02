package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import lombok.Builder;
import lombok.Data;
import org.beryx.textio.InputReader;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class DistanceBetweenTwoCitiesSolver implements Solver {

    public static TextIO textIO = TextIoFactory.getTextIO();

    @Override
    public Void apply(Void t) {

        ClassLoader classLoader = DistanceBetweenTwoCitiesSolver.class.getClassLoader();
        File file = new File(classLoader.getResource("simplemaps-worldcities-basic.csv").getFile());
        String line;
        String cvsSplitBy = ",";
        List<WorldCities> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                List<String> data = new ArrayList(Arrays.asList(line.split(cvsSplitBy)));
                // if element at index 8 is not present we add it
                if (data.size() != 9) {
                    data.add("-");
                }
                list.add(WorldCities.builder()
                        .city(data.get(0))
                        .city_ascii(data.get(1))
                        .lat(data.get(2))
                        .lng(data.get(3))
                        .pop(data.get(4))
                        .country(data.get(5))
                        .iso2(data.get(6))
                        .iso3(data.get(7))
                        .province(data.get(8))
                        .build()
                );
            }

        } catch (IOException e) {
        }
        Function<String, InputReader.ParseResult<WorldCities>> parser = (String t1) -> null;

        WorldCities c1 = textIO.newGenericInputReader(parser).withNumberedPossibleValues(list.subList(1, 25))
                .read("\nSelect first city");

        WorldCities c2 = textIO.newGenericInputReader(parser).withNumberedPossibleValues(list.subList(1, 25))
                .read("\nSelect second city");

        UnitOfDistance uod = textIO.newEnumInputReader(UnitOfDistance.class)
                .read("\nSelect unit of distance");

        double distance = distance(c1, c2, uod);

        textIO.getTextTerminal().printf("Distance betwen %s and %s is %s %s", c1, c2, distance, uod);

        return null;
    }

    // see more at: https://www.geodatasource.com/developers/java
    private static double distance(WorldCities c1, WorldCities c2, UnitOfDistance uod) {

        double lat1 = Double.valueOf(c1.getLat());
        double lon1 = Double.valueOf(c1.getLng());

        double lat2 = Double.valueOf(c2.getLat());
        double lon2 = Double.valueOf(c2.getLng());

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (uod == UnitOfDistance.KILOMETER) {
            dist = dist * 1.609344;
        }

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    @Data
    @Builder
    public static class WorldCities {

        private String city;
        private String city_ascii;
        private String lat;
        private String lng;
        private String pop;
        private String country;
        private String iso2;
        private String iso3;
        private String province;

        @Override
        public String toString() {
            return city + "(" + country + ")";
        }

    }

    public enum UnitOfDistance {

        MILE,
        KILOMETER
    }

}
