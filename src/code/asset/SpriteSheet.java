package code.asset;

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
}
