package com.simplegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplegame.gameobjects.Enemy;
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
	private StateMachine gameStateMachine;
	public static CollisionHandler collisionHandler;
	public static ArrayList<GameObject> gameObjects;
	public static SpriteBatch batch;
	public static OrthographicCamera camera;

	@Override
	public void create()
	{
		camera = new OrthographicCamera(1280, 720);
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(new Player(0, 0));
		gameObjects.add(new Enemy(120, 120));

		batch = new SpriteBatch();

		collisionHandler = new CollisionHandler();

		// Why can't StateMachine be constructed with an initial State?
		gameStateMachine = new StateMachine(/* new TitleState(stateMachine) */);

		// Why must a StateMachine instance be passed to a new State?
		gameStateMachine.changeState(new TitleState(gameStateMachine));
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		gameStateMachine.update();

		batch.end();
	}
}
