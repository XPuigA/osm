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
        return clampHeight(height - (norm * height));
    }

    private double clampHeight(double height) {
        return clamp(height, this.height);
    }

    protected double scaleLongitude(double longitude) {
        double norm = (longitude - map.getBounds().getMinLon()) / (map.getBounds().getMaxLon() - map.getBounds().getMinLon());
        return clampWidth(norm * width);
    }

    private double clampWidth(double width) {
        return clamp(width, this.width);
    }

    private double clamp(double value, int max) {
        return value;
        /*if (value < 0) return 0;
        else if (value > max) return max;
        return value;*/
    }
}
