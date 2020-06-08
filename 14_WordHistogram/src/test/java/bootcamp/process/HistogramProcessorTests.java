package bootcamp.process;

import org.junit.jupiter.api.Test;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramProcessorTests {
    @Test
    public void canDoHistogramProcessing() {
        final var mockWordReader = mock(WordReader.class);
        final List<String> wordList = new ArrayList<>();
        final Map<String, Integer> histogram = new HashMap<>();
        final var mockInputStream = mock(InputStream.class);
        final var mockOutputStream = mock(OutputStream.class);
        final var mockHistogramWriter = mock(HistogramWriter.class);

        when(mockWordReader.getWords(mockInputStream)).thenReturn(new Result<>(wordList));
        when(mockHistogramWriter.writeHistogram(histogram, mockOutputStream)).thenReturn(new Result<>());

        final var histogramProcessor = new HistogramProcessor(mockWordReader, mockHistogramWriter);
        final var processingResult = histogramProcessor.process(mockInputStream, mockOutputStream);

        assertThat(processingResult.status, is(Status.SUCCESS));
        assertThat(processingResult.message, is(""));
        assertTrue(processingResult.value.isEmpty());
    }

    @Test
    public void returnsInformativeStatusWhenReadingFails() {
        final var mockWordReader = mock(WordReader.class);
        final var mockInputStream = mock(InputStream.class);
        final var mockOutputStream = mock(OutputStream.class);
        final var mockHistogramWriter = mock(HistogramWriter.class);
        when(mockWordReader.getWords(mockInputStream)).thenReturn(new Result<>(Status.IO_ERROR, "👹"));

        final var histogramProcessor = new HistogramProcessor(mockWordReader, mockHistogramWriter);
        final var processingResult = histogramProcessor.process(mockInputStream, mockOutputStream);

        assertThat(processingResult.status, is(Status.READ_ERROR));
        assertThat(processingResult.message, is("👹"));
        assertTrue(processingResult.value.isEmpty());
    }

    @Test
    public void returnsInformativeStatusWhenWritingFails() {
        final var mockWordReader = mock(WordReader.class);
        final List<String> wordList = new ArrayList<>();
        final Map<String, Integer> histogram = new HashMap<>();
        final var mockInputStream = mock(InputStream.class);
        final var mockOutputStream = mock(OutputStream.class);
        final var mockHistogramWriter = mock(HistogramWriter.class);
        when(mockWordReader.getWords(mockInputStream)).thenReturn(new Result<>(wordList));
        when(mockHistogramWriter.writeHistogram(histogram, mockOutputStream))
                .thenReturn(new Result<>(Status.IO_ERROR, "👹"));

        final var histogramProcessor = new HistogramProcessor(mockWordReader, mockHistogramWriter);
        final var processingResult = histogramProcessor.process(mockInputStream, mockOutputStream);

        assertThat(processingResult.status, is(Status.WRITE_ERROR));
        assertThat(processingResult.message, is("👹"));
        assertTrue(processingResult.value.isEmpty());
    }
}