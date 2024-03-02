package generator;

import model.*;
import properties.PropertiesHandler;

public class SvgGenerator extends GeneratorDrawer {

    private String result;

    public SvgGenerator(OsmMap map) {
        this(map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public SvgGenerator(OsmMap map, int width, int height) {
        super(map, width, height);
    }

    @Override
    public void generate() {
        StringBuilder sb = new StringBuilder("<svg width=\"" + width + "\" height=\"" + height + "\" xmlns=\"http://www.w3.org/2000/svg\" style=\"" + PropertiesHandler.getProperty("svg-default-style") + "\">\n");
        for (OsmRelation relation : map.getRelations().values()) {
            sb.append(drawRelation(relation));
        }
        for (OsmWay way : map.getWays().values()) {
            sb.append(drawWay(way));
        }
        sb.append("</svg>");
        result= sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

    private String drawRelation(OsmRelation relation) {
        StringBuilder sb = new StringBuilder();
        String type = relation.getTags().get("type");
        if (type != null && type.equals("multipolygon")) {
            for (OsmMember member : relation.getMembers()) {
                OsmWay way = map.getWays().get(member.getRef());
                if (way != null && !drawnWayIds.contains(way.getId())) {
                    sb.append(drawPolygon(way));
                }
            }
        }
        return sb.toString();
    }

    private String drawPolygon(OsmWay way) {
        StringBuilder sb = new StringBuilder("<polygon points=\"");
        for (int i = 0; i < way.getNds().size(); ++i) {
            OsmNode node = map.getNodes().get(way.getNds().get(i).getRef());
            sb.append(scaleLongitude(node.getLon())).append(",").append(scaleLatitude(node.getLat())).append(" ");
        }
        sb.append("\" style=\"" + PropertiesHandler.getProperty("svg-relation-style") + "\" />");
        drawnWayIds.add(way.getId());
        return sb.toString();
    }

    private String drawWay(OsmWay way) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < way.getNds().size() - 1; ++i) {
            OsmNode node1 = map.getNodes().get(way.getNds().get(i - 1).getRef());
            OsmNode node2 = map.getNodes().get(way.getNds().get(i).getRef());
            sb.append("\t\t<line")
                .append(" y1=\"").append(scaleLatitude(node1.getLat()))
                .append("\" x1=\"").append(scaleLongitude(node1.getLon()))
                .append("\" y2=\"").append(scaleLatitude(node2.getLat()))
                .append("\" x2=\"").append(scaleLongitude(node2.getLon()))
                .append("\" style=\"" + PropertiesHandler.getProperty("svg-way-style") + "\" />\n");
        }
        return sb.toString();
    }
}
