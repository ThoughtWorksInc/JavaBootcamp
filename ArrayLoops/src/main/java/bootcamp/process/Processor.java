package bootcamp.process;

import bootcamp.data.Summary;

public class Processor {
    private final double[] array;

    Processor(double[] array) {
        this.array = array;
    }

    public Summary process() {
        if (array.length == 0) {
            return new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN);
        }

        return new Summary(findMin(), findMax(), calculateSum(), getCount(), calculateAvg());
    }

    public Double getValue(int index) {
        try {
            return array[index];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
            return Double.NaN;
        }
    }

    private Double findMin() {
        Double minValue = array[0];
        for (double val : array) {
            if(val < minValue){
                minValue = val;
            }
        }
        return minValue;
    }

    private Double findMax() {
        Double maxValue = array[0];
        for (double val : array) {
            if(val > maxValue){
                maxValue = val;
            }
        }
        return maxValue;
    }

    private Double calculateSum() {
        Double sum = 0.0;
        for (double val : array) {
            sum += val;
        }
        return sum;
    }

    private Double getCount() {
        return new Double(array.length);
    }

    private Double calculateAvg() {
        return calculateSum() / getCount();
    }
}
