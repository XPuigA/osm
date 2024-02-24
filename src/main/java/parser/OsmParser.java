package parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.OsmMap;


public class OsmParser {
    public static OsmMap parse(String content) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        OsmMap osmMap = mapper.readValue(content, OsmMap.class);
        osmMap.fillMaps();
        return osmMap;
    }
}
