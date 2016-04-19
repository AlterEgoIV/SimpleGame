package com.simplegame.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;

/**
 * Created by Carl on 19/04/2016.
 */
public class Enemy extends GameObject
{
    public Enemy(float x, float y)
    {
        initialise(x, y);
    }

    @Override
    protected void initialise()
    {

    }

    @Override
    protected void initialise(float x, float y)
    {
        width = 100.0f;
        height = 100.0f;
        speed = 10.0f;

        //position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        position = new Vector2(x, y);

        pixmap = new Pixmap((int)getWidth(), (int)getHeight(), Pixmap.Format.RGBA8888);

        pixmap.setColor(1, 1, 1, 0);
        pixmap.fill();
        pixmap.setColor(Color.FIREBRICK);
        pixmap.fillCircle(pixmap.getWidth() / 2 - 1, pixmap.getHeight() / 2 - 1, (int)getWidth() / 2 - 1);

        texture = new Texture(pixmap);
        pixmap.dispose();

        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setPosition(position.x - width / 2, position.y - height / 2);
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
