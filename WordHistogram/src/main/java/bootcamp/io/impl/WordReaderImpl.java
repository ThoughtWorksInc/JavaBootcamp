package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordReaderImpl implements WordReader {
    @Override
    public Result<List<String>> getWords(InputStream inStream) throws IOException {
        List<String> wordList = new ArrayList<>();
        try (
            Reader inputStreamReader = new InputStreamReader(inStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                for (String word : line.split(" ")) {
                    wordList.add(word);
                }
            }

            return new Result(Optional.ofNullable(wordList));
        } catch(IOException e) {
            return new Result(Status.IOError, e.getMessage());
        }
    }
}
