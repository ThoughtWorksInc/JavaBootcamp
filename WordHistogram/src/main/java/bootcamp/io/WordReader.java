package bootcamp.io;

import bootcamp.data.Result;

import java.io.InputStream;
import java.util.List;

public interface WordReader {
    Result<List<String>> getWords(final InputStream inStream);
}
