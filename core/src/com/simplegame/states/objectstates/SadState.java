package com.simplegame.states.objectstates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.states.State;
import com.simplegame.states.StateMachine;
import com.simplegame.states.objectstates.AngryState;
import com.simplegame.states.objectstates.HappyState;

/**
 * Created by Carl on 22/04/2016.
 */
public class SadState extends State
{
    public SadState(StateMachine stateMachine)
    {
        super(stateMachine);
    }

    @Override
    public void update(GameObject obj)
    {
        obj.getSprite().setColor(Color.BLUE);

        if(Gdx.input.isKeyPressed(Input.Keys.Q))
        {
            obj.getStateMachine().changeState(new HappyState(obj.getStateMachine()));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.E))
        {
            obj.getStateMachine().changeState(new AngryState(obj.getStateMachine()));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("I'm sad...");
    }

    @Override
    public void exit()
    {
        System.out.println("Sadness lifting...\n");
    }
}
