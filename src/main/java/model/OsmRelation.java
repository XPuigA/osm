package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OsmRelation {
    private String id;
    private boolean visible;
    private int version;
    private String changeset;
    private String timestamp;
    private String user;
    private String uid;

    @JsonProperty("member")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmMember> members = new ArrayList<OsmMember>();
    @JsonProperty("tag")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<OsmTag> tagsList = new ArrayList<OsmTag>();

    private Map<String, String> tagsMap;

    public void fillMaps() {
        tagsMap = new HashMap<>();
        for (OsmTag tag : tagsList) {
            tagsMap.put(tag.getKey(), tag.getValue());
        }
    }

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

    public String getChangeset() {
        return changeset;
    }

    public void setChangeset(String changeset) {
        this.changeset = changeset;
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

    public List<OsmMember> getMembers() {
        return members;
    }

    public void setMembers(List<OsmMember> members) {
        this.members = members;
    }

    public Map<String, String> getTags() {
        return tagsMap;
    }

    public void setTags(Map<String, String> tagsMap) {
        this.tagsMap = tagsMap;
    }

    public List<OsmTag> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<OsmTag> tagsList) {
        this.tagsList = tagsList;
    }
}
