package bootcamp.io.impl;

import bootcamp.data.Result;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HistogramWriterImplTests {
    @Test
    public void testWriteHistogram() throws IOException {
        HistogramWriterImpl histogramWriter = new HistogramWriterImpl();
        OutputStream outputStream = new ByteArrayOutputStream();

        Map<String, Integer> histoMap = new HashMap<>();
        histoMap.put("dog", 2);
        histoMap.put("the", 1);

        Result<?> result = histogramWriter.writeHistogram(histoMap, outputStream);
        assertThat(outputStream.toString(), allOf(containsString("dog:2"), containsString("the:1")));
        assertEquals(new Result().getValue(), result.getValue());
    }
}
