package bootcamp.io.impl;

import bootcamp.data.Result;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordReaderImplTests {
    @Test
    public void testGetWordsSuccess() throws IOException {
        WordReaderImpl wordReader = new WordReaderImpl();
        InputStream inputStream = new ByteArrayInputStream("the dog is the best dog".getBytes());
        Result<List<String>> words = wordReader.getWords(inputStream);
        List<String> expectedWordList = List.of("the", "dog", "is", "the", "best", "dog");
        assertEquals(new Result(expectedWordList).getValue(), words.getValue());
    }
}