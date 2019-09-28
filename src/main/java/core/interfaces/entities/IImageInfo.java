package core.interfaces.entities;

import java.awt.*;

public interface IImageInfo extends INamedEntity {

    Image getImage();

    ISource getSource();

    Iterable<String> getTags();

    void addTag(String tag);
    void removeTag(String tag);
    boolean hasTag(String tag);
}
