package core.interfaces.database;

import core.implementation.properties.FileImageProperties;
import core.interfaces.entities.IImageInfo;

import java.util.HashSet;

public interface IImagesDatabase {

    Iterable<IImageInfo> getImages(Iterable<String> tags);

    FileImageProperties getFileImageProperties(String id);

    void updateFileImageProperties(FileImageProperties properties);

    HashSet<String> getImageTags(FileImageProperties image);
}
