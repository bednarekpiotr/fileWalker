package start.pibednar.walker.interfaces.implementation;

import start.pibednar.walker.interfaces.IFile;
import start.pibednar.walker.interfaces.ProcessorResult;
import start.pibednar.walker.interfaces.WalkerResult;

import java.util.List;

public class WalkerResultImplementation implements WalkerResult {
  
  List<IFile> processedFiles;
  List<IFile> filteredFiles;
  List<ProcessorResult<?>> processorResults;

  @Override
  public List<IFile> getFilteredFiles() {
    return filteredFiles;
  }

  @Override
  public List<IFile> getProcessedFiles() {
   return processedFiles;
    }

  @Override
  public List<ProcessorResult<?>> getProcessorsResults() {
    return processorResults;
  }

  @Override
  public List<ProcessorResult<?>> getProcessorsResults(String filename) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> ProcessorResult<T> getProcessorResult(String filename, String processorName) {
    // TODO Auto-generated method stub
    return null;
  }

}
