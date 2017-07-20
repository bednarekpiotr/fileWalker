package start.pibednar.walker.interfaces;

import java.io.FileNotFoundException;

public interface IFileFactory {
  /**
   * 
   * @param path
   * @return
   * @throws FileNotFoundException
   */
  public IFile createFile(String path) throws FileNotFoundException;
}
