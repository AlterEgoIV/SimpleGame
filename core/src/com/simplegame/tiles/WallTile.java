package com.simplegame.tiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.gameobjects.GameObject;

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

        sprite = new Sprite(texture);
        sprite.setPosition(position.x, position.y);

        pixmap.dispose();

        bounds = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
    }

    @Override
    public void handleXAxisCollisions(GameObject obj)
    {
        // If tile rectangle intersects object rectangle
        if(bounds.intersects(obj.getBounds()))
        {
            // Create a new rectangle equal to the dimensions of the intersection
            Rectangle rect = bounds.intersection(obj.getBounds());

            if(bounds.getX() < obj.getBounds().getX())
            {
                obj.getSprite().translateX(rect.width);
                obj.getBounds().setLocation((int)obj.getSprite().getX(), (int)obj.getSprite().getY());
            }

            if(bounds.getX() > obj.getBounds().getX())
            {
                obj.getSprite().translateX(-rect.width);
                obj.getBounds().setLocation((int)obj.getSprite().getX(), (int)obj.getSprite().getY());
            }

            getSprite().setColor(Color.SCARLET);
        }
        else
        {
            getSprite().setColor(Color.WHITE);
        }
    }

    @Override
    public void handleYAxisCollisions(GameObject obj)
    {
        // If tile rectangle intersects object rectangle
        if(bounds.intersects(obj.getBounds()))
        {
            // Create a new rectangle equal to the dimensions of the intersection
            Rectangle rect = bounds.intersection(obj.getBounds());

            if(bounds.getY() < obj.getBounds().getY())
            {
                obj.getSprite().translateY(rect.height);
                obj.getBounds().setLocation((int)obj.getSprite().getX(), (int)obj.getSprite().getY());
            }

            if(bounds.getY() > obj.getBounds().getY())
            {
                obj.getSprite().translateY(-rect.height);
                obj.getBounds().setLocation((int)obj.getSprite().getX(), (int)obj.getSprite().getY());
            }

            getSprite().setColor(Color.SCARLET);
        }
    }
}
