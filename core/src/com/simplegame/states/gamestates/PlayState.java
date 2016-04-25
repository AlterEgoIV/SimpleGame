package com.simplegame.states.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.simplegame.SimpleGame;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.states.State;
import com.simplegame.states.StateMachine;

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
    public void update()
    {
        Gdx.gl.glClearColor(0, 0, .5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SimpleGame.map.render();

        for(GameObject obj : SimpleGame.gameObjects)
        {
            obj.update();
            SimpleGame.map.update();
            //SimpleGame.collisionHandler.handleCollisions(obj);
            obj.render();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.Z))
        {
            stateMachine.changeState(new TitleState(stateMachine));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.C))
        {
            stateMachine.changeState(new BattleState(stateMachine));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("Entered Play state.");
        System.out.println("Press Z to change to Title state.");
        System.out.println("Press C to change to Battle state.\n");
    }

    @Override
    public void exit()
    {
        System.out.println("Left Play state.\n");
    }
}
