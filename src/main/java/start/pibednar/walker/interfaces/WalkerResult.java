package start.pibednar.walker.interfaces;

import java.util.List;

public interface WalkerResult {
  List<IFile> getFilteredFiles();
  List<IFile> getProcessedFiles();
  List<ProcessorResult<?>> getProcessorsResults();
  List<ProcessorResult<?>> getProcessorsResults(String filename);
  <T> ProcessorResult<T> getProcessorResult(String filename, String processorName);
}

