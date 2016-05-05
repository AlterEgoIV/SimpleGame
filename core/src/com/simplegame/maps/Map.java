package com.simplegame.maps;

import com.simplegame.SimpleGame;
import com.simplegame.tiles.Tile;

/**
 * Created by Carl on 23/04/2016.
 */
public class Map
{
    protected int[][] mapID;
    protected Tile[][] tile;
    private int rows;
    private int cols;

    public Map()
    {
        mapID = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        rows = mapID.length;
        cols = mapID[0].length;

        tile = new Tile[rows][cols];

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new Tile();
                System.out.println("Tile at " + i + " " + j + " created.");
                int id = mapID[i][j];

                tile[i][j] = tile[i][j].defineTile(id, i, j);
            }
        }
    }

    /*public void update()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                //System.out.println("Tile bounds at position: " + tile[i][j].getBounds().getX() + ", " + tile[i][j].getBounds().getY());

                tile[i][j].checkCollisions(counter);

                // Adjust counter appropriately
                if(SimpleGame.gameObjects.size() > 1)
                {
                    counter++;

                    if(counter == SimpleGame.gameObjects.size() - 1)
                    {
                        counter = 0;
                    }
                }
            }
        }
    }*/

    public void render()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j].getSprite().draw(SimpleGame.batch);
                //tile[i][j].getRectSprite().draw(SimpleGame.batch);
                //tile[i][j].getRectSprite();
            }
        }
    }

    public int getRows()
    {
        return rows;
    }

    public int getCols()
    {
        return cols;
    }

    public Tile getTile(int i, int j)
    {
        return tile[i][j];
    }
}
