package generator;

import model.OsmMap;

import java.util.HashSet;
import java.util.Set;

public abstract class GeneratorDrawer implements Generator {

    public static int DEFAULT_WIDTH = 300;
    public static int DEFAULT_HEIGHT = 150;

    protected OsmMap map;
    protected int width;
    protected int height;

    protected Set<String> drawnWayIds = new HashSet<>();

    public GeneratorDrawer(OsmMap map) {
        this(map, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public GeneratorDrawer(OsmMap map, int width, int height) {
        this.map = map;
        this.width = width;
        this.height = height;
    }

    protected double scaleLatitude(double latitude) {
        double norm = (latitude - map.getBounds().getMinLat()) / (map.getBounds().getMaxLat() - map.getBounds().getMinLat());
        return height - (norm * height);
    }

    protected double scaleLongitude(double longitude) {
        double norm = (longitude - map.getBounds().getMinLon()) / (map.getBounds().getMaxLon() - map.getBounds().getMinLon());
        return norm * width;
    }
}
