package core.implementation.properties;

import core.interfaces.entities.INamedEntity;

public class FolderSourceProperties implements INamedEntity {
    private String id;
    private String name;
    private String description;
    private String path;
    private String[] extensions;
    private boolean recursive;

    public FolderSourceProperties(String id, String name, String description, String path, String[] extensions, boolean recursive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.extensions = extensions;
        this.recursive = recursive;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPath() { return path; }
    public String[] getExtensions() { return extensions; }
    public boolean isRecursive() { return recursive; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPath(String path) { this.path = path; }
    public void setExtensions(String[] extensions) { this.extensions = extensions; }
    public void setRecursive(boolean recursive) { this.recursive = recursive; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
