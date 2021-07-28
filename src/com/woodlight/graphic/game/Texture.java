package com.woodlight.graphic.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;

public class Texture {
    public int[] pixels;
    public final int SIZE;

    public Texture(String location, int size) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }


    private void load() {
        try {
            BufferedImage image = ImageIO.read(new File(getClass().getResource("/com/woodlight/resources/redbrick.png").toURI()));
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException | URISyntaxException ioException) {
            ioException.printStackTrace();
        }
    }

    public static Texture wood = new Texture(null, 64);
    public static Texture brick = new Texture(null, 64);
    public static Texture bluestone = new Texture(null, 64);
    public static Texture stone = new Texture(null, 64);
}