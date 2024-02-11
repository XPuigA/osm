package base;

import generator.SvgGenerator;
import model.OsmMap;
import org.junit.Test;
import parser.OsmParser;

import java.io.IOException;

import static base.Utils.getResourceFileAsString;

public class SvgGeneratorTest {

    @Test
    public void test1() throws IOException {
        OsmMap osmMap = OsmParser.parse(getResourceFileAsString("xml1.xml"));
        System.out.println(SvgGenerator.generateSvg(osmMap));
    }
}
