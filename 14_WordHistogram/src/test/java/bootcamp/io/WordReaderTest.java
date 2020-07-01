package bootcamp.io;

import bootcamp.data.Result;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordReaderTest {

    @Test
    void shouldCorrectlyCreateAListOfWordsFromAnInputStreamSpaceDelimitedOnly() {
        String words = "hi hello hi hi hello greetings";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(words.getBytes());
        WordReader wordReader = new WordReaderImpl(byteArrayInputStream);
        List<String> actualResult = wordReader.getWords().getValue().get();

        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("hi");
        expectedWords.add("hello");
        expectedWords.add("hi");
        expectedWords.add("hi");
        expectedWords.add("hello");
        expectedWords.add("greetings");

        assertEquals(expectedWords, actualResult);
    }

    @Test
    void shouldReturnAResultObjectWithEmptyValueFromAnEmptyInputStream() {
        String words = "";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(words.getBytes());
        WordReader wordReader = new WordReaderImpl(byteArrayInputStream);
        Result<List<String>> actualResult = wordReader.getWords();
        Result<List<String>> expectedResult = new Result<>(Optional.of(new ArrayList<>()));
        assertEquals(expectedResult, actualResult);
    }
}
