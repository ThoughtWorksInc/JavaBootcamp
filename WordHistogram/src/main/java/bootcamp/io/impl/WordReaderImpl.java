package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordReaderImpl implements WordReader {
    @Override
    public Result<List<String>> getWords(InputStream inStream) {
        List<String> output = new ArrayList<>();
        try {
            int bytes;
            while ((bytes = inStream.read()) != -1) {
                output.add(String.valueOf((char) bytes));
            }
            output = Arrays.asList(String.join("", output).replaceAll("\\p{P}", "").toLowerCase().split("\\s+"));
            return new Result(output);
        } catch (IOException e) {
            return new Result(Status.IO_ERROR, e.getMessage());
        }
    }
}
