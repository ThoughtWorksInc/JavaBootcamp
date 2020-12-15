package bootcamp.app;

import bootcamp.data.Result;
import bootcamp.io.impl.HistogramFileWriter;
import bootcamp.io.impl.WordFileReader;
import bootcamp.process.HistogramProcessor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HistogramApp {
    public static void main(final String[] args) {
        if (args.length == 2) {
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            try (WordFileReader reader = new WordFileReader(new FileInputStream(inputFile));
                 HistogramFileWriter writer = new HistogramFileWriter(new FileOutputStream(outputFile))) {
                HistogramProcessor processor = new HistogramProcessor();
                Result<?> result = processor.process(reader, writer);
                System.out.println(result);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
