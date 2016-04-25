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
        counter = 0;

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

        rows = mapID.length;
        cols = mapID[0].length;

        tile = new Tile[rows][cols];

        System.out.println("The map has " + rows + " rows and " + cols + " columns.");

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new Tile();
                System.out.println("Tile at " + i + " " + j + " created.");
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
