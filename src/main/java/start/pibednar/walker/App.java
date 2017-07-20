package start.pibednar.walker;

import com.beust.jcommander.JCommander;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import start.pibednar.walker.interfaces.Filter;
import start.pibednar.walker.interfaces.implementation.Args;
import start.pibednar.walker.interfaces.implementation.FilterExtensionImplementation;
import start.pibednar.walker.interfaces.implementation.FilterSizeImplementation;
import start.pibednar.walker.interfaces.implementation.LineProcessorImplementation;
import start.pibednar.walker.interfaces.implementation.WalkerImplementation;
import start.pibednar.walker.interfaces.implementation.WordProcessorImplementation;

/**
 * Hello world!
 */
@ComponentScan(basePackages = "start.pibednar.walker")
public class App {

  private static final Logger LOG = LoggerFactory.getLogger(App.class);

  @Autowired
  WalkerImplementation walkerImplementation;

  @Autowired
  LineProcessorImplementation lineProcessorImplementation;

  @Autowired
  FilterExtensionImplementation filterExtensionImplementation;

  @Autowired
  WordProcessorImplementation wordProcessorImplementation;

  @Autowired
  FilterSizeImplementation filterSizeImplementation;


  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
    App main = applicationContext.getBean(App.class);
    main.traverse(args);

  }

  public void traverse(String[] args) {
    String path = "/home/angularjs";

    try {

      Args argss = new Args();
      JCommander.newBuilder().addObject(argss).build().parse(args);

      if (argss.isLinesCount()) {
        walkerImplementation.setProcessors(lineProcessorImplementation);
      } else {
        walkerImplementation.setProcessors(wordProcessorImplementation);
      }
      LOG.info("Path from JCOMANDER " + argss.getPath());
      LOG.info("Flag about linecounter :" + argss.isLinesCount());
      LOG.info("Flag about wordcounter :" + argss.isWordsCount());
      LOG.info("Extension :" + argss.getExtension());
      LOG.info("Size: " + argss.getSize());
      List<Filter> filters = new ArrayList<>();
      if (argss.isExtension()) {
        filterExtensionImplementation.setExtension(argss.getExtension());
      }
      else {
        filterExtensionImplementation.setExtension("");
      }

      filters.add(filterExtensionImplementation);
      filterSizeImplementation.setSize(argss.getSize());
      filters.add(filterSizeImplementation);
      walkerImplementation.setFilters(filters);
      if (argss.isPath()) {
        walkerImplementation.traverse(argss.getPath());
      }
      else {
        walkerImplementation.traverse("/home/angularjs");
      }

    } catch (FileNotFoundException e) {
      LOG.error(e.getMessage());
    }
  }
}
