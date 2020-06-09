package bootcamp.data;

public class Summary {
    private double min = Double.NaN;
    private double max = Double.NaN;
    private double sum = Double.NaN;
    private double count = Double.NaN;
    private double average = Double.NaN;

    public Summary(
            final double min,
            final double max,
            final double sum,
            final double count,
            final double average)
    {
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

    public double getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }
}
