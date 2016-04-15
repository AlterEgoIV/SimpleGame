package com.simplegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.simplegame.SimpleGame;

public class DesktopLauncher
{
	public static void main(String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Simple Game";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new SimpleGame(), config);
	}
}
