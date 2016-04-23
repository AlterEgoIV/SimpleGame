package com.simplegame.tiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Carl on 23/04/2016.
 */
public class FloorTile extends Tile
{
    public FloorTile(int xOffset, int yOffset)
    {
        position = new Vector2(xOffset * width, yOffset * height);

        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        pixmap.setColor(Color.FOREST);
        pixmap.fillRectangle(0, 0, (int)width, 10);
        pixmap.fillRectangle(0, 0, 10, (int)height);
        pixmap.fillRectangle((int)width - 1, 0, -10, (int)height);
        pixmap.fillRectangle(0, (int)height - 10, (int)width, 10);

        texture = new Texture(pixmap);
        pixmap.dispose();

        sprite = new Sprite(texture);
        sprite.setPosition(position.x, position.y);
    }
}
