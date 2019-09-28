package core.implementation.properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileImagePropertiesTest {

    @Test
    void creationDefaultTest() {
        String path = "C:\\Test\\File.jpg";
        FileImageProperties properties = new FileImageProperties(path);
        assertEquals(path, properties.getPath());
        assertEquals("File", properties.getName());
    }

    @Test
    void creationDifferentNameTest() {
        String path = "C:\\Test\\File.jpg";
        String name = "OtherName";
        String description = "Description";
        FileImageProperties properties = new FileImageProperties("id", name, path, description);
        assertEquals(path, properties.getPath());
        assertEquals(name, properties.getName());
        assertEquals(description, properties.getDescription());
        assertEquals("id", properties.getId());
    }
}