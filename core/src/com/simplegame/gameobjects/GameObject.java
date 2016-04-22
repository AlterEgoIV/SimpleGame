package com.simplegame.gameobjects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.states.StateMachine;

import java.awt.Rectangle;

/**
 * Created by Carl on 07/04/2016.
 */
public abstract class GameObject
{
    public StateMachine objectStateMachine;
    protected Vector2 position;
    protected Pixmap pixmap;
    protected Texture texture;
    protected Sprite sprite;
    protected Rectangle boundary;
    protected float width;
    protected float height;
    protected float speed;

    public GameObject()
    {
        objectStateMachine = new StateMachine();
    }

    protected abstract void initialise();
    protected abstract void initialise(float x, float y);
    public abstract void update();
    public abstract void render();

    public Sprite getSprite()
    {
        return sprite;
    }

    public float getWidth()
    {
        return width;
    }

    public float getHeight()
    {
        return height;
    }

    public float getSpeed()
    {
        return speed;
    }

    public Vector2 getPosition()
    {
        return position;
    }
}
