package com.simplegame.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.simplegame.gameobjects.GameObject;

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
            obj.objectStateMachine.changeState(new HappyState(obj.objectStateMachine));
        }

        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            obj.objectStateMachine.changeState(new SadState(obj.objectStateMachine));
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
