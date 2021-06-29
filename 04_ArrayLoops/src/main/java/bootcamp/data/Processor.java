package bootcamp.data;

public class Processor {
    double [] array;

    public Processor(double [] array) {
        this.array = array.clone();
    }
    public Summary process () {
        if (array.length == 0) return new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN);
        double min = array[0];
        double max = array[0];
        double sum = 0;
        double count = array.length;
        for (int i=0; i<array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
            sum += array[i];
        }
        double average = sum/count;
        return new Summary(min, max, sum, count, average);
    }

    public double getValue(int index) {
        if (index < array.length) return array[index];
            else throw new ArrayIndexOutOfBoundsException();
    }
}
