package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordReaderImpl implements WordReader {
    @Override
    public Result<List<String>> getWords(InputStream inStream) throws IOException {
        List<String> wordList = new ArrayList<String>();
        try (
            Reader inputStreamReader = new InputStreamReader(inStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordList.addAll(Arrays.asList(line.split(" ")));
            }

            return new Result(wordList);
        } catch(IOException e) {
            return new Result(Status.IOError, e.getMessage());
        }
    }
}
