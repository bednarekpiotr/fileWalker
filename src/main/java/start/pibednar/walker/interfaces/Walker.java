package start.pibednar.walker.interfaces;

import java.io.FileNotFoundException;

public interface Walker {

  public WalkerResult traverse(String directory) throws FileNotFoundException;
  public void setFilter(Filter filter);
  public void setProcessors(Processor<?>... processor);
}

