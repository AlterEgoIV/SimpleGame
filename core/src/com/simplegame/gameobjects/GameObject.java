package com.simplegame.gameobjects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.states.StateMachine;

import java.awt.Rectangle;

/**
 * Created by Carl on 07/04/2016.
 */
public abstract class GameObject
{
    protected StateMachine stateMachine;
    protected Vector2 position;
    protected Pixmap pixmap;
    protected Texture texture;
    protected Sprite sprite;
    protected Rectangle bounds;
    protected float width;
    protected float height;
    protected float speed;

    public GameObject()
    {
        stateMachine = new StateMachine();
    }

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

    public StateMachine getStateMachine()
    {
        return stateMachine;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }
}
