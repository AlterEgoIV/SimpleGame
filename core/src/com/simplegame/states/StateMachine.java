package com.simplegame.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Carl on 15/04/2016.
 */
public class StateMachine
{
    private State state;

    public void update(SpriteBatch batch)
    {
        if(state != null)
        {
            state.update(batch);
        }
    }

    public void changeState(State newState)
    {
        if(state != null)
        {
            state.exit();
        }

        state = newState;

        if(state != null)
        {
            state.enter();
        }
    }
}
