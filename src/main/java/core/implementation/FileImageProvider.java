package core.implementation;

import core.interfaces.IImageProvider;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class FileImageProvider implements IImageProvider {
    public Image loadImage(String path) {
        try {
            ImageIcon newIcon = new ImageIcon(ImageIO.read(new File(path)));
            return newIcon.getImage();
        } catch (IOException ex){

        }
        return null;
    }
}
