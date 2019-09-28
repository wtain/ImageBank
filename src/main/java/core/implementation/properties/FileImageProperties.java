package core.implementation.properties;

import core.interfaces.entities.INamedEntity;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Paths;

public class FileImageProperties implements INamedEntity {
    private String id;
    private String name;
    private String path;
    private String description;

    public FileImageProperties(String path) {
        this(null, null, path, null);
    }

    public FileImageProperties(String id, String name, String path, String description) {
        this.id = id;
        this.name = name;
        if (null == name || name.isEmpty())
            this.name = FilenameUtils.removeExtension(Paths.get(path).getFileName().toString());
        this.path = path;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
