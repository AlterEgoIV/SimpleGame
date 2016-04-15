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
    protected StateMachine stateMachine;
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
