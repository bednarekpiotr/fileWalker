package start.pibednar.walker.interfaces.implementation;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import start.pibednar.walker.interfaces.Filter;
import start.pibednar.walker.interfaces.IFile;

/**
 * Created by angularjs on 19.07.17.
 */
@Service
public class FilterSizeImplementation implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(FilterSizeImplementation.class);
    private int size;

    public void setSize(int size) {
        if (size > 0 ) {
            this.size = size;
        }
        else {
            size = 1024;
        }

    }



    @Override
    public boolean filter(IFile file)  {
        return new File(file.getAbsolutePath()).length()/1024 >= size;
    }
}
