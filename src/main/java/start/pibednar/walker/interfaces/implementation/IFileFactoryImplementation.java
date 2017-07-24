package start.pibednar.walker.interfaces.implementation;

import java.io.File;
import java.io.FileNotFoundException;

import start.pibednar.walker.interfaces.IFile;
import start.pibednar.walker.interfaces.IFileFactory;

public class IFileFactoryImplementation implements IFileFactory {

  @Override
  public IFile createFile(String path) throws FileNotFoundException {
    return new IFileImplementation(new File(path));
  }

}
