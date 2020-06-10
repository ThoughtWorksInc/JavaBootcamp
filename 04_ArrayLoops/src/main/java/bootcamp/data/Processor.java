package bootcamp.data;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Processor {
    private final double[] array;

    public Processor(double[] array) {
        this.array = array;
    }

    public Summary process(){

        if (array.length == 0) return new Summary(Double.NaN, Double.NaN, Double.NaN, 0, Double.NaN);

        double min = Arrays.stream(array).min().getAsDouble();
        double max = Arrays.stream(array).max().getAsDouble();
        double sum = Arrays.stream(array).sum();
        int count = array.length;
        double average = Arrays.stream(array).average().getAsDouble();

        return new Summary(min, max, sum, count, average);
    }

    public double getValue(int i) {
        try {
            return array[i];
        } catch(ArrayIndexOutOfBoundsException e){
            // add line for logger.log or System.out.prinLn("blah");
            return Double.NaN;
        }

    }
}
