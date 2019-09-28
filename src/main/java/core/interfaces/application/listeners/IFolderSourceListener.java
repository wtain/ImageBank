package core.interfaces.application.listeners;

import core.implementation.properties.FolderSourceProperties;

public interface IFolderSourceListener {

    void folderSourceAdded(FolderSourceProperties sourceProperties);
    void folderSourceRemoved(FolderSourceProperties sourceProperties);
    void folderSourceSelected(FolderSourceProperties sourceProperties);

}
