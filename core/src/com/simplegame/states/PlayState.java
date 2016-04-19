package com.simplegame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;

/**
 * Created by Carl on 15/04/2016.
 */
public class PlayState extends State
{
    public PlayState(StateMachine stateMachine)
    {
        super(stateMachine);
    }

    @Override
    public void update(SpriteBatch batch)
    {
        Gdx.gl.glClearColor(0, 0, .5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(GameObject obj : SimpleGame.gameObjects)
        {
            obj.update();
            obj.render(batch);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.Z))
        {
            stateMachine.changeState(new TitleState(stateMachine));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("Entered Play state.");
        System.out.println("Press Z to change to Title state.");
    }

    @Override
    public void exit()
    {
        System.out.println("Left Play state.\n");
    }
}
