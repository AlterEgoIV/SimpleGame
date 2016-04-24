package com.simplegame.maps;

import com.badlogic.gdx.graphics.Color;
import com.simplegame.SimpleGame;
import com.simplegame.tiles.Tile;
import com.simplegame.tiles.WallTile;

/**
 * Created by Carl on 23/04/2016.
 */
public class Map
{
    protected int[][] mapID;
    protected Tile[][] tile;
    private int rows, cols;
    private int counter;

    public Map()
    {
        rows = 10;
        cols = 10;
        counter = 0;

        tile = new Tile[rows][cols];

        mapID = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new Tile();
                int id = mapID[i][j];

                tile[i][j] = tile[i][j].defineTile(id, i, j);

                //tile[i][j].getPosition().x = i * tile[i][j].getWidth();
                //tile[i][j].getPosition().y = j * tile[i][j].getHeight();
                //tile[i][j].getSprite().setPosition(tile[i][j].getPosition().x, tile[i][j].getPosition().y);
            }
        }
    }

    public void update()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                //System.out.println("Tile bounds at position: " + tile[i][j].getBounds().getX() + ", " + tile[i][j].getBounds().getY());

                if(tile[i][j].getBounds().intersects(SimpleGame.gameObjects.get(counter).getBounds()))
                {
                    tile[i][j].setHoldingObject(true);
                    tile[i][j].getSprite().setColor(Color.SCARLET);
                    //System.out.println("Object at position: " + tile[i][j].getPosition().x + ", " + tile[i][j].getPosition().y);
                    //System.out.println("Object at position: " + SimpleGame.gameObjects.get(counter).getSprite().getX() + ", " + SimpleGame.gameObjects.get(counter).getSprite().getY());
                }
                else
                {
                    tile[i][j].setHoldingObject(false);
                    tile[i][j].getSprite().setColor(Color.WHITE);
                }

                counter++;

                if(counter == SimpleGame.gameObjects.size() - 1) { counter = 0; }
            }
        }
    }

    public void render()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j].getSprite().draw(SimpleGame.batch);
            }
        }
    }
}
