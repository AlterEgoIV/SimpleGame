package com.simplegame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;

import java.awt.Rectangle;
import java.util.Random;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tile extends GameObject
{
    protected boolean holdingObject;
    protected boolean leftSideColliding;
    protected boolean rightSideColliding;
    protected boolean topSideColliding;
    protected boolean bottomSideColliding;

    public Tile()
    {
        holdingObject = false;
        leftSideColliding = false;
        rightSideColliding = false;
        topSideColliding = false;
        bottomSideColliding = false;
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
        //sprite.draw(SimpleGame.batch);
        //rectSprite.draw(SimpleGame.batch);
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

    public boolean checkCollisions(GameObject obj) { return false; }
    public boolean handleXAxisCollisions(GameObject obj) { return false; }
    public boolean handleYAxisCollisions(GameObject obj) { return false; }

    public boolean isHoldingObject()
    {
        return holdingObject;
    }

    public void setHoldingObject(boolean holdingObject)
    {
        this.holdingObject = holdingObject;
    }
}
