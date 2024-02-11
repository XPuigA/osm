package generator;

import model.OsmMap;
import model.OsmNd;
import model.OsmRelation;
import model.OsmWay;

public class SvgGenerator {

    public static int DEFAULT_WIDTH = 100;
    public static int DEFAULT_HEIGHT = 100;

    public static String generateSvg(OsmMap map) {
        return generateSvg(map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static String generateSvg(OsmMap map, int width, int height) {
        StringBuilder sb = new StringBuilder("<svg width=\"" + width + "\" height=\"" + height + "\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (OsmWay way : map.getWays().values()) {
            sb.append("\t").append(way.getId()).append("\n");
            for (OsmNd nd : way.getNds()) {
                sb.append("\t\t").append(map.getNodes().get(nd.getRef()).getId()).append("\n");
            }
        }
        sb.append("</svg>");
        return sb.toString();
    }
}
