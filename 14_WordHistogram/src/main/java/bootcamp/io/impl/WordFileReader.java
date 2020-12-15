package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.io.WordReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordFileReader {

    public WordFileReader(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() throws IOException {
        List<String> words = new ArrayList<>();
        InputStreamReader inputStreamReader = new InputStreamReader(this.inStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = reader.readLine()) != null) {
            words.add(line.trim());
        }
        return new Result<>(java.util.Optional.of(words));
    }
}
