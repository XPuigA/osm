package generator;

import java.io.IOException;

public interface Generator {

    public void generate() throws Exception;

    public Object getResult();
}
