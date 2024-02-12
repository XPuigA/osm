package generator;

import model.*;

public class SvgGenerator implements Generator {

    public static int DEFAULT_WIDTH = 100;
    public static int DEFAULT_HEIGHT = 100;

    private OsmMap map;
    private int width;
    private int height;

    private double scaleX;
    private double scaleY;

    public SvgGenerator(OsmMap map) {
        this(map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public SvgGenerator(OsmMap map, int width, int height) {
        this.map = map;
        this.width = width;
        this.height = height;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder("<svg width=\"" + width + "\" height=\"" + height + "\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        for (OsmWay way : map.getWays().values()) {
            for (int i = 1; i < way.getNds().size() - 1; ++i) {
                OsmNode node1 = map.getNodes().get(way.getNds().get(i - 1).getRef());
                OsmNode node2 = map.getNodes().get(way.getNds().get(i).getRef());
                sb.append("\t\t<line")
                    .append(" x1=\"").append(scaleLatitude(node1.getLat()))
                    .append("\" y1=\"").append(scaleLatitude(node1.getLon()))
                    .append("\" x2=\"").append(scaleLatitude(node2.getLat()))
                    .append("\" y2=\"").append(scaleLatitude(node2.getLon()))
                    .append("\" style=\"stroke:red;stroke-width:2\" />\n");
            }
        }
        sb.append("</svg>");
        return sb.toString();
    }

    // TODO
    private double scaleLatitude(double latitude) {
        return 0.0;
    }

    // TODO
    private double scaleLongitude(double longitude) {
        return 0.0;
    }
}
