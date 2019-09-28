package core.implementation;

import core.interfaces.IImageProvider;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class CachedImageProvider implements IImageProvider {

    private IImageProvider underlyingProvider;

    private HashMap<String, WeakReference<Image>> cache = new HashMap<String, WeakReference<Image>>();

    public CachedImageProvider(IImageProvider underlyingProvider) {
        this.underlyingProvider = underlyingProvider;
    }

    public Image loadImage(String path) {
        if (cache.containsKey(path) && null != cache.get(path).get())
        {
            WeakReference<Image> weakImage = cache.get(path);
            Image image = weakImage.get();
            if (null != image)
                return image;
        }
        Image img = underlyingProvider.loadImage(path);
        cache.put(path, new WeakReference<Image>(img));
        return img;
    }
}
