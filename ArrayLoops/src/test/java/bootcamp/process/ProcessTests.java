package bootcamp.process;

import bootcamp.data.Processor;
import bootcamp.data.Summary;
import org.junit.Before;
import org.junit.Test;

import java.util.OptionalDouble;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProcessTests {

    private double[] _numArray;
    private Processor _processor;



    @Test
    public void testGetSummary() {
        _numArray = new double[]{
                2, 3, 5, 6
        };
        _processor = new Processor(_numArray);
        Summary testSummary = _processor.process();
        assertThat(testSummary.getMin(), is(2.0));
        assertThat(testSummary.getMax(), is(6.0));
        assertThat(testSummary.getCount(), is(4.0));
        assertThat(testSummary.getAverage(), is(4.0));
        assertThat(testSummary.getSum(), is(16.0));
    }

    @Test
    public void testGetSummaryEmptyArray() {
        _numArray = new double[]{};
        _processor = new Processor(_numArray);
        Summary testSummary = _processor.process();
        assertThat(testSummary.getMin(), is(Double.NaN));
        assertThat(testSummary.getMax(), is(Double.NaN));
        assertThat(testSummary.getCount(), is(Double.NaN));
        assertThat(testSummary.getAverage(), is(Double.NaN));
        assertThat(testSummary.getSum(), is(Double.NaN));
    }

    @Test
    public void testGetValue() {
        _numArray = new double[]{
                2, 3, 5, 6
        };
        _processor = new Processor(_numArray);
        Double val =_processor.getValue(0).getAsDouble();
        assertThat(val, is(2.0));
    }

    @Test
    public void testGetValueOutOfArrayBounds() {
        _numArray = new double[]{};
        _processor = new Processor(_numArray);
        OptionalDouble val = _processor.getValue(0);
        assertThat(val, is(OptionalDouble.empty()));
    }
}
