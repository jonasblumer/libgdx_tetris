package com.entwicklungspark.games.tetris;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.entwicklungspark.games.tetris.helpers.TetrominoShapes;

public class Tetromino {
	private Texture red, blue, green, orange, pink, yellow, grey;
	private Sprite tetrominoSprite;
	private TetrominoShapes randomShape = new TetrominoShapes();
	public TetrominoShapes getRandomShape() {
		return randomShape;
	}


	public void setRandomShape(TetrominoShapes randomShape) {
		this.randomShape = randomShape;
	}


	private int[][] tetrominoShape;
	
	


	public Tetromino(){
		
		tetrominoSprite = new Sprite();
		red = new Texture("square_16x16.png");
		blue = new Texture("square_16x16_blue.png");
		green = new Texture("square_16x16_green.png");
		orange = new Texture("square_16x16_orange.png");
		pink = new Texture("square_16x16_pink.png");
		yellow = new Texture("square_16x16_yellow.png");
		grey = new Texture("square_16x16_grey.png");
		
		tetrominoSprite.setTexture(red);
		//tetrominoSprite.setSize(img.getWidth(), img.getHeight());
		
		tetrominoSprite.setOriginCenter();
		tetrominoSprite.setSize(TetrisGame.GRID, TetrisGame.GRID);
		this.reset();
	}
	

	public void reset(){
		tetrominoSprite.setPosition(Board.getGameBoard()[0].length/2*TetrisGame.GRID-TetrisGame.GRID, 0);
		tetrominoShape = randomShape.generateRandomShape();
		System.out.println(randomShape.getCurrentShape());
	}
	
	public Boolean checkCollisionLeft(){
		for(int i = 0; i < tetrominoShape.length; i++){
			for(int j = 0; j < tetrominoShape[i].length; j++){
				if(tetrominoShape[i][j] != 0){
					if(tetrominoSprite.getX() / TetrisGame.GRID - 1 + j > 0){
						if(Board.getGameBoard()[(int) (tetrominoSprite.getY() / TetrisGame.GRID + i)][(int) tetrominoSprite.getX() / TetrisGame.GRID -1 + j] != 0){
							System.out.println("COLLISION");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	public Boolean checkCollisionRight(){
		for(int i = 0; i < tetrominoShape.length; i++){
			for(int j = 0; j < tetrominoShape[i].length; j++){
				if(tetrominoShape[i][j] != 0){
					if(tetrominoSprite.getX() / TetrisGame.GRID + 1 + j < 10){
						if(Board.getGameBoard()[(int) (tetrominoSprite.getY() / TetrisGame.GRID + i)][(int) tetrominoSprite.getX() / TetrisGame.GRID +1 + j] != 0){
							System.out.println("COLLISION");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	public void update(){
		//System.out.println("j: " + tetrominoShape[0].length+ ", i:" +tetrominoShape.length);
		if(TetrisGame.vertTimer > TetrisGame.vertSpeed){
			TetrisGame.vertTimer = 0;
			for(int i = 0; i < tetrominoShape.length; i++){
				for(int j = 0; j < tetrominoShape[i].length; j++){
					if(tetrominoShape[i][j] != 0){
						if((Board.getGameBoard().length > tetrominoSprite.getY() / TetrisGame.GRID + 1 + i)){
							if(Board.getGameBoard()[(int) (tetrominoSprite.getY() / TetrisGame.GRID + 1 + i)][(int) tetrominoSprite.getX() / TetrisGame.GRID + j] != 0){
								//Board.setGameBoard((int) (tetrominoSprite.getX() / TetrisGame.GRID), (int) (tetrominoSprite.getY() / TetrisGame.GRID ));
								drawAll();
								this.reset();
								break;
							}
						}else{
							
							//Board.setGameBoard((int)tetrominoSprite.getX()/TetrisGame.GRID, (int)tetrominoSprite.getY()/TetrisGame.GRID);
							drawAll();
							this.reset();
							break;
								
						}
					}
				}
			}
			tetrominoSprite.setY(tetrominoSprite.getY()+TetrisGame.GRID);
		}
	}
	
	public int[][] getTetrominoShape() {
		return tetrominoShape;
	}


	public void setTetrominoShape(int[][] tetrominoShape) {
		this.tetrominoShape = tetrominoShape;
	}


	private void drawAll(){
		for(int i = 0; i < tetrominoShape.length; i++){
			for(int j = 0; j < tetrominoShape[i].length; j++){
				if(tetrominoShape[i][j] != 0){
					Board.setGameBoard((int)tetrominoSprite.getX()/TetrisGame.GRID + j, (int)tetrominoSprite.getY()/TetrisGame.GRID + i, randomShape.getCurrentShape());
				}
			}
		}
	}
	
	public void draw(SpriteBatch batch){
		/*
		 * draw falling
		 */
		for(int i = 0; i < tetrominoShape.length; i++){
			for(int j = 0; j < tetrominoShape[i].length; j++){
				if(tetrominoShape[i][j] != 0){
					int colorInt = randomShape.getCurrentShape();
					String colorString = String.valueOf(randomShape.getCurrentShape());
					String[] colorArray;
					if(colorString.length()>1){
						colorArray = colorString.split("(?!^)");
						colorInt = Integer.parseInt(colorArray[0]);
					}
					Texture color = null;
					switch(colorInt){
					case 1:
						color = red;
						break;
					case 2:
						color = blue;
						break;
					case 3:
						color = green;
						break;
					case 4:
						color = orange;
						break;
					case 5:
						color = pink;
						break;
					case 6:
						color = yellow;
						break;
					case 7:
						color = grey;
						break;
					}
					batch.draw(color, tetrominoSprite.getX()+j*TetrisGame.GRID, tetrominoSprite.getY()+i*TetrisGame.GRID);
				}
			}
		}
		/*
		 * draw landed
		 */
		for(int i = 0; i < Board.getGameBoard().length; i++){
			for(int j = 0; j < Board.getGameBoard()[i].length; j++){
				if(Board.getGameBoard()[i][j]!=0){
					Texture color = null;
					switch(Board.getGameBoard()[i][j]){
					case 1:
						color = red;
						break;
					case 2:
						color = blue;
						break;
					case 3:
						color = green;
						break;
					case 4:
						color = orange;
						break;
					case 5:
						color = pink;
						break;
					case 6:
						color = yellow;
						break;
					case 7:
						color = grey;
						break;
					}
					
					batch.draw(color, j*TetrisGame.GRID, i*TetrisGame.GRID);
				}
			}
		}
		
	}
	
	public Sprite getTetrominoSprite() {
		return tetrominoSprite;
	}
	

	public void setTetrominoSprite(Sprite tetrominoSprite) {
		this.tetrominoSprite = tetrominoSprite;
	}

}
