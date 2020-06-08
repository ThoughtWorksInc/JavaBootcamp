package bootcamp.io.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import bootcamp.data.Status;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class WordReaderImplTests {
    private InputStream testInputStream;

    @AfterEach
    public void closeInputStream() {
        try {
            testInputStream.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    @Test
    public void canGetWords() {
        final var originalString = "Mary had a little lamb.";
        testInputStream = new ByteArrayInputStream(originalString.getBytes());

        final var wordReaderImpl = new WordReaderImpl();
        final var result = wordReaderImpl.getWords(testInputStream);

        final var expectedList = Arrays.asList("mary", "had", "a", "little", "lamb");
        assertEquals(expectedList, result.value.get());
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.message, is(""));
    }

    @Test
    public void handlesWhiteSpace() {
        final var originalString = "Mary\thad\r\na           little\t\t\t\t\nlamb.  ";
        testInputStream = new ByteArrayInputStream(originalString.getBytes());

        final var wordReaderImpl = new WordReaderImpl();
        final var result = wordReaderImpl.getWords(testInputStream);

        final var expectedList = Arrays.asList("mary", "had", "a", "little", "lamb");
        assertEquals(expectedList, result.value.get());
        assertThat(result.status, is(Status.SUCCESS));
        assertThat(result.message, is(""));
    }

    @Test
    public void encapsulatesIoException() throws IOException {
        testInputStream = mock(InputStream.class);
        when(testInputStream.read(any(byte[].class), anyInt(), anyInt())).thenThrow(new IOException("👹👹👹"));

        final var wordReaderImpl = new WordReaderImpl();
        final var result = wordReaderImpl.getWords(testInputStream);

        assertThat(result.status, is(Status.IO_ERROR));
        assertTrue(result.value.isEmpty());
        assertThat(result.message, is("👹👹👹"));
    }
}