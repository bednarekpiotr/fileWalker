package start.pibednar.walker.interfaces.implementation;


import org.springframework.stereotype.Service;
import start.pibednar.walker.interfaces.Filter;
import start.pibednar.walker.interfaces.IFile;

@Service
public class FilterExtensionImplementation implements Filter {

  public void setExtension(String extension) {
    this.extension = extension;

  }

  public String getExtension() {
    return extension;
  }

  private String extension="";

  @Override
  public boolean filter(IFile file) {

      return file.getName().endsWith(extension);


  }

}
