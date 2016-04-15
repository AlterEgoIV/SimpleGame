package com.simplegame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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
                tile[i][j] = new Tile();
                //tile[i][j].position.x = i * tile[i][j].width;
                //tile[i][j].position.y = j * tile[i][j].height;
                //tile[i][j].sprite.setPosition(tile[i][j].position.x, tile[i][j].position.y);
            }
        }
    }

    public void render(SpriteBatch batch)
    {
        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                //tile[i][j].sprite.draw(batch);
            }
        }
    }
}
