package core.interfaces.database;

import core.implementation.properties.FolderSourceProperties;

public interface ISourcesDatabase {

    Iterable<FolderSourceProperties> getFolderSources();

    void removeFolderSource(String id);

    void updateFolderSource(FolderSourceProperties properties);

    String saveFolderSource(FolderSourceProperties properties);
}
