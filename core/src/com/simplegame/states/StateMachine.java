package com.simplegame.states;

import com.simplegame.gameobjects.GameObject;

/**
 * Created by Carl on 15/04/2016.
 */
public class StateMachine
{
    private State state;

    /*
        public StateMachine(State state)
        {
            this.state = state; // Would set the initial State
        }
    */

    public void update()
    {
        if(state != null)
        {
            state.update();
        }
    }

    public void update(GameObject obj)
    {
        if(state != null)
        {
            state.update(obj);
        }
    }

    /*
        When changing to a new Game State, the state of objects being managed by
        the previous State is lost. This sets them back to their default state when you return to the
        State they are managed in. How can this be avoided? Is it possible for objects to maintain
        their state independent of Game State?
    */
    public void changeState(State newState)
    {
        if(state != null)
        {
            state.exit(); // Call exit() on previous State
        }

        state = newState; // Set new State

        if(state != null)
        {
            state.enter(); // Call enter() on new State
        }
    }
}
