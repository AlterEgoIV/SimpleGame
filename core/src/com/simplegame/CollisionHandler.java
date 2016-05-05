package com.simplegame;

import com.simplegame.gameobjects.GameObject;
import com.simplegame.maps.Map;

/**
 * Created by Carl on 19/04/2016.
 */
public class CollisionHandler
{
    public void handleXAxisCollisions(GameObject obj, Map map)
    {
        for(int i = 0; i < map.getRows(); ++i)
        {
            for(int j = 0; j < map.getCols(); ++j)
            {
                map.getTile(i, j).handleXAxisCollisions(obj);
            }
        }
    }

    public void handleYAxisCollisions(GameObject obj, Map map)
    {
        for(int i = 0; i < map.getRows(); ++i)
        {
            for(int j = 0; j < map.getCols(); ++j)
            {
                map.getTile(i, j).handleYAxisCollisions(obj);
            }
        }
    }
}
