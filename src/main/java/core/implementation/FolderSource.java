package core.implementation;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import core.implementation.properties.FileImageProperties;
import core.implementation.properties.FolderSourceProperties;
import core.interfaces.IImageProvider;
import core.interfaces.ISourceManager;
import core.interfaces.entities.IImageInfo;
import core.interfaces.entities.ISource;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nullable;
import java.io.File;

public class FolderSource implements ISource {

    private ISourceManager manager;
    private FolderSourceProperties properties;
    private IImageProvider provider;

    public FolderSource(ISourceManager manager, FolderSourceProperties properties) {
        this.manager = manager;
        this.properties = properties;
        this.provider = new CachedImageProvider(new FileImageProvider());
    }

    public void remove() {
        manager.remove(properties.getId());
    }

    public void select() {
        manager.select(properties.getId());
    }

    public Iterable<IImageInfo> getImages() {
        File dir = new File(properties.getPath());
        return Iterables.transform(FileUtils.listFiles(dir, properties.getExtensions(), properties.isRecursive()),
                new Function<File, IImageInfo>() {
                    @Nullable
                    public IImageInfo apply(@Nullable File file) {
                        String path = file.getAbsolutePath();
                        return new FileImage(FolderSource.this, provider, new FileImageProperties(path));
                    }
                });
    }

    public String getName() {
        return properties.getName();
    }

    public void setName(String name) {
        properties.setName(name);
    }

    public String getDescription() {
        return properties.getDescription();
    }

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
