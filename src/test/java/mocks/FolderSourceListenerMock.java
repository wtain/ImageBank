package mocks;

import core.implementation.properties.FolderSourceProperties;
import core.interfaces.application.listeners.IFolderSourceListener;

public class FolderSourceListenerMock implements IFolderSourceListener {

    private int added = 0;
    private int removed = 0;
    private String selected;

    public void folderSourceAdded(FolderSourceProperties sourceProperties) {
        ++added;
    }

    public void folderSourceRemoved(FolderSourceProperties sourceProperties) {
        ++removed;
    }

    public void folderSourceSelected(FolderSourceProperties sourceProperties) {
        selected = sourceProperties.getName();
    }

    public int getAddedCount() { return added; }
    public int getRemovedCount() { return removed; }
    public String getSelectedName() { return selected; }
}
