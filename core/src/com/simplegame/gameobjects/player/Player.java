package com.simplegame.gameobjects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.states.objectstates.HappyState;

import java.awt.Rectangle;

/**
 * Created by Carl on 07/04/2016.
 */
public class Player extends GameObject
{
    public Player(float x, float y)
    {
        stateMachine.changeState(new HappyState(stateMachine));

        width = 100.0f;
        height = 100.0f;
        speed = 10.0f;
        position = new Vector2(x, y);

        pixmap = new Pixmap((int)getWidth(), (int)getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 1, 1, 0);
        pixmap.fill();
        pixmap.setColor(Color.WHITE);
        pixmap.fillCircle(pixmap.getWidth() / 2 - 1, pixmap.getHeight() / 2 - 1, (int)getWidth() / 2 - 1);

        texture = new Texture(pixmap);
        //pixmap.dispose();

        sprite = new Sprite(texture);
        sprite.setOriginCenter();
        sprite.setPosition(position.x - width / 2, position.y - height / 2);

        pixmap.setColor(0, 0, 1, .5f);
        pixmap.fill();

        texture = new Texture(pixmap);
        pixmap.dispose();

        rectSprite = new Sprite(texture);

        bounds = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
        rectSprite.setPosition((float)bounds.getX(), (float)bounds.getY());
    }

    @Override
    public void update()
    {
        stateMachine.update(this);

        handleXAxisInput();
        SimpleGame.collisionHandler.handleXAxisCollisions(this, SimpleGame.map);
        handleYAxisInput();
        SimpleGame.collisionHandler.handleYAxisCollisions(this, SimpleGame.map);

        SimpleGame.camera.position.set(sprite.getX() + width / 2, sprite.getY() + height / 2, 0);
        SimpleGame.camera.update();
    }

    @Override
    public void render()
    {
        rectSprite.draw(SimpleGame.batch);
        getSprite().draw(SimpleGame.batch);
    }

    private void handleXAxisInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            getSprite().translateX(-speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            getSprite().translateX(speed);
        }

        bounds.setLocation((int)sprite.getX(), (int)sprite.getY());
        rectSprite.setPosition((float)bounds.getX(), (float)bounds.getY());
    }

    private void handleYAxisInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            getSprite().translateY(speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            getSprite().translateY(-speed);
        }

        bounds.setLocation((int)sprite.getX(), (int)sprite.getY());
        rectSprite.setPosition((float)bounds.getX(), (float)bounds.getY());
    }

    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            getSprite().translateY(speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            getSprite().translateY(-speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            getSprite().translateX(-speed);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            getSprite().translateX(speed);
        }

        bounds.setLocation((int)sprite.getX(), (int)sprite.getY());
        rectSprite.setPosition((float)bounds.getX(), (float)bounds.getY());
    }
}
