package core.interfaces.application;

import core.implementation.properties.FolderSourceProperties;
import core.interfaces.application.listeners.IFolderSourceListener;
import core.interfaces.entities.IImageInfo;
import core.interfaces.entities.ISource;

public interface IImageBankApplication {

    void addFolderSource(FolderSourceProperties folderSourceProperties);
    void removeFolderSource(FolderSourceProperties folderSourceProperties);
    void selectFolderSource(FolderSourceProperties folderSourceProperties);

    void addFolderSourceListener(IFolderSourceListener listener);

    ISource getSelectedSource();

    Iterable<ISource> getSources();

    IImageInfo getSelectedImage();

    Iterable<IImageInfo> getImages();
}
