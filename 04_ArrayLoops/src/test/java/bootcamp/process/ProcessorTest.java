package bootcamp.process;

import bootcamp.data.Summary;
import org.junit.Test;
import process.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

public class ProcessorTest {

    @Test
    public void shouldGetSummaryWithCorrectValuesWhenProcessingValidArray() {
        ArrayList<Double> array = new ArrayList<>();
        array.add(3.3);
        array.add(4.5);
        array.add(42.6);
        array.add(1.1);

        Process process = new Process(array);
        Summary summary = process.process();

        assertEquals(summary.getSum(), 51.5, 1);
        assertEquals(summary.getAverage(), 12.9, 1);
        assertEquals(summary.getCount(), 4, 1);
        assertEquals(summary.getMax(), 42.6, 1);
        assertEquals(summary.getMin(), 1.1, 1);

    }

    @Test
    public void shouldGetDefaultSummaryWhenProcessingEmptyArray() {
        ArrayList<Double> array = new ArrayList<>();

        Process process = new Process(array);
        Summary summary = process.process();

        assertEquals(summary.getAverage(), Double.NaN, 1);
        assertEquals(summary.getMax(), Double.NaN, 1);
        assertEquals(summary.getMin(), Double.NaN, 1);
        assertEquals(summary.getSum(), 0, 1);
        assertEquals(summary.getCount(), 0, 1);

    }

    @Test
    public void shouldReturnValueAtGivenArrayIndex() {
        ArrayList<Double> array = new ArrayList<>();
        array.add(3.3);
        array.add(4.5);

        Process process = new Process(array);
        Optional<Double> result = process.getValue(0);

        assertTrue(result.isPresent());
        assertEquals(result.get(), 3.3, 1);
    }

    @Test
    public void shouldGetExceptionFromGetValueWhenIndexTooLarge() {

        ArrayList<Double> array = new ArrayList<>();
        array.add(3.3);
        array.add(4.5);

        Process process = new Process(array);
        Optional<Double> result = process.getValue(10);

        assertTrue(result.isEmpty());
    }
}
