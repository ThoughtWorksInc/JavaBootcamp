package bootcamp.data;

public class Processor {

    private double value;
    private double[] arr;

    public Summary process() {
        Summary summary = new Summary();

        for (int i=0; i < arr.length; i++) {
            double num = getValue(i);

            if (i==0){
                summary.setMin(num);
                summary.setMax(num);
            }

            if (num < summary.getMin()) {
                summary.setMin(num);
            }
            if (num > summary.getMax()) {
                summary.setMax(num);
            }
            summary.setSum(summary.getSum() + num);
            summary.setCount(summary.getCount() + 1);
        }
        summary.setAverage(summary.getSum()/ summary.getCount());

        return summary;

    }

    public Processor(double[] arr) {
        this.arr = arr;
    }

    public double getValue(int i) {
        if (i < 0 || i >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("Array value does not exist");
        }
        else{
            value = arr[i];
            return value;
        }
    }

}
