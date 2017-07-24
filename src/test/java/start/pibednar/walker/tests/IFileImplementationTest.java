package start.pibednar.walker.tests;

import java.io.File;

import junit.framework.TestCase;

public class IFileImplementationTest extends TestCase {
  
  File file = new File("/home/cos/cos");

  public void testGetAbsolutePath() {
    assertTrue("Succeded" , file.getAbsolutePath().equals("/home/cos/cos"));
  }

  public void testGetName() {
    
  }

  public void testIsDirectory() {
    
  }

}
