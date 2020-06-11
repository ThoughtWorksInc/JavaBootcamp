package bootcamp.data;

public class Processor {
    private final Double[] array;

    public Processor(Double[] array) {
        this.array = array;
    }

    public Summary process(){
        if(array != null && array[0] != null){
            double min = array[0];
            double max = array[0];
            double sum = 0;
            double count = array.length;
            for(double d :array) {
                min = (d < min) ? d : min;
                max = (d > max) ? d : max;
                sum += d;
            }
            double average = sum/count;
            return new Summary(min, max, sum, count, average);
        } else {
            return new Summary(Double.NaN, Double.NaN, 0, 0, Double.NaN);
        }
    }

    public double getValue(int idx){
        if(idx >= array.length){
            return Double.NaN;
        }
        return array[idx];
    }
}
