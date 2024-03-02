package generator;

import model.*;
import properties.PropertiesHandler;

import javax.swing.*;
import java.awt.*;

public class SwingGenerator extends GeneratorDrawer {

    private final Graphics graphics;
    private Component component;

    public SwingGenerator(Graphics graphics, OsmMap map) {
        this(graphics, map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public SwingGenerator(Graphics graphics, OsmMap map, int width, int height) {
        super(map, width, height);
        this.graphics = graphics;
        this.component = new JPanel();
    }

    @Override
    public void generate() {
        for (OsmRelation relation : map.getRelations().values()) {
            drawRelation(relation);
        }
        for (OsmWay way : map.getWays().values()) {
            drawWay(way);
        }
    }

    @Override
    public Component getResult() {
        return component;
    }

    private void drawRelation(OsmRelation relation) {
        String type = relation.getTags().get("type");
        if (type != null && type.equals("multipolygon")) {
            for (OsmMember member : relation.getMembers()) {
                OsmWay way = map.getWays().get(member.getRef());
                if (way != null && !drawnWayIds.contains(way.getId())) {
                    drawPolygon(way);
                }
            }
        }
    }

    private void drawPolygon(OsmWay way) {
        Polygon p = new Polygon();
        StringBuilder sb = new StringBuilder("<polygon points=\"");
        for (int i = 0; i < way.getNds().size(); ++i) {
            OsmNode node = map.getNodes().get(way.getNds().get(i).getRef());
            p.addPoint((int) scaleLongitude(node.getLon()), (int) scaleLatitude(node.getLat()));
        }
        sb.append("\" style=\"" + PropertiesHandler.getProperty("svg-relation-style") + "\" />");
        drawnWayIds.add(way.getId());
        graphics.drawPolygon(p);
    }

    private void drawWay(OsmWay way) {
        for (int i = 1; i < way.getNds().size() - 1; ++i) {
            OsmNode node1 = map.getNodes().get(way.getNds().get(i - 1).getRef());
            OsmNode node2 = map.getNodes().get(way.getNds().get(i).getRef());
            graphics.drawLine(
                    (int) Math.round(scaleLongitude(node1.getLon())),
                    (int) Math.round(scaleLatitude(node1.getLat())),
                    (int) Math.round(scaleLongitude(node2.getLon())),
                    (int) Math.round(scaleLatitude(node2.getLat()))
            );

        }
    }
}
