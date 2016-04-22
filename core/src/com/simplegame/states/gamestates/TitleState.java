package com.simplegame.states.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.states.State;
import com.simplegame.states.StateMachine;
import com.simplegame.states.gamestates.PlayState;

/**
 * Created by Carl on 15/04/2016.
 */
public class TitleState extends State
{
    public TitleState(StateMachine stateMachine)
    {
        super(stateMachine);
    }

    @Override
    public void update()
    {
        Gdx.gl.glClearColor(.5f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.X))
        {
            stateMachine.changeState(new PlayState(stateMachine));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("Entered Title state.");
        System.out.println("Press X to change to Play state.\n");
    }

    @Override
    public void exit()
    {
        System.out.println("Left Title state.\n");
    }
}
