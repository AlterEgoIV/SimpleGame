package com.simplegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.gameobjects.GameObject;

import java.awt.Rectangle;
import java.util.Random;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tile extends GameObject
{
    private Random rand;
    private int id;
    private boolean hasObject;

    public Tile()
    {
        rand = new Random();
        id = 0;
        hasObject = false;
        width = Gdx.graphics.getWidth() / 10;
        height = Gdx.graphics.getHeight() / 10;
        position = new Vector2(0, 0);
        //position = new Vector2(Gdx.graphics.getWidth() / width, Gdx.graphics.getHeight() / height);
        boundary = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);
        pixmap.setColor(rand.nextInt());
        pixmap.fill();
        texture = new Texture(pixmap);
        pixmap.dispose();
        sprite = new Sprite(texture);
        //sprite.setPosition(position.x, position.y);

        System.out.println("Tile object initialised.");
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render()
    {
        getSprite().draw(SimpleGame.batch);
    }
}
