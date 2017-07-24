package start.pibednar.walker.interfaces.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import start.pibednar.walker.interfaces.IFile;
import start.pibednar.walker.interfaces.IFileFactory;

public class FileFactoryImplementation implements IFileFactory {
  
  File file;

  @Override
  public IFile createFile(String path) throws FileNotFoundException {
    return new IFileImplementation(file);
  }

}
