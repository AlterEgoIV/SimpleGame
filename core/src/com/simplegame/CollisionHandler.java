package com.simplegame;

import com.badlogic.gdx.Gdx;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.maps.Map;

/**
 * Created by Carl on 19/04/2016.
 */
public class CollisionHandler
{
    /*public void handleCollisions(GameObject obj)
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
    }*/

    public void handleXAxisCollisions(GameObject obj, Map map)
    {
        for(int i = 0; i < map.getRows(); ++i)
        {
            for(int j = 0; j < map.getCols(); ++j)
            {
                boolean collided = map.getTile(i, j).handleXAxisCollisions(obj);

                if(collided) { break; }
            }
        }
    }

    public void handleYAxisCollisions(GameObject obj, Map map)
    {
        for(int i = 0; i < map.getRows(); ++i)
        {
            for(int j = 0; j < map.getCols(); ++j)
            {
                boolean collided = map.getTile(i, j).handleYAxisCollisions(obj);

                if(collided) { break; }
            }
        }
    }

    public void handleCollisions(GameObject obj, Map map)
    {
        for(int i = 0; i < map.getRows(); ++i)
        {
            for(int j = 0; j < map.getCols(); ++j)
            {
                boolean collided = map.getTile(i, j).checkCollisions(obj);

                if(collided) { break; }
            }
        }
    }
}
