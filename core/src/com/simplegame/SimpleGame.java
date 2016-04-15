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
	public StateMachine stateMachine;
	public SpriteBatch batch;
	//public ArrayList<GameObject> gameObjects;
	//public Tilemap tilemap;

	@Override
	public void create()
	{
		stateMachine = new StateMachine();
		stateMachine.changeState(new TitleState(stateMachine));

		batch = new SpriteBatch();

		//gameObjects = new ArrayList<GameObject>();
		//gameObjects.add(new Player());

		//tilemap = new Tilemap(10, 10);
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		stateMachine.update(batch);

		//tilemap.render(batch);

//		for(GameObject obj : gameObjects)
//		{
//			obj.update();
//			obj.render(batch);
//		}

		batch.end();
	}
}
