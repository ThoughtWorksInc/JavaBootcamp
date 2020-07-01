package bootcamp.io;

import bootcamp.data.Result;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class HistogramWriterTest {

    @Test
    void shouldCorrectlyWriteAMapOfOneWordAndIntegerToAnOutputStream() {
        Map<String, Integer> histogram = Collections.singletonMap("histogram", 5);
        String expectedHistogram = histogram.toString();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);
        histogramWriter.writeHistogram(histogram);
        String actualHistogram = histogramWriter.getOutStream().toString();
        assertEquals(expectedHistogram, actualHistogram);
    }

    @Test
    void shouldCorrectlyWriteAMapOfWordsAndIntegersToAnOutputStream() {
        Map<String, Integer> histogram = new HashMap<>();
        histogram.put("histogram", 5);
        histogram.put("success", 1);
        histogram.put("map", 7);
        String expectedHistogram = histogram.toString();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);
        histogramWriter.writeHistogram(histogram);
        String actualHistogram = histogramWriter.getOutStream().toString();
        assertEquals(expectedHistogram, actualHistogram);
    }

    @Test
    void shouldReturnResultObjectWithEmptyValueAndSuccessStatusOnSuccessfulWriteOperation() {
        Map<String, Integer> histogram = Collections.singletonMap("histogram", 5);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);
        Result<?> actualResult = histogramWriter.writeHistogram(histogram);
        Result<?> expectedResult = new Result();
        assertEquals(expectedResult, actualResult);
    }
}