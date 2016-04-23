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
        id = 0;

        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        pixmap.setColor(Color.RED);
        pixmap.drawLine(0, 0, (int)width, (int)height);
        pixmap.drawLine(0, (int)height, (int)width, 0);

        texture = new Texture(pixmap);
        pixmap.dispose();

        sprite = new Sprite(texture);
        //sprite.setPosition(position.x, position.y);
    }
}
