package core.implementation;

import core.implementation.properties.FileImageProperties;
import core.interfaces.IImageProvider;
import core.interfaces.entities.IImageInfo;
import core.interfaces.entities.ISource;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.util.HashSet;

public class FileImage implements IImageInfo {

    private FileImageProperties properties;
    private ISource source;
    private IImageProvider loader;
    private HashSet<String> tags;

    public FileImage(ISource source, IImageProvider loader, FileImageProperties properties) {
        this.source = source;
        this.loader = loader;
        this.properties = properties;
        this.tags = new HashSet<String>();
    }

    @Override
    public Image getImage() {
        return loader.loadImage(properties.getPath());
    }

    @Override
    public ISource getSource() {
        return source;
    }

    public Iterable<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }

    @Override
    public String getName() {
        return properties.getName();
    }

    @Override
    public void setName(String name) {
        properties.setName(name);
    }

    @Override
    public String getDescription() {
        return properties.getDescription();
    }

    @Override
    public void setDescription(String description) {
        properties.setDescription(description);
    }

    public String getId() {
        return properties.getId();
    }

    public void setId(String id) {
        properties.setId(id);
    }
}
