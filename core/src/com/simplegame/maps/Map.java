package com.simplegame.maps;

import com.simplegame.tiles.Tile;

/**
 * Created by Carl on 23/04/2016.
 */
public class Map
{
    protected int[][] tileID;
    protected Tile[][] tile;
    private int rows;
    private int cols;

    public Map()
    {
        tileID = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                             {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        rows = tileID.length;
        cols = tileID[0].length;

        tile = new Tile[rows][cols];

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new Tile();
                System.out.println("Tile at " + i + " " + j + " created.");
                int id = tileID[i][j];

                tile[i][j] = tile[i][j].defineTile(id, i, j);
            }
        }
    }

    public void render()
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j].render();
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
