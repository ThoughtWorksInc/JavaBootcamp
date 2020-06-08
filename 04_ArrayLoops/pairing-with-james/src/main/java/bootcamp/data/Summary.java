package bootcamp.data;

import java.util.Arrays;

public class Summary {

    private final double min;
    private final double max;
    private final double sum;
    private final double count;
    private final double average;

    public Summary(double[] array) {
        this.min = findMin(array);
        this.max = findMax(array);
        this.sum = findSum(array);
        this.count = findCount(array);
        this.average = findAverage(array);

    }

    public double findMin(double[] array) {
        if (array.length == 0) {
            return Double.NaN;
        }
        return Arrays.stream(array).reduce((a, b) -> Math.min(a, b)).getAsDouble();
    }

    public double findMax(double[] array) {
        if (array.length == 0) {
            return Double.NaN;
        }
        return Arrays.stream(array).reduce((a, b) -> Math.max(a, b)).getAsDouble();
    }

    public double findSum(double[] array) {
        if (array.length == 0) {
            return 0;
        }
        return Arrays.stream(array).reduce((a, b) -> a + b).getAsDouble();
    }

    public double findCount(double[] array) {
        return array.length;
    }

    public double findAverage(double[] array) {
        if (array.length == 0) {
            return Double.NaN;
        }
        return this.sum/this.count;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getSum() {
        return sum;
    }

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }
}
