package start.pibednar.walker.interfaces.implementation;

/**
 * Created by angularjs on 20.07.17.
 */


  import com.beust.jcommander.Parameter;

  public class Args {


    @Parameter(names = {"-ex", "--extension"}, description = "Extension")
    private String extension;
    private boolean boolExtension = false;


    @Parameter(names = {"-p", "--path"}, description = "Path")
    private String path;
    private boolean boolPath = false;

    @Parameter(names = {"--count-words", "-wc"}, description = "Words count processor")
    private boolean wordsCount = false;

    @Parameter(names = {"--count-lines", "-lc"}, description = "Lines count processor")
    private boolean linesCount = false;

    @Parameter(names = {"--size", "-s"}, description = "Size filter")
    private int size;
    private boolean boolSize=false;

    public int getSize() {
      return size;
    }

    public String getPath() {
      return path;
    }

    public boolean isWordsCount() {
      return wordsCount;
    }

    public boolean isLinesCount() {
      return linesCount;
    }

    public String getExtension() {
      return extension;
    }

    public boolean isExtension() {
      return boolExtension;
    }

    public boolean isPath() {
      return boolPath;
    }

  }


