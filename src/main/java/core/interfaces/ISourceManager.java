package core.interfaces;

import core.implementation.properties.FolderSourceProperties;
import core.interfaces.entities.ISource;

public interface ISourceManager {

    Iterable<ISource> getSources();

    ISource getSelectedSource();

    ISource createFolderSource(String path);

    void change(FolderSourceProperties properties);

    void remove(String id);

    void select(String id);
}
