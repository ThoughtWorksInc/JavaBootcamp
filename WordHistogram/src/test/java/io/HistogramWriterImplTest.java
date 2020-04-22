package io;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.impl.HistogramWriterImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HistogramWriterImplTest {

    private HistogramWriterImpl histogramWriter;
    private ByteArrayOutputStream testOutput;
    private HashMap<String, Integer> testMap;

    @Before
    public void setUp() {

        testOutput = new ByteArrayOutputStream();
        testMap = new HashMap<String, Integer>() {{
            put("hello", 1);
            put("test", 2);
        }};

        histogramWriter = new HistogramWriterImpl();
    }

    @Test
    public void histogramWriter_writeHistogram_outputs_map_written_to_file() {
        Result result = histogramWriter.writeHistogram(testMap, testOutput);
        assertThat(testOutput.toString(), is(testMap.toString()));
        assertThat(result.getStatus(), is(Status.SUCCESS));
    }
}
