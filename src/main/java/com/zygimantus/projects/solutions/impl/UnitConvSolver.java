package com.zygimantus.projects.solutions.impl;

import com.zygimantus.projects.solutions.Solver;
import java.util.function.Function;
import javax.measure.Measure;
import javax.measure.converter.UnitConverter;
import static javax.measure.unit.NonSI.FAHRENHEIT;
import static javax.measure.unit.NonSI.GALLON_UK;
import static javax.measure.unit.NonSI.LITRE;
import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.NonSI.RANKINE;
import static javax.measure.unit.SI.KILOMETER;
import javax.measure.unit.Unit;
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
                (longValue) -> convertUsingJavaxMeasureConverter(RANKINE, FAHRENHEIT, longValue)),
        FAHRENHEIT_TO_RANKINE(
                (longValue) -> convertUsingJavaxMeasureConverter(FAHRENHEIT, RANKINE, longValue)),
        MILES_TO_KILOMETERS(
                (longValue) -> convertUsingJavaxMeasureConverter(MILE, KILOMETER, longValue)),
        KILOMETERS_TO_MILES(
                (longValue) -> convertUsingJavaxMeasureConverter(KILOMETER, MILE, longValue)),
        GALLON_UK_TO_LITRE(
                (longValue) -> convertUsingJavaxMeasureConverter(GALLON_UK, LITRE, longValue)),
        LITRE_TO_GALLON_UK(
                (longValue) -> convertUsingJavaxMeasureConverter(LITRE, GALLON_UK, longValue)),
        METRIC_TON_TO_POUND(
                (longValue) -> convertUsingJavaxMeasureConverter(METRIC_TON, POUND, longValue)),
        POUND_TO_METRIC_TON(
                (longValue) -> convertUsingJavaxMeasureConverter(POUND, METRIC_TON, longValue));

        private final Function<Long, Double> funtion;

        private Convertion(Function<Long, Double> funtion) {
            this.funtion = funtion;
        }

        private static double convertUsingJavaxMeasureConverter(Unit unitFrom, Unit unitTo, Long longValue) {
            UnitConverter toRankine = unitFrom.getConverterTo(unitTo);
            double answer = toRankine.convert(Measure.valueOf(longValue, unitFrom).doubleValue(unitFrom));

            return answer;
        }
    }

}
