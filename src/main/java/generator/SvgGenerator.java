package generator;

import model.*;

public class SvgGenerator implements Generator {

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 150;

    private OsmMap map;
    private int width;
    private int height;

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
                    .append(" y1=\"").append(scaleLatitude(node1.getLat()))
                    .append("\" x1=\"").append(scaleLongitude(node1.getLon()))
                    .append("\" y2=\"").append(scaleLatitude(node2.getLat()))
                    .append("\" x2=\"").append(scaleLongitude(node2.getLon()))
                    .append("\" style=\"stroke:red;stroke-width:1\" />\n");
            }
        }
        sb.append("</svg>");
        return sb.toString();
    }

    private double scaleLatitude(double latitude) {
        double norm = (latitude - map.getBounds().getMinLat()) / (map.getBounds().getMaxLat() - map.getBounds().getMinLat());
        return height - (norm * height);
    }

    private double scaleLongitude(double longitude) {
        double norm = (longitude - map.getBounds().getMinLon()) / (map.getBounds().getMaxLon() - map.getBounds().getMinLon());
        return norm * width;
    }
}
