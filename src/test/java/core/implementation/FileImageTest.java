package core.implementation;

import core.implementation.properties.FileImageProperties;
import mocks.ImageProviderMock;
import mocks.SourceMock;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileImageTest {

    SourceMock source;
    ImageProviderMock imageProvider;

    @Before
    void init() {
        source = new SourceMock();
        imageProvider = new ImageProviderMock();
    }

    FileImage create(String path) {
        return new FileImage(source, imageProvider, new FileImageProperties(path));
    }

    @Test
    void creationTest() {
        String path = "C:\\Folder\\File.jpg";
        FileImage image = create(path);
        assertEquals(null, image.getDescription());
        assertEquals("File", image.getName());
        assertEquals(source, image.getSource());
    }

    @Test
    void changeNameTest() {
        String path = "C:\\Folder\\File.jpg";
        String newName = "New Name";
        FileImage image = create(path);
        image.setName(newName);
        assertEquals(newName, image.getName());
    }

    @Test
    void changeDescriptionTest() {
        String path = "C:\\Folder\\File.jpg";
        String newDescription = "New description";
        FileImage image = create(path);
        image.setDescription(newDescription);
        assertEquals(newDescription, image.getDescription());
    }
}