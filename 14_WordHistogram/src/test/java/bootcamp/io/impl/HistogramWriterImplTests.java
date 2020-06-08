package bootcamp.io.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import bootcamp.data.Status;

public class HistogramWriterImplTests {
    @Test
    public void canWriteHistogramToAStream() {
        final Map<String, Integer> inputHistogram = new HashMap<>();
        inputHistogram.put("twinkle", 2);
        inputHistogram.put("star", 1);
        inputHistogram.put("little", 1);
        final var testOutputStream = new ByteArrayOutputStream();

        final var histogramWriter = new HistogramWriterImpl();
        final var result = histogramWriter.writeHistogram(inputHistogram, testOutputStream);

        final var writtenText = new String(testOutputStream.toByteArray());
        final var expectedJson = "{twinkle=2, star=1, little=1}";
        assertThat(writtenText, is(expectedJson));
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.message, is(""));
    }

    @Test
    public void encapsulatesIoException() throws IOException {
        final Map<String, Integer> inputHistogram = new HashMap<>();
        final var testOutputStream = mock(OutputStream.class);
        doThrow(new IOException("👹👹👹")).when(testOutputStream).write(any(byte[].class), anyInt(), anyInt());

        final var histogramWriter = new HistogramWriterImpl();
        final var result = histogramWriter.writeHistogram(inputHistogram, testOutputStream);

        assertThat(result.status, is(Status.IO_ERROR));
        assertTrue(result.value.isEmpty());
        assertThat(result.message, is("👹👹👹"));
    }
}