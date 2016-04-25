package com.simplegame.tiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;

import java.awt.Rectangle;

/**
 * Created by Carl on 23/04/2016.
 */
public class WallTile extends Tile
{
    public WallTile(int xOffset, int yOffset)
    {
        position = new Vector2(xOffset * width, yOffset * height);

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
        sprite.setPosition(position.x, position.y);

        bounds = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
    }

    @Override
    public void checkCollisions(int counter)
    {
        if(bounds.intersects(SimpleGame.gameObjects.get(counter).getBounds()))
        {
            //Rectangle rect = bounds.intersection(SimpleGame.gameObjects.get(counter).getBounds());

            //SimpleGame.gameObjects.get(counter).getSprite().setPosition(SimpleGame.gameObjects.get(counter).getPreviousPosition().x, SimpleGame.gameObjects.get(counter).getPreviousPosition().y);

            setHoldingObject(true);
            getSprite().setColor(Color.SCARLET);

            //System.out.println("Object at position: " + tile[i][j].getPosition().x + ", " + tile[i][j].getPosition().y);
            //System.out.println("Object at position: " + SimpleGame.gameObjects.get(counter).getSprite().getX() + ", " + SimpleGame.gameObjects.get(counter).getSprite().getY());
        }
        else
        {
            setHoldingObject(false);
            getSprite().setColor(Color.WHITE);
        }
    }
}
