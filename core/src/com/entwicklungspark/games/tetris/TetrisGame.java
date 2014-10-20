package com.entwicklungspark.games.tetris;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.entwicklungspark.games.tetris.helpers.InputHelper;

public class TetrisGame extends Game implements ApplicationListener{
	SpriteBatch batch;
	Camera camera;
	Camera hudCamera;
	Tetromino tetromino;
	Viewport viewport;
	Viewport viewportHud;
	Texture background;
	Texture hudTest;
	BitmapFont font;
	
	public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int HUD_WIDTH = 360;
	
	public static int SCORE = 0;
	
	public static int GRID = 16;
	public static float horizSpeed = 0.1f, vertSpeed = 0.5f, downButtonSpeed = 0.08f;
	public static float vertTimer = 0, horizTimer = 0;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		
		background = new Texture("grey.png");
		hudTest = new Texture("hud.png");
		
		tetromino = new Tetromino();
		
		camera= new OrthographicCamera(160, 320);
		((OrthographicCamera) camera).setToOrtho(true, 160, 320);
		camera.translate(new Vector3(0, 2*GRID, 0));
		camera.update();
		
		hudCamera= new OrthographicCamera(160, 320);
		((OrthographicCamera) hudCamera).setToOrtho(false, 160, 320);
		hudCamera.translate(new Vector3(0, 2*GRID, 0));
		hudCamera.update();
		
		viewport = new FitViewport(160, 320);
		viewport.setScreenPosition(-100, 0);
		viewport.update(160, 320);
		viewportHud = new FitViewport(HUD_WIDTH, 320);
		viewportHud.setScreenPosition(-100, 0);
		
		font = new BitmapFont();
		font.setScale(0.5f);
		font.setColor(1f, 0f, 0f, 1f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(.1f, .84f, .84f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		vertTimer += Gdx.graphics.getDeltaTime();
		horizTimer += Gdx.graphics.getDeltaTime();
		viewportHud.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewportHud.setCamera(camera);
		
		batch.setProjectionMatrix(hudCamera.combined);
		batch.begin();
			batch.draw(hudTest, -100, 0, HUD_WIDTH, Gdx.graphics.getHeight());
			font.draw(batch, "Points", 0, 350);
			font.draw(batch, "  "+SCORE, 0, 330);
		batch.end();
		
		viewport.setCamera(camera);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
			batch.draw(background, 0, 2*GRID);
			tetromino.draw(batch);
		batch.end();
		
	
		
		InputHelper.getInput(tetromino);
		
		tetromino.update();
		
	}
	
	public void resize(int width, int height){
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
}

