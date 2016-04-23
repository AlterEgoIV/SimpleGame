package com.simplegame;

/**
 * Created by Carl on 10/04/2016.
 */
public class Tilemap
{
    public com.simplegame.tiles.Tile[][] tile;

    private int rows, cols;

    public Tilemap(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        tile = new com.simplegame.tiles.Tile[rows][cols];

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < cols; ++j)
            {
                tile[i][j] = new com.simplegame.tiles.Tile();
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
