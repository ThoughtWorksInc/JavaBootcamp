package bootcamp.process;

import bootcamp.data.Summary;

public class Processor {

    private final double[] array;

    public Processor(final double[] array) {
        this.array = array;
    }

    public Summary process() {

        double count = array.length;
        double sum = 0;
        double min = Double.NaN;
        double max = Double.NaN;
        double average = Double.NaN;

        if (count > 0) {
            min = getMin();
            max = getMax();
            sum = getSum(sum);
            average = getAverage(count, sum);
        }

        return new Summary(min, max, sum, count, average);
    }

    private double getAverage(double count, double sum) {
        double average;
        average = sum /count;
        return average;
    }

    private double getSum(double sum) {
        for (double v : array) {
            sum += v;
        }
        return sum;
    }

    private double getMax() {
        double max;
        max = array[0];
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    private double getMin() {
        double min;
        min = array[0];
        for (double v : array) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public double getValue(int index) {
            return array[index];
    }



}
