package com.simplegame.maps;

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

    public Map()
    {
        rows = 5;
        cols = 5;

        tile = new Tile[rows][cols];

        mapID = new int[][]{{0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 0},
                            {0, 1, 1, 1, 0},
                            {0, 1, 1, 1, 0},
                            {0, 0, 0, 0, 0}};

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new Tile();
                int id = mapID[i][j];

                tile[i][j] = tile[i][j].defineTile(id);

                tile[i][j].getPosition().x = i * tile[i][j].getWidth();
                tile[i][j].getPosition().y = j * tile[i][j].getHeight();
                tile[i][j].getSprite().setPosition(tile[i][j].getPosition().x, tile[i][j].getPosition().y);
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
