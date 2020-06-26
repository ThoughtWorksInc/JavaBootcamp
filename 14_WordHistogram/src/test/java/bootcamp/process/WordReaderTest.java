package bootcamp.process;

import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordReaderTest {

    @Test
    void shouldCorrectlyCreateAListOfWordsFromAnInputStream() {
        String words = "hi, hello, hi, hi, hello, greetings";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(words.getBytes());

        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("hi");
        expectedWords.add("hello");
        expectedWords.add("hi");
        expectedWords.add("hi");
        expectedWords.add("hello");
        expectedWords.add("greetings");
        WordReader wordReader = new WordReaderImpl(byteArrayInputStream);
        List<String>actualResult = wordReader.getWords().getValue().get();

        assertEquals(expectedWords, actualResult);
    }
}
