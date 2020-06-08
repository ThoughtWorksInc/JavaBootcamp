package bootcamp.data;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class Summary {
    public final double min, max, sum, count, average;

    public Summary(double[] array) {
        this.min = determineValue(array, Math::min, Double.NaN);
        this.max = determineValue(array, Math::max, Double.NaN);
        this.sum = determineValue(array, (a, b) -> a + b, 0.0);
        this.count = (double) array.length;
        this.average = this.sum / this.count;
    }

    public final double determineValue(double[] array, DoubleBinaryOperator operate, double emptyCaseValue) {
        if (array.length == 0) {
            return emptyCaseValue;
        }

        return Arrays.stream(array).reduce(operate).getAsDouble();
    }
}
