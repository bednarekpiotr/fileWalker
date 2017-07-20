package start.pibednar.walker.interfaces;

public interface ProcessorFilter<T> {

  public boolean filter(ProcessorResult<T> result);
}
