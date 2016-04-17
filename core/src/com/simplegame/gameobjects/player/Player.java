package com.simplegame.gameobjects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.gameobjects.GameObject;


/**
 * Created by Carl on 07/04/2016.
 */
public class Player extends GameObject
{
    public Player()
    {
        initialise();
    }

    @Override
    protected void initialise()
    {
        width = 100.0f;
        height = 100.0f;
        speed = 10.0f;

        position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        direction = new Vector2(1, 0);
        pixmap = new Pixmap((int)width, (int)height, Pixmap.Format.RGBA8888);

        pixmap.setColor(1, 1, 1, 0);
        pixmap.fill();
        pixmap.setColor(Color.FOREST);
        pixmap.fillCircle(pixmap.getWidth() / 2 - 1, pixmap.getHeight() / 2 - 1, (int) width / 2 - 1);

        texture = new Texture(pixmap);
        pixmap.dispose();

        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setPosition(position.x - width / 2, position.y - height / 2);
    }

    @Override
    public void update()
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            sprite.translateY(speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            sprite.translateY(-speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            sprite.translateX(-speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            sprite.translateX(speed);
        }
    }
}
