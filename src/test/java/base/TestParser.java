package base;

import model.OsmMap;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import parser.OsmParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static base.Utils.getResourceFileAsString;


public class TestParser {


    @Test
    public void parse1() throws IOException {
        String content = getResourceFileAsString("xml1.xml");

        OsmMap map = OsmParser.parse(content);
        Assertions.assertNotNull(map);
        Assertions.assertEquals(398, map.getNodes().size());
        Assertions.assertEquals(9, map.getWays().size());
        Assertions.assertEquals(2, map.getRelations().size());
    }
}
