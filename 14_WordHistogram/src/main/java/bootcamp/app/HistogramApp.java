package bootcamp.app;

import bootcamp.data.Result;
import bootcamp.io.HistogramWriter;
import bootcamp.io.HistogramWriterImpl;
import bootcamp.io.WordReader;
import bootcamp.io.WordReaderImpl;
import bootcamp.process.HistogramProcessor;

import java.io.*;

public class HistogramApp {
    public static void main(final String[] args) {
        try {
            InputStream fileInputStream = new FileInputStream(args[0]);
            OutputStream fileOutputStream = new FileOutputStream(args[1]);
            WordReader wordReader = new WordReaderImpl(fileInputStream);
            HistogramWriter histogramWriter = new HistogramWriterImpl(fileOutputStream);
            HistogramProcessor histogramProcessor = new HistogramProcessor();
            Result<?> result = histogramProcessor.process(wordReader, histogramWriter);
            System.out.println(result.getStatus());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
