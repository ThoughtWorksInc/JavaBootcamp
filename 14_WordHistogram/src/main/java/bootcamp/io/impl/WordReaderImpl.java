package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

import java.io.InputStream;
import java.util.*;

import static java.util.Arrays.asList;

public class WordReaderImpl extends WordReader {
    public WordReaderImpl(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() {
        try (Scanner scanner = new Scanner(inStream).useDelimiter("\\A")) {
            String string = scanner.hasNext() ? scanner.next() : "";
            List<String> result = asList(string.split("\\s+"));
            return new Result<List<String>>(Optional.of(result));
        } catch (Exception ex) {
            return new Result<List<String>>(Status.IO_ERROR, ex.getMessage());
        }


    }
}

