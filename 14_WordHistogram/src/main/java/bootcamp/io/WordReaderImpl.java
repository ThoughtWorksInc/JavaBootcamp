package bootcamp.io;

import bootcamp.data.Result;
import bootcamp.data.Status;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WordReaderImpl extends WordReader {

    public WordReaderImpl(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() {
        List<String> words = new ArrayList<>();
        try(Scanner sc = new Scanner(inStream).useDelimiter("\\s+[,;]]")){
            while(sc.hasNext()){
                words.add(sc.next());
            }
        }
        return new Result(Status.SUCCESS, Optional.of(words));
    }
}
