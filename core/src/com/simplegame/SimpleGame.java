package com.simplegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.gameobjects.player.Player;
import com.simplegame.states.StateMachine;
import com.simplegame.states.TitleState;

import java.util.ArrayList;

public class SimpleGame extends ApplicationAdapter
{
	/*
  		Can the StateMachine be used appropriately to model States other than object States,
  		such as Game States like Title, Menu, Play, Gameover?
  		What about different levels, like LevelOne, LevelTwo, can they be states?
	*/
	public StateMachine stateMachine;
	public static ArrayList<GameObject> gameObjects;
	public SpriteBatch batch;

	@Override
	public void create()
	{
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(new Player());
		// Why can't StateMachine be constructed with an initial State?
		stateMachine = new StateMachine(/* new TitleState(stateMachine) */);

		// Why must a StateMachine instance be passed to a new State?
		stateMachine.changeState(new TitleState(stateMachine));



		batch = new SpriteBatch();
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		/*
			Libgdx question:

			Is it okay to send a SpriteBatch around to different States
		 	so they can manage the rendering of game objects?
		 	A SpriteBatch must be used to draw Textures and Sprites to the screen in Libgdx.
		*/
		stateMachine.update(batch);

		batch.end();
	}
}
