package generator;

import java.io.IOException;

public interface Generator {

    public void generate() throws IOException;

    public Object getResult();
}
