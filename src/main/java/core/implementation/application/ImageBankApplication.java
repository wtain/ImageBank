package core.implementation.application;

import core.implementation.properties.FolderSourceProperties;
import core.interfaces.ISourceManager;
import core.interfaces.application.IImageBankApplication;
import core.interfaces.application.listeners.IFolderSourceListener;
import core.interfaces.database.IApplicationDatabase;
import core.interfaces.entities.IImageInfo;
import core.interfaces.entities.ISource;

public class ImageBankApplication implements IImageBankApplication {

    private IApplicationDatabase database;
    private ISourceManager sourceManager;

    public ImageBankApplication(IApplicationDatabase database) {
        this.database = database;
        //this.sourceManager = new SourceMa
    }

    public void addFolderSource(FolderSourceProperties folderSourceProperties) {

    }

    public void removeFolderSource(FolderSourceProperties folderSourceProperties) {

    }

    public void selectFolderSource(FolderSourceProperties folderSourceProperties) {

    }

    public void addFolderSourceListener(IFolderSourceListener listener) {

    }

    public ISource getSelectedSource() {
        return null;
    }

    public Iterable<ISource> getSources() {
        return null;
    }

    public IImageInfo getSelectedImage() {
        return null;
    }

    public Iterable<IImageInfo> getImages() {
        return null;
    }
}
