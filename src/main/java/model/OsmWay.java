package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class OsmWay {

    private String id;
    private boolean visible;
    private int version;
    @JsonProperty("changeset")
    private String changeSet;
    private String timestamp;
    private String user;
    private String uid;
    @JsonProperty("nd")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmNd> nds = new ArrayList<OsmNd>();
    @JsonProperty("tag")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmTag> tags = new ArrayList<OsmTag>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getChangeSet() {
        return changeSet;
    }

    public void setChangeSet(String changeSet) {
        this.changeSet = changeSet;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<OsmNd> getNds() {
        return nds;
    }

    public void setNds(List<OsmNd> nds) {
        this.nds = nds;
    }

    public List<OsmTag> getTags() {
        return tags;
    }

    public void setTags(List<OsmTag> tags) {
        this.tags = tags;
    }
}
