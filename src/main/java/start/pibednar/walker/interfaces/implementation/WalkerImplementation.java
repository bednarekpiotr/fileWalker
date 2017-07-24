package start.pibednar.walker.interfaces.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import start.pibednar.walker.interfaces.*;

import java.io.FileNotFoundException;
import java.util.List;


@Service
public class WalkerImplementation<T> implements Walker {

    private static final Logger LOG = LoggerFactory.getLogger(WalkerImplementation.class);

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    List<Filter> filters;
    Filter filter;
    List<Processor<T>> processors;
    Processor<T> processor;
    IFileFactoryImplementation iFileFactoryImplementation = new IFileFactoryImplementation();

    /**
     * Metoda przechodzi po plikach i procesuje je
     * @param directory
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public WalkerResult traverse(String directory) throws FileNotFoundException {
        try {
            IFile iFile = iFileFactoryImplementation.createFile(directory);
            if (iFile.isDirectory()) {
                //LOG.info("Entry to a directory" + iFile.getAbsolutePath());
                List<IFile> listOfFile = iFile.listFiles();
                for (IFile iFileFromList : listOfFile) {
                    traverse(iFileFromList.getAbsolutePath());
                }
            } else {
                if (checkByFilters(iFile)) {
                    processor.process(iFile);
                    LOG.info("File path: " + iFile.getAbsolutePath());
                }

            }
        } catch (FileNotFoundException ex) {
            LOG.error("Exceeption during traverse invocation" + ex.getMessage());
            System.exit(1);

        }


        return null;
    }

    @Override
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public void setProcessors(Processor<?>[] processor) {

    }


    public void setProcessors(Processor<T> processor) {
        this.processor = processor;

    }

    public boolean checkByFilters(IFile file) {
      for (Filter filter: filters) {
          if (!filter.filter(file)) {
              return false;
          }

      }
        return true;
    }

}
