package com.entwicklungspark.games.tetris.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.entwicklungspark.games.tetris.Board;
import com.entwicklungspark.games.tetris.TetrisGame;
import com.entwicklungspark.games.tetris.Tetromino;

public class InputHelper {
	
	float oldVertSpeed = TetrisGame.vertSpeed;
	
	public static void getInput(Tetromino tetromino){
		
		if(tetromino.checkCollisionRight() != true){
			
			if(tetromino.getTetrominoSprite().getX()/TetrisGame.GRID + tetromino.getTetrominoShape()[0].length < 10){	
				if(Gdx.input.isKeyJustPressed(Keys.D) || Gdx.input.isKeyJustPressed(Keys.RIGHT)){
					//if(Board.getGameBoard()[(int) tetromino.getTetrominoSprite().getY()/TetrisGame.GRID][(int) tetromino.getTetrominoSprite().getX()/TetrisGame.GRID + 1] == 0){
						TetrisGame.horizTimer = 0;
						tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()+TetrisGame.GRID);
					//}
				}
			}
			
				if(tetromino.getTetrominoSprite().getX()/TetrisGame.GRID + tetromino.getTetrominoShape()[0].length < 10){
					//if(Board.getGameBoard()[(int) tetromino.getTetrominoSprite().getY()/TetrisGame.GRID][(int) tetromino.getTetrominoSprite().getX()/TetrisGame.GRID + 1] == 0){
						if(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)){
							if(TetrisGame.horizTimer > TetrisGame.horizSpeed){
								TetrisGame.horizTimer = 0;
							tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()+TetrisGame.GRID);
						}
					//}
				}
			}
		}else{
			System.out.println("rightCollision");
		}
		if(tetromino.checkCollisionLeft() != true){
		
			if(tetromino.getTetrominoSprite().getX()/TetrisGame.GRID - 1 >= 0){
				if(Gdx.input.isKeyJustPressed(Keys.A) || Gdx.input.isKeyJustPressed(Keys.LEFT)){
					//if(Board.getGameBoard()[(int) tetromino.getTetrominoSprite().getY()/TetrisGame.GRID][(int) tetromino.getTetrominoSprite().getX()/TetrisGame.GRID - 1] == 0){
						TetrisGame.horizTimer = 0;
						tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()-TetrisGame.GRID);
					//}
				}
			}
			
				if(tetromino.getTetrominoSprite().getX()/TetrisGame.GRID - 1 >= 0){
					if(Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)){
						if(TetrisGame.horizTimer > TetrisGame.horizSpeed){
							TetrisGame.horizTimer = 0;
					//	if(Board.getGameBoard()[(int) tetromino.getTetrominoSprite().getY()/TetrisGame.GRID][(int) tetromino.getTetrominoSprite().getX()/TetrisGame.GRID - 1] == 0){
							tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()-TetrisGame.GRID);
						//}
					}
				}
			}
		}
			
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.ENTER) || Gdx.input.isKeyJustPressed(Keys.UP)){
			//System.out.println(tetromino.getRandomShape().getCurrentShape());
			/*
			 * 1 = x x		
			 * 		 x x		
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 1){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getTwoDown())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(11));
					//tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()+TetrisGame.GRID);
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 11){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getTwoUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(1));
					//tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()-TetrisGame.GRID);
				}
			}
			
			/*
			 * 2 =    x x	
			 * 		x x		
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 2){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getsDown())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(21));
					//tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()+TetrisGame.GRID);
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 21){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getsUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(2));
					//tetromino.getTetrominoSprite().setX(tetromino.getTetrominoSprite().getX()-TetrisGame.GRID);
				}
			}
			
			/*
			 * 3 =    x x	
			 * 			x
			 * 			x
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 3){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getSevenRight())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(31));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 31){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getSevenDown())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(32));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 32){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getSevenLeft())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(33));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 33){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getSevenUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(3));
				}
			}
			
			
			/*
			 * 4 =      x x	
			 * 			x
			 * 			x
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 4){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getrRight())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(41));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 41){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getrDown())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(42));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 42){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getrLeft())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(43));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 43){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getrUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(4));
				}
			}
			
			/*
			 * 5 =    x x x	
			 * 			x
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 5){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().gettRight())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(51));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 51){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().gettDown())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(52));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 52){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().gettLeft())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(53));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 53){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().gettUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(5));
				}
			}
			
			/*
			 * 6 =      x	
			 * 			x
			 * 			x
			 * 			x
			 */						
			if(tetromino.getRandomShape().getCurrentShape() == 6){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getLineRight())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(61));
				}
			}else if(tetromino.getRandomShape().getCurrentShape() == 61){
				if(isRotationPossible(tetromino, tetromino.getRandomShape().getLineUp())){
					tetromino.setTetrominoShape(tetromino.getRandomShape().generateRandomShape(6));
				}
			}
		}
		
		
		/*
		 * speed down
		 */
		
		if(Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)){
			TetrisGame.vertSpeed = TetrisGame.downButtonSpeed;
		}else{
			TetrisGame.vertSpeed = 0.5f;
		}
	}
	
	public static boolean isRotationPossible(Tetromino tetromino, int[][] shape){
		return isRotationPossible(tetromino, shape, 0, 0);
	}
	
	public static boolean isRotationPossible(Tetromino tetromino, int[][] shape, int offsetX, int offsetY){
		//if width is ok
		if(tetromino.getTetrominoSprite().getX()/TetrisGame.GRID + shape[0].length < Board.getGameBoard()[0].length+1){
			if(tetromino.getTetrominoSprite().getY()/TetrisGame.GRID + shape.length < Board.getGameBoard().length){
				for(int i = 0; i < shape.length; i++){
					for(int j = 0; j < shape[i].length;j++){
						if(shape[i][j] != 0){
							//System.out.print("y: "+tetromino.getTetrominoSprite().getX() / TetrisGame.GRID + j + ", ");
							if(Board.getGameBoard()[(int) (tetromino.getTetrominoSprite().getY() / TetrisGame.GRID + i)][(int) tetromino.getTetrominoSprite().getX() / TetrisGame.GRID + j] != 0){
								return false;
							}else{
								continue;
							}
						}
					}
				}
				//System.out.print("\n@@@@\n");
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
}
