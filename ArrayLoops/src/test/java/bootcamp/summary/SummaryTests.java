package bootcamp.summary;
import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SummaryTests {

    public static double[] array = {1.2, 2.4, 8.6};
    public static Summary summary = new Summary(array);
    public static Summary emptyArraySummary = new Summary(new double[0]);

    @Test
    public void getMinimumValue() {
        assertThat(summary.getMin(), is(1.2));
    }
    @Test
    public void getMinimumValueFromEmptyArray() {
        assertThat(emptyArraySummary.getMin(), is(Double.NaN));
    }

    @Test
    public void getMaximumValue() {
        assertThat(summary.getMax(), is(8.6));
    }
    @Test
    public void getMaximumValueFromEmptyArray() {
        assertThat(emptyArraySummary.getMax(), is(Double.NaN));
    }

    @Test
    public void getSum() {
        assertThat(summary.getSum(), is(12.2));
    }
    @Test
    public void getSumFromEmptyArray() {
        assertThat(emptyArraySummary.getSum(), is(0.0));
    }

    @Test
    public void getCount() {
        assertThat(summary.getCount(), is(3.0));
    }
    @Test
    public void getCountFromEmptyArray() {
        assertThat(emptyArraySummary.getCount(), is(0.0));
    }

    @Test
    public void getAverage() {
        assertThat(summary.getAverage(), is(closeTo(4.06666666667, 0.00001)));
    }
    @Test
    public void getAverageFromEmptyArray() {
        assertThat(emptyArraySummary.getAverage(), is(Double.NaN));
    }



}
