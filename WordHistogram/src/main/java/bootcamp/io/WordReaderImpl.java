package bootcamp.io;

import bootcamp.data.Result;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordReaderImpl implements WordReader {


    @Override
    public Result<List<String>> getWords(InputStream inStream) throws IOException {
        int nextChar = inStream.read();
        ArrayList<String> words = new ArrayList<String>();
        String currentWord = "";

        while (nextChar != -1) {
            if((char) nextChar == ' ') {
                if (currentWord.length() > 0) {
                    words.add(currentWord);
                    currentWord = "";
                }
            }
            else {
                currentWord += (char) nextChar;
            }
            nextChar = inStream.read();
        }
        words.add(currentWord);
        Result<List<String>> result = new Result<List<String>>(Optional.of(words));
        return result;
    }

}
