package mocks;

import core.implementation.properties.FileImageProperties;
import core.implementation.properties.FolderSourceProperties;
import core.interfaces.database.IApplicationDatabase;
import core.interfaces.entities.IImageInfo;

import java.util.HashSet;

public class ApplicationDatabaseMock implements IApplicationDatabase {
    public Iterable<IImageInfo> getImages(Iterable<String> tags) {
        return null;
    }

    public FileImageProperties getFileImageProperties(String id) {
        return null;
    }

    public void updateFileImageProperties(FileImageProperties properties) {

    }

    public HashSet<String> getImageTags(FileImageProperties image) {
        return null;
    }

    public Iterable<FolderSourceProperties> getFolderSources() {
        return null;
    }

    public void removeFolderSource(String id) {

    }

    public void updateFolderSource(FolderSourceProperties properties) {

    }

    public String saveFolderSource(FolderSourceProperties properties) {
        return null;
    }
}
