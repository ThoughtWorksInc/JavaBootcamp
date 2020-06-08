package bootcamp.io.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.WordReader;

public class WordReaderImpl implements WordReader {
    public final Set<String> blackListedChars = Set.of(".", ",", "?", "!", "\"", ";", ":");

    public Result<List<String>> getWords(final InputStream inputStream) {
        final var textBuilder = new StringBuilder();

        try {
            final var utf8Stream = new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name()));
            final var bufferedStringStream = new BufferedReader(utf8Stream);

            int lastStreamChar = 0;
            while (lastStreamChar != -1) {
                lastStreamChar = bufferedStringStream.read();
                if (lastStreamChar != -1 && !blackListedChars.contains(String.valueOf((char) lastStreamChar))) {
                    textBuilder.append((char) lastStreamChar);
                }
            }

            final var wordList = Arrays.asList(textBuilder.toString().split("\\s+")).stream().map(String::toLowerCase)
                    .collect(Collectors.toList());
            return new Result<>(wordList);
        } catch (IOException ioException) {
            return new Result<>(Status.IO_ERROR, ioException.getMessage());
        }
    }

}
