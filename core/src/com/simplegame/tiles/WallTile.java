package com.simplegame.tiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Carl on 23/04/2016.
 */
public class WallTile extends Tile
{
    public WallTile()
    {
        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);

        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0, 0, (int)width, 10);
        pixmap.fillRectangle(0, 0, 10, (int)height);
        pixmap.fillRectangle((int)width - 1, 0, -10, (int)height);
        pixmap.fillRectangle(0, (int)height - 10, (int)width, 10);

        texture = new Texture(pixmap);
        pixmap.dispose();

        sprite = new Sprite(texture);
        //sprite.setPosition(position.x, position.y);
    }
}
