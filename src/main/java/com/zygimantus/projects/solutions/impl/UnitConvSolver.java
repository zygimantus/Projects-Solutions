package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.util.function.Function;
import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import static javax.measure.unit.NonSI.FAHRENHEIT;
import static javax.measure.unit.NonSI.RANKINE;
import lombok.Getter;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

/**
 *
 * @author Zygimantus
 */
public class UnitConvSolver implements Solver {

    @Override
    public Void apply(Void t) {

        TextIO textIO = TextIoFactory.getTextIO();

        Convertion convertion = textIO.newEnumInputReader(Convertion.class)
                .read("\nWhich convertion you would like to make?");

        Long longValue = textIO.newLongInputReader().read("\nWhat quantity to convert?");

        textIO.getTextTerminal().printf("Answer is %s", convertion.getFuntion().apply(longValue));

        return null;
    }

    @Getter
    public enum Convertion {
        RANKINE_TO_FAHRENHEIT(
                (Long longValue) -> {
                    UnitConverter toFahrenheit = RANKINE.getConverterTo(FAHRENHEIT);
                    double fahrenheits = toFahrenheit.convert(Measure.valueOf(longValue, RANKINE).doubleValue(RANKINE));

                    return fahrenheits;
                }),
        FAHRENHEIT_TO_RANKINE(
                (Long longValue) -> {
                    UnitConverter toRankine = FAHRENHEIT.getConverterTo(RANKINE);
                    double rankines = toRankine.convert(Measure.valueOf(longValue, RANKINE).doubleValue(RANKINE));

                    return rankines;
                });

        private final Function<Long, Double> funtion;

        private Convertion(Function<Long, Double> funtion) {
            this.funtion = funtion;
        }
    }

}
