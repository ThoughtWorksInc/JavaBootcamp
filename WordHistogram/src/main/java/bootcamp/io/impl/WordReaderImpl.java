package bootcamp.io.impl;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class WordReaderImpl implements WordReader {
    @Override
    public Result<List<String>> getWords(InputStream inStream) {
        List<String> output;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inStream))) {
            output = Arrays.asList(br.readLine().replaceAll("\\p{P}", "").toLowerCase().split("\\s+"));
            return new Result(output);
        } catch (IOException e) {
            return new Result(Status.IO_ERROR, e.getMessage());
        }
    }
}
