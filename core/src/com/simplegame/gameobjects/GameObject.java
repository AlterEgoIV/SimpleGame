package com.simplegame.gameobjects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;

/**
 * Created by Carl on 07/04/2016.
 */
public abstract class GameObject
{
    protected Vector2 position;
    protected Vector2 direction;
    protected Pixmap pixmap;
    protected Texture texture;
    protected Sprite sprite;
    protected Rectangle boundary;
    protected float width, height;
    protected float speed;

    protected abstract void initialise();
    public abstract void update();
    public abstract void render(SpriteBatch batch);
}
