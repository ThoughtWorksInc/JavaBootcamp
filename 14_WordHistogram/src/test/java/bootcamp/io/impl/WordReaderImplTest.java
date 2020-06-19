package bootcamp.io.impl;

import bootcamp.data.Result;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class WordReaderImplTest {

    @Test
    public void getWordsReturnsInputStreamAsList() {
        String inputText = "This is a test";
        List<String> expected = Arrays.asList("This", "is", "a", "test");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        WordReaderImpl wordReader = new WordReaderImpl(inputStream);
        var actual = wordReader.getWords().getValue();
        assertEquals(Optional.of(expected), actual);
    }
}