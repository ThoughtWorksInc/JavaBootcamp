import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import bootcamp.process.HistogramProcessor;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HistogramProcessorTests {

    byte[] bytes = "one two two three three three four four four four".getBytes();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @Test
    public void getListOfAllWords() throws IOException {
        WordReader reader = new WordReaderImpl();
        HistogramWriter writer = new HistogramWriterImpl();
        HistogramProcessor processor = new HistogramProcessor(inputStream, outputStream);
        String list = "four : 4" + "\n" + "one : 1" +"\n" + "two : 2" + "\n" + "three : 3" + "\n";


        assertEquals(list, processor.process(reader, writer).getValue().get());
    }
}
