package core.interfaces.entities;

public interface ISource extends INamedEntity {

    void remove();
    void select();

    Iterable<IImageInfo> getImages();
}
