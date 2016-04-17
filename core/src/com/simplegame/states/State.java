package com.simplegame.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.gameobjects.player.Player;

import java.util.ArrayList;

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
    */
    protected ArrayList<GameObject> gameObjects;

    public State(StateMachine stateMachine)
    {
        this.stateMachine = stateMachine;
        gameObjects = new ArrayList<GameObject>();
        gameObjects.add(new Player());
    }

    public abstract void update(SpriteBatch batch);
    public abstract void enter();
    public abstract void exit();
}
