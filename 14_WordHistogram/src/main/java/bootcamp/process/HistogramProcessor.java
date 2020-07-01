package bootcamp.process;

import bootcamp.data.Result;
import bootcamp.data.Status;
import bootcamp.io.HistogramWriter;
import bootcamp.io.WordReader;

import java.util.List;
import java.util.Map;

public class HistogramProcessor {
    final HistogramCalculator calculator = new HistogramCalculator();

    public Result<?> process(final WordReader reader, final HistogramWriter writer) {
        Result<List<String>> readerResult = reader.getWords();
        if(readerResult.getStatus() == Status.IO_ERROR){
            return readerResult;
        } else {
            List<String> listOfWords = readerResult.getValue().get();
            Map<String, Integer> histogram = calculator.calculate(listOfWords);
            Result<?> writerResult = writer.writeHistogram(histogram);
            return writerResult;
        }
    }
}
