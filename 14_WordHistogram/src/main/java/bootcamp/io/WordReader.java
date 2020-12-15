package bootcamp.io;

import bootcamp.data.Result;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class WordReader implements AutoCloseable{
    public final InputStream inStream;

    public WordReader(final InputStream inStream) {
        this.inStream = inStream;
    }

    public abstract Result<List<String>> getWords() throws IOException;

    @Override
    public void close() throws Exception {
        this.inStream.close();
    }
}
