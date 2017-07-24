package start.pibednar.walker.interfaces;

public interface Processor<T> {
  
  public ProcessorResult<T> process(IFile file);
  public String getName();
  public void setFilter(ProcessorFilter<T> filter);
  

}
