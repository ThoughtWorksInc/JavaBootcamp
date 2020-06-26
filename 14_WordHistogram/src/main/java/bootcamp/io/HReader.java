package bootcamp.io;

import bootcamp.data.Result;
import java.io.InputStream;
import java.util.List;

public class HReader extends WordReader {

    public HReader(InputStream inStream) {
        super(inStream);
    }

    @Override
    public Result<List<String>> getWords() {

        return null;
    }
}
