package com.simplegame.states;

import com.simplegame.gameobjects.GameObject;

/**
 * Created by Carl on 15/04/2016.
 */
public abstract class State
{
    // Why does State hold a StateMachine?
    protected StateMachine stateMachine;

    /*
        Is it okay for a State to manage game objects? What about only certain types of
        objects depending on the Game State? For example, PlayState might only manage Player, Enemy,
        Projectile etc, objects. However, this would mean creating ArrayLists of certain sets
        of objects for different States. I'm not sure if that would be good practice.

        Answer:
        No. Let the main class hold the ArrayList of objects. To access them from the
        State classes, make the ArrayList static.
    */

    public State(StateMachine stateMachine)
    {
        this.stateMachine = stateMachine;
    }

    public void update() {}
    public void update(GameObject obj) {}
    public abstract void enter();
    public abstract void exit();
}
