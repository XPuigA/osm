package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OsmBounds {

    @JacksonXmlProperty(localName = "minlat")
    private double minLat;
    @JacksonXmlProperty(localName = "minlon")
    private double minLon;
    @JacksonXmlProperty(localName = "maxlat")
    private double maxLat;
    @JacksonXmlProperty(localName = "maxlon")
    private double maxLon;

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public void setMinLon(double minLon) {
        this.minLon = minLon;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(double maxLon) {
        this.maxLon = maxLon;
    }
}
