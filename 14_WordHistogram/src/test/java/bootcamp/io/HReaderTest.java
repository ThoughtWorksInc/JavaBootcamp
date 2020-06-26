package bootcamp.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HReaderTest {

    @Test
    public void getWords_GetsWords(){
        var content = "this is the content";
        var testStream = new ByteArrayInputStream(content.getBytes());
        var expected = new ArrayList<String>();
        expected.add("this");
        expected.add("is");
        expected.add("the");
        expected.add("content");

        var sut = new HReader(testStream);

        var result = sut.getWords();

        assertArrayEquals(expected.toArray(), result.getValue().get().toArray());
    }
}