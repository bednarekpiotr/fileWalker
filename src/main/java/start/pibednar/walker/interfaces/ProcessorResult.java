package start.pibednar.walker.interfaces;

public interface ProcessorResult<T> {
  
  public IFile getFile();
  public String getProcessorName();
  public Class<? extends Processor<T>> getProcessorClass();
  public T getResult();   
}
