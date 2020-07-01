package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class HistogramProcessorTest {

    @Test
    void shouldReturnResultObjectWithSuccessStatusAndEmptyValueGivenValidInput() {
        String words = "hi hello hi hi hello greetings";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(words.getBytes());
        WordReader wordReader = new WordReaderImpl(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HistogramWriter histogramWriter = new HistogramWriterImpl(byteArrayOutputStream);

        HistogramProcessor histogramProcessor = new HistogramProcessor();
        Result<?> actualResult = histogramProcessor.process(wordReader, histogramWriter);
        Result expectedResult = new Result();
        assertEquals(expectedResult, actualResult);
    }
}