package com.simplegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplegame.gameobjects.GameObject;
import com.simplegame.gameobjects.enemy.Enemy;
import com.simplegame.gameobjects.player.Player;
import com.simplegame.states.StateMachine;
import com.simplegame.states.gamestates.TitleState;

import java.util.ArrayList;

public class SimpleGame extends ApplicationAdapter
{
	/*
  		Can the StateMachine be used appropriately to model States other than object States,
  		such as Game States like Title, Menu, Play, Gameover?
  		What about different levels, like LevelOne, LevelTwo, can they be states?
	*/
	private StateMachine stateMachine;
	public static CollisionHandler collisionHandler;
	public static ArrayList<GameObject> gameObjects;
	public static SpriteBatch batch;
	public static OrthographicCamera camera;
	public static Tilemap tilemap;

	@Override
	public void create()
	{
		camera = new OrthographicCamera(1280, 720);
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add(new Player(0, 0));
		gameObjects.add(new Enemy(120, 120));
		tilemap = new Tilemap(10, 10);

		batch = new SpriteBatch();

		collisionHandler = new CollisionHandler();

		// Why can't StateMachine be constructed with an initial State?
		stateMachine = new StateMachine(/* new TitleState(stateMachine) */);

		// Why must a StateMachine instance be passed to a new State?
		stateMachine.changeState(new TitleState(stateMachine));
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		stateMachine.update();

		batch.end();
	}
}
