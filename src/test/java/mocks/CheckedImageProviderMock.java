package mocks;

import core.interfaces.IImageProvider;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CheckedImageProviderMock implements IImageProvider {

    private boolean touched;

    public CheckedImageProviderMock() {
        touched = false;
    }

    public Image loadImage(String path) {
        touched = true;
        return new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
    }

    public boolean isTouched() { return touched; }

    public void untouch() { touched = false; }
}
