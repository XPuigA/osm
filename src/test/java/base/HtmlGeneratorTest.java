package base;

import generator.HtmlGenerator;
import model.OsmMap;
import org.junit.Test;
import parser.OsmParser;

import java.io.IOException;

import static base.Utils.getResourceFileAsString;

public class HtmlGeneratorTest {

    @Test
    public void test1() throws IOException {
        OsmMap osmMap = OsmParser.parse(getResourceFileAsString("xml1.xml"));
        HtmlGenerator generator = new HtmlGenerator(osmMap, 100, 100);
        System.out.println(generator.generate());
    }
}
