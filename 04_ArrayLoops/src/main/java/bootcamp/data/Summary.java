package bootcamp.data;

public class Summary {
    private final double min;
    private final double max;
    private final double sum;
    private final double count;
    private final double average;

    public Summary(double min, double max, double sum, double count, double avg) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.count = count;
        this.average = avg;
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

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        // Not equal
        if (object == null || this.getClass() != object.getClass()) return false;
        // obj is null, this isn't; or they're different classes
        //After this line they must be the same class and the object can't be null, so it can be cast
        Summary summary = (Summary) object;
        return (this.min == summary.min || (Double.isNaN(this.min)) && Double.isNaN(summary.min))
                && (this.max == summary.max || (Double.isNaN(this.max)) && Double.isNaN(summary.max))
                && (this.sum == summary.sum || (Double.isNaN(this.sum)) && Double.isNaN(summary.sum))
                && (this.count == summary.count || (Double.isNaN(this.count)) && Double.isNaN(summary.count))
                && (this.average == summary.average || (Double.isNaN(this.average)) && Double.isNaN(summary.average));

    }
}
