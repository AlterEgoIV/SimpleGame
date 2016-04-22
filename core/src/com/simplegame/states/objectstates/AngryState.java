package com.simplegame.states.objectstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.states.State;
import com.simplegame.states.StateMachine;

/**
 * Created by Carl on 22/04/2016.
 */
public class AngryState extends State
{
    public AngryState(StateMachine stateMachine)
    {
        super(stateMachine);
    }

    @Override
    public void update(GameObject obj)
    {
        obj.getSprite().setColor(Color.RED);

        if(Gdx.input.isKeyPressed(Input.Keys.Q))
        {
            obj.getStateMachine().changeState(new HappyState(obj.getStateMachine()));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            obj.getStateMachine().changeState(new SadState(obj.getStateMachine()));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("Grr! I'm Angry!");
    }

    @Override
    public void exit()
    {
        System.out.println("Anger fading...\n");
    }
}
