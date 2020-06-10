package bootcamp.data;

import java.util.OptionalDouble;

public class Summary {
    private final double min;
    private final double max;
    private final double sum;
    private final int count;
    private final double average;

    public Summary(double min, double max, double sum, int count, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.count = count;
        this.average = average;
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

    public int getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }
}
