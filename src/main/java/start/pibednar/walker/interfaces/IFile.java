package start.pibednar.walker.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IFile {
  
  /**
   * 
   * @return
   */
  public String getAbsolutePath();
  
  /**
   * 
   * @return
   */
  public String getName();
  
  /**
   * 
   * @return
   */
  public List<IFile> listFiles();
  
  /**
   * 
   * @return
   */
  public boolean isDirectory();
  
  /**
   * 
   * @return
   */
  public InputStream openInputStream() throws FileNotFoundException, IOException;

}
