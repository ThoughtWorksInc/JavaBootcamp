package bootcamp.processing;

import bootcamp.data.Summary;

import java.util.Arrays;
import java.util.Objects;

public class Processor {

    private final double[] floatingPoint;
    private Summary summary;

    public Processor(double[] floatingPoint) {
        this.floatingPoint = floatingPoint;
    }

    public Summary processing() {
        if (floatingPoint.length == 0) {
            return new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN);
        }
        Arrays.sort(floatingPoint);

        double min = floatingPoint[0];
        double max = floatingPoint[floatingPoint.length - 1];
        double sum = 0;

        for (double v : floatingPoint) {
            sum += v;
        }

        int count = floatingPoint.length;
        double average = sum / count;

        setSummary(new Summary(min,max,sum,count,average));
        return getSummary();
    }

    public double getValue(int index) {
        try{
            return floatingPoint[index];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please choose an index within the bounds of the array");
            return Double.NaN;
        }
    }

    public Summary getSummary(){
        return this.summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}