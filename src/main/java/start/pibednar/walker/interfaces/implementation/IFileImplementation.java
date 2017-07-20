package start.pibednar.walker.interfaces.implementation;

import start.pibednar.walker.interfaces.IFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IFileImplementation implements IFile {

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  File file;
  
  public  IFileImplementation(File file) {
    this.file = file;
  }

  @Override
  public String getAbsolutePath() {
    return file.getAbsolutePath();
  }

  @Override
  public String getName() {
    return file.getName();
    
  }

  @Override
  public List<IFile> listFiles() {
    List<IFile> output = new ArrayList<IFile>();
    List<File> temp = Arrays.asList(file.listFiles());
    temp.forEach(a -> output.add(new IFileImplementation(a)));    
    return output;
  }

  @Override
  public boolean isDirectory() {
    return file.isDirectory();
  }

  @Override
  public InputStream openInputStream() throws FileNotFoundException, IOException {
  return new FileInputStream(file);
  }

}
