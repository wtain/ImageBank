package core.interfaces;

import core.implementation.properties.FileImageProperties;
import core.interfaces.entities.IImageInfo;

public interface IImagesManager {

    Iterable<IImageInfo> getImages();

    IImageInfo getSelectedImage();

    void change(FileImageProperties properties);

    void select(String id);

}
