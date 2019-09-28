package core.interfaces.entities;

public interface INamedEntity extends IDatabaseEntity {

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

}
