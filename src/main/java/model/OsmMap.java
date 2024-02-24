package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OsmMap {

    private String version;
    private String generator;
    private String copyright;
    private String attribution;
    private String license;
    private OsmBounds bounds;
    @JsonProperty("node")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmNode> nodesList = new ArrayList<>();
    @JsonProperty("way")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmWay> waysList = new ArrayList<>();
    @JsonProperty("relation")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmRelation> relationsList = new ArrayList<>();
    private Map<String, OsmNode> nodeMap = new HashMap<>();
    private Map<String, OsmWay> wayMap = new HashMap<>();
    private Map<String, OsmRelation> relationMap = new HashMap<>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public OsmBounds getBounds() {
        return bounds;
    }

    public void setBounds(OsmBounds bounds) {
        this.bounds = bounds;
    }

    public Map<String, OsmNode> getNodes() {
        return this.nodeMap;
    }

    public void setNodes(List<OsmNode> nodes) {
        this.nodesList = nodes;

    }

    public Map<String, OsmWay> getWays() {
        return this.wayMap;
    }

    public void setWays(List<OsmWay> ways) {
        this.waysList = ways;

    }

    public Map<String, OsmRelation> getRelations() {
        return this.relationMap;
    }

    public void setRelations(List<OsmRelation> relations) {
        this.relationsList = relations;
    }

    public void fillMaps() {
        this.nodeMap = new HashMap<>();
        for (OsmNode node : nodesList) {
            this.nodeMap.put(node.getId(), node);
        }

        this.wayMap = new HashMap<>();
        for (OsmWay way : waysList) {
            this.wayMap.put(way.getId(), way);
        }

        this.relationMap = new HashMap<>();
        for (OsmRelation relation : relationsList) {
            this.relationMap.put(relation.getId(), relation);
            relation.fillMaps();
        }

    }
}
