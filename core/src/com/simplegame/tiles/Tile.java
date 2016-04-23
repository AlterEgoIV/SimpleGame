package com.simplegame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;

import java.awt.Rectangle;
import java.util.Random;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tile extends GameObject
{
    // private Random rand;
    // protected int id;
    protected boolean hasObject;

    public Tile()
    {
        //this.id = id;
        hasObject = false;
        width = 128;
        height = 128;
        position = new Vector2();
//        rand = new Random();
//        id = 0;
//        hasObject = false;
//        width = Gdx.graphics.getWidth() / 10;
//        height = Gdx.graphics.getHeight() / 10;
//        position = new Vector2(0, 0);
//        //position = new Vector2(Gdx.graphics.getWidth() / width, Gdx.graphics.getHeight() / height);
//        boundary = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
//        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);
//        pixmap.setColor(rand.nextInt());
//        pixmap.fill();
//        texture = new Texture(pixmap);
//        pixmap.dispose();
//        sprite = new Sprite(texture);
//        //sprite.setPosition(position.x, position.y);
//
//        System.out.println("Tile object initialised.");
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render()
    {
        sprite.draw(SimpleGame.batch);
    }

    /*public int getID()
    {
        return id;
    }*/

    public Tile defineTile(int id, int xOffset, int yOffset)
    {
        Tile tile = new Tile();

        switch(id)
        {
            case 0: { tile = new WallTile(xOffset, yOffset); break; }
            case 1: { tile = new FloorTile(xOffset, yOffset); break; }
            default: { System.out.println("No valid Tile ID available."); }
        }

        return tile;
    }
}
