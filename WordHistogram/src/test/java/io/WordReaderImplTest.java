package io;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.impl.WordReaderImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordReaderImplTest {

    private String textInput = "Hello world this is a test. I am running a test";
    private List<String> expectedList = Arrays.asList("hello", "world", "this", "is", "a", "test", "i", "am", "running", "a", "test");
    private WordReaderImpl testReaderImpl;
    private ByteArrayInputStream testInput;

    @Before
    public void setUp() {
        testInput = new ByteArrayInputStream(textInput.getBytes());
        testReaderImpl = new WordReaderImpl();
    }

    @Test
    public void reader_returns_result_containing_list_of_input_words() {
        Result<List<String>> result = testReaderImpl.getWords(testInput);
        assertThat(result.getStatus(), is(Status.SUCCESS));
        assertThat(result.getValue().get(), is(expectedList));
    }
}
