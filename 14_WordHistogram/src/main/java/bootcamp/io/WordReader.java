package bootcamp.io;

import bootcamp.data.Result;

import java.io.InputStream;
import java.util.List;

public abstract class WordReader {
    public final InputStream inStream;

    public WordReader(final InputStream inStream) {
        this.inStream = inStream;
    }

    public abstract Result<List<String>> getWords();
}
