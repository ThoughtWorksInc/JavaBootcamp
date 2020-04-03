package bootcamp.process;

import bootcamp.data.Summary;

import static java.lang.Double.NaN;

public class Processor {

    private double[] arr;

    Processor(double[] arr){
        this.arr = arr;
    }

    public Summary process() {

        if(arr.length == 0){
            return new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN);
        }

        double min = arr[0];
        double max = arr[0];
        double sum = arr[0];
        int count = arr.length;

        for(int i = 1; i<count; i++){
            sum = sum + arr[i];
            if(arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }


        double average = sum / count;
        return new Summary(min, max, sum, count, average);
    }

    public double getValue(int i){
        return arr[i];
    }
}
