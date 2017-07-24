package start.pibednar.walker.interfaces.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import start.pibednar.walker.App;
import start.pibednar.walker.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class LineProcessorImplementation<T> implements Processor<T> {

    private static final Logger LOG = LoggerFactory.getLogger(LineProcessorImplementation.class);


  private Filter filter;
  private ProcessorFilter<T> processorFilter;
  private long lineCounter;

    /**
     * Metoda procesuje podany plik
     * Zlciza liczbę linii
     * @param file
     * @return
     */
  @Override
  public ProcessorResult<T> process(IFile file) {
    try {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.openInputStream()));
        lineCounter = bufferedReader.lines().count();
        System.out.println("Liczba linii: " + lineCounter +" Ścieżka: "+ file.getAbsolutePath());
        LOG.info("Liczba linii: " + lineCounter +" Ścieżka: "+ file.getAbsolutePath());
    }
    catch (IOException ex) {
        LOG.error(ex.getMessage());
    }
    return new ProcessorResultImplementation<>();
  }

  @Override
  public String getName() {
    return this.getName();
  }

  @Override
  public void setFilter(ProcessorFilter<T> filter) {
    processorFilter = filter;

  }

}
