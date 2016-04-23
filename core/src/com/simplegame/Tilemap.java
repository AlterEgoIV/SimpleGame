package com.simplegame;

import com.simplegame.tiles.Tile;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tilemap
{
    public Tile[][] tile;

    private int rows, cols;

    public Tilemap(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        tile = new Tile[rows][cols];

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                //tile[i][j] = new Tile();
                //tile[i][j].getPosition().x = i * tile[i][j].getWidth();
                //tile[i][j].getPosition().y = j * tile[i][j].getHeight();
                //tile[i][j].getSprite().setPosition(tile[i][j].getPosition().x, tile[i][j].getPosition().y);
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
