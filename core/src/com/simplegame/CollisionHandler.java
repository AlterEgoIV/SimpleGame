package com.simplegame;

import com.badlogic.gdx.Gdx;
import com.simplegame.gameobjects.GameObject;

/**
 * Created by Carl on 19/04/2016.
 */
public class CollisionHandler
{
    public void handleCollisions(GameObject obj)
    {
        if(obj.getSprite().getX() < 0)
        {
            obj.getSprite().translateX(obj.getSpeed());
        }

        if(obj.getSprite().getX() > Gdx.graphics.getWidth() - obj.getWidth())
        {
            obj.getSprite().translateX(-obj.getSpeed());
        }

        if(obj.getSprite().getY() < 0)
        {
            obj.getSprite().translateY(obj.getSpeed());
        }

        if(obj.getSprite().getY() > Gdx.graphics.getHeight() - obj.getHeight())
        {
            obj.getSprite().translateY(-obj.getSpeed());
        }
    }
}
