package start.pibednar.walker.interfaces.implementation;

import start.pibednar.walker.interfaces.IFile;
import start.pibednar.walker.interfaces.Processor;
import start.pibednar.walker.interfaces.ProcessorResult;
import start.pibednar.walker.interfaces.WalkerResult;

public class ProcessorResultImplementation<T> implements ProcessorResult<T> {
  
  IFile ifile;
  LineProcessorImplementation<T> processor;
  WalkerResult walkerResult;

  @Override
  public IFile getFile() {
    return ifile;
  }

  @Override
  public String getProcessorName() {
    return processor.getName();
  }

  @Override
  public Class<? extends Processor<T>> getProcessorClass() {
    return (Class<? extends Processor<T>>) processor.getClass();
  }

  @Override
  public T getResult() {
    return (T) walkerResult;
  }


}
