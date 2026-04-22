package code.asset;

import code.util.Utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {
    private BufferedImage originalImage;

    public SpriteSheet(String path) {
        try {
            this.originalImage = ImageIO.read(new File(path)); // TODO: Later change to GetResourseAsStream()
        } catch (IOException e) {
            e.printStackTrace(); // TODO: find better solution to handle the null situation
        }
    }

    public BufferedImage getSprite(int column, int row, int width, int height) {
        return originalImage.getSubimage(column * width, row * height, width, height);
    }

    public BufferedImage[] getMap() {
        int numColumns =  originalImage.getWidth() / Utilities.MAP_TILE_SIZE;
        int numRows = originalImage.getHeight() / Utilities.MAP_TILE_SIZE;
        BufferedImage[] mapTiles = new BufferedImage[numColumns * numRows];
        int tileIterator = 0;

        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                mapTiles[tileIterator] = originalImage.getSubimage(i, j, Utilities.MAP_TILE_SIZE, Utilities.MAP_TILE_SIZE);
            }
        }

        return mapTiles;
    }
}
