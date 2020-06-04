package bootcamp.processor;

import bootcamp.data.Summary;

public class Processor {
    double[] values;

    public Processor(double[] values) {
        this.values = values;
    }

    private double getMinValue(double[] numbers) {
        double min = numbers[0];

        if (numbers.length == 1)
            return min;

//        if (numbers.length == 0)

//        first initialise the counter to 0
//        then set the conditions under which the for loop will run
//        then increase the counter
//        then add body of loop
//        function run, counter increased, checks the boolean
//        if the number at the index of the counter is less than the min,
//        set it to the value of the min
//        Then counter increases...
//        Once loop runs, min will be the smallest number
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    private double getMaxValue(double[] numbers) {
        double max = numbers[0];

        if (numbers.length == 1)
            return max;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private double getSum(double[] numbers) {
        double sum = numbers[0];

        if (numbers.length == 1)
            return sum;

        for (int i = 1; i < numbers.length; i++) {
            sum = numbers[i] + sum;
        }

        return sum;
    }

    private double getAverage(double[] numbers) {
        double average = numbers[0];

        if (numbers.length == 1)
            return average;

        return average = getSum(numbers) / numbers.length;
    }

    public Summary process() {

        if (values.length == 0) {
            return new Summary(Double.NaN, Double.NaN, Double.NaN, 0d, 0d);
        }

        double min = getMinValue(values);
        double max = getMaxValue(values);
        double sum = getSum(values);
        double count = values.length;
        double average = getAverage(values);
        return new Summary(min, max, sum, count, average);
    }

    public double getValue(int index) {
//        add bounds checking first to see if index is out of bounds
        if (index > values.length)
            System.out.println("Please enter a valid index");
s
        return values[index];
    }
}

//Ask about extension ex