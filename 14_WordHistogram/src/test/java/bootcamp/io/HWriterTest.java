package bootcamp.io;

import bootcamp.data.Status;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HWriterTest {
    @Test
    public void writeHistogram_writesHistogramToStream() {
        Map<String, Integer> histogram = new HashMap<>();
        histogram.put("a", 2);

        var outStream = new ByteArrayOutputStream();

        var sut = new HWriter(outStream);

        var result = sut.writeHistogram(histogram);

        assertEquals(Status.Success, result.getStatus());
        assertEquals("a 2" ,outStream.toString());
        // Q for Gergo: How do I test what is written to stream?
    }
}