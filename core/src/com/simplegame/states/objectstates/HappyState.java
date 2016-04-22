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
public class HappyState extends State
{
    public HappyState(StateMachine stateMachine)
    {
        super(stateMachine);
    }

    @Override
    public void update(GameObject obj)
    {
        obj.getSprite().setColor(Color.YELLOW);

        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            obj.getStateMachine().changeState(new SadState(obj.getStateMachine()));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.E))
        {
            obj.getStateMachine().changeState(new AngryState(obj.getStateMachine()));
        }
    }

    @Override
    public void enter()
    {
        System.out.println("I'm happy!");
    }

    @Override
    public void exit()
    {
        System.out.println("Happiness come back!\n");
    }
}
