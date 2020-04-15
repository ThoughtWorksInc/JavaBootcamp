package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.impl.HistogramWriterImpl;
import bootcamp.io.impl.WordReaderImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HistogramProcessorTests {
    @Test
    public void testProcessSuccess() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("the dog is the best dog in the world".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        HistogramProcessor histogramProcessor = new HistogramProcessor(inputStream, outputStream);
        Result<?> result = histogramProcessor.process(new WordReaderImpl(), new HistogramWriterImpl());
        assertThat(outputStream.toString(), allOf(
                containsString("the:3"), containsString("dog:2"), containsString("best:1"),
                containsString("in:1"), containsString("is:1"), containsString("world:1")));
        assertEquals(new Result().getStatus(), result.getStatus());
    }
}
