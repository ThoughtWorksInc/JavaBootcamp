package bootcamp.data;

public class Summary {

    private double min = Double.NaN;
    private double max = Double.NaN;
    private double sum = 0;
    private double count = 0;
    private double average = Double.NaN;

    public void setMin(double min) {
        this.min = min;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public void setAverage(double average) {
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

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }
}
