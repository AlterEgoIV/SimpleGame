package com.simplegame.tiles;

import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tile extends GameObject
{
    protected boolean holdingObject;

    public Tile()
    {
        holdingObject = false;
        width = 128;
        height = 128;
        position = new Vector2();
    }

    @Override
    public void update()
    {

    }

    @Override
    public void render()
    {
        sprite.draw(SimpleGame.batch);
    }

    public Tile defineTile(int id, int xOffset, int yOffset)
    {
        Tile tile = new Tile();

        switch(id)
        {
            case 0: { tile = new WallTile(xOffset, yOffset); break; }
            case 1: { tile = new FloorTile(xOffset, yOffset); break; }
            default: { System.out.println("No valid Tile ID available."); }
        }

        return tile;
    }

    public void handleXAxisCollisions(GameObject obj) {}
    public void handleYAxisCollisions(GameObject obj) {}
}
