package core.implementation;

import mocks.CheckedImageProviderMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CachedImageProviderTest {

    @Test
    void secondLoadShouldNotTouchSource() {
        CheckedImageProviderMock provider = new CheckedImageProviderMock();
        CachedImageProvider cachedProvider = new CachedImageProvider(provider);

        String path1 = "path1";
        String path2 = "path2";

        cachedProvider.loadImage(path1);
        assertTrue(provider.isTouched());
        provider.untouch();
        assertFalse(provider.isTouched());

        cachedProvider.loadImage(path1);
        assertFalse(provider.isTouched());

        cachedProvider.loadImage(path2);
        assertTrue(provider.isTouched());
    }

}