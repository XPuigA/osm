package base;

import generator.HtmlFileGenerator;
import model.OsmMap;
import org.junit.jupiter.api.*;
import parser.OsmParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static base.Utils.getResourceFileAsString;

public class HtmlFileGeneratorTest {

    private static String destination1 = "D:\\\\map.html";

    @BeforeAll
    @AfterAll
    static void deleteFile() throws IOException {
        Files.deleteIfExists(Paths.get(destination1));
    }

    @Test
    public void test1() throws IOException {
        OsmMap osmMap = OsmParser.parse(getResourceFileAsString("map2.osm"));
        HtmlFileGenerator generator = new HtmlFileGenerator(osmMap, 300, 150, destination1);
        System.out.println(generator.generate());
    }
}
