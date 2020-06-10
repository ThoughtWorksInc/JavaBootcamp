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

    public boolean equals(Object o){

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        var summary = (Summary) o;

        return (
                this.average == summary.average &&
                this.sum == summary.sum &&
                this.count == summary.count &&
                this.min == summary.min &&
                this.max == summary.max);
    }
}
