package com.simplegame.maps;

import com.simplegame.tiles.Tile;

/**
 * Created by Carl on 23/04/2016.
 */
public class Map
{
    protected int[][] mapIDs;
    protected Tile[][] tiles;

    public Map()
    {
        mapIDs = new int[][]{{0, 0, 0, 0, 0},
                             {0, 1, 1, 1, 0},
                             {0, 1, 1, 1, 0},
                             {0, 1, 1, 1, 0},
                             {0, 0, 0, 0, 0}};
    }
}
