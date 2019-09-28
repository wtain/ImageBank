package core.implementation.application;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import core.implementation.properties.FolderSourceProperties;
import core.interfaces.entities.ISource;
import mocks.ApplicationDatabaseMock;
import mocks.FolderSourceListenerMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.annotation.Nullable;


import static org.junit.jupiter.api.Assertions.*;

class ImageBankApplicationTest {

    String name1;
    String name2;
    FolderSourceProperties properties1;
    FolderSourceProperties properties2;
    ApplicationDatabaseMock database; // todo: check database-side behaviour
    ImageBankApplication app;

    @BeforeEach
    void setUp() {
        name1 = "name1";
        name2 = "name2";
        properties1 = new FolderSourceProperties("id", name1, "", "", new String[] {"JPG"}, false);
        properties2 = new FolderSourceProperties("id", name2, "", "", new String[] {"JPG"}, false);
        database = new ApplicationDatabaseMock();
        app = new ImageBankApplication(database);
    }

    @Test
    void addFolderSource() {
        app.addFolderSource(properties1);
        ISource result = Iterables.find(app.getSources(), new Predicate<ISource>() {
            public boolean apply(@Nullable ISource iSource) {
                return iSource.getName() == name1;
            }
            public boolean test(@Nullable ISource input) {
                return this.apply(input);
            }
        });
        assertNotEquals(null, result);
    }

    @Test
    void removeFolderSource() {
        app.addFolderSource(properties1);
        ISource result = Iterables.find(app.getSources(), new Predicate<ISource>() {
            public boolean apply(@Nullable ISource iSource) {
                return iSource.getName() == name1;
            }
            public boolean test(@Nullable ISource input) {
                return this.apply(input);
            }
        });
        assertNotEquals(null, result);
        app.removeFolderSource(properties1);
        assertEquals(null, result);
    }

    @Test
    void selectFolderSource() {
        app.addFolderSource(properties1);
        app.addFolderSource(properties2);
        app.selectFolderSource(properties1);
        assertEquals(app.getSelectedSource().getName(), name1);
        app.selectFolderSource(properties2);
        assertEquals(app.getSelectedSource().getName(), name2);
    }

    @Test
    void addFolderSourceListener() {
        FolderSourceListenerMock listener = new FolderSourceListenerMock();
        app.addFolderSourceListener(listener);
        app.addFolderSource(properties1);
        assertEquals(1, listener.getAddedCount());
        assertEquals(0, listener.getRemovedCount());
        assertEquals(null, listener.getSelectedName());

        app.addFolderSource(properties2);
        assertEquals(2, listener.getAddedCount());
        assertEquals(0, listener.getRemovedCount());
        assertEquals(null, listener.getSelectedName());

        app.selectFolderSource(properties1);

        assertEquals(2, listener.getAddedCount());
        assertEquals(0, listener.getRemovedCount());
        assertEquals(name1, listener.getSelectedName());

        app.removeFolderSource(properties2);

        assertEquals(2, listener.getAddedCount());
        assertEquals(1, listener.getRemovedCount());
        assertEquals(name1, listener.getSelectedName());

        app.removeFolderSource(properties1);

        assertEquals(2, listener.getAddedCount());
        assertEquals(2, listener.getRemovedCount());
        assertEquals(null, listener.getSelectedName());
    }

    @Test
    void getSelectedSource() {
        FolderSourceListenerMock listener = new FolderSourceListenerMock();
        app.addFolderSourceListener(listener);
        app.addFolderSource(properties1);
        assertEquals(null, app.getSelectedSource());
        app.selectFolderSource(properties1);
        assertEquals(name1, app.getSelectedSource().getName());
    }

    @Test
    void getSources() {
        app.addFolderSource(properties1);
        app.addFolderSource(properties2);
        assertEquals(2, Iterables.size(app.getSources()));
        assertFalse(null == Iterables.find(app.getSources(), new Predicate<ISource>() {
            public boolean apply(@Nullable ISource iSource) {
                return iSource.getName() == name1;
            }
            public boolean test(@Nullable ISource input) {
                return this.apply(input);
            }
        }));
        assertFalse(null == Iterables.find(app.getSources(), new Predicate<ISource>() {
            public boolean apply(@Nullable ISource iSource) {
                return iSource.getName() == name2;
            }
            public boolean test(@Nullable ISource input) {
                return this.apply(input);
            }
        }));
    }

    /*
    @Test
    void getSelectedImage() {
    }

    @Test
    void getImages() {
    }
    */
}