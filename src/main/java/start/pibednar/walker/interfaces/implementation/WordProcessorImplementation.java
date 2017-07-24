package start.pibednar.walker.interfaces.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import start.pibednar.walker.interfaces.IFile;
import start.pibednar.walker.interfaces.Processor;
import start.pibednar.walker.interfaces.ProcessorFilter;
import start.pibednar.walker.interfaces.ProcessorResult;

/**
 * Created by angularjs on 20.07.17.
 */
@Service
public class WordProcessorImplementation implements Processor {

  private static final Logger LOG = LoggerFactory.getLogger(WordProcessorImplementation.class);

  ProcessorFilter filter;
  private long wordCounter;

  @Override
  public ProcessorResult process(IFile file) {
    try {

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.openInputStream()));
      bufferedReader.lines().forEach(line -> wordCounter=+ line.split(" ").length);
      System.out.println("Liczba słów: " + wordCounter +" Ścieżka: "+ file.getAbsolutePath());
      LOG.info("Liczba słów: " + wordCounter +" Ścieżka: "+ file.getAbsolutePath());
    }
    catch (IOException ex) {
      LOG.error(ex.getMessage());
    }
    return new ProcessorResultImplementation<>();
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void setFilter(ProcessorFilter filter) {
      this.filter=filter;
  }
}
