package code.asset;

import java.awt.image.BufferedImage;

public class Map {

    public Map() {
        SpriteSheet tileImage = new SpriteSheet("src/resources/data/maps/test_map_Map.csv");

        BufferedImage[] mapTiles= tileImage.getMap();
    }

    public void draw() {

    }
}

