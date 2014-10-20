package com.entwicklungspark.games.tetris;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;


public class Board {
	 private static int[][] gameBoard = new int[22][10];
	public static void setGameBoard(int x, int y, int color){
		String colorString = String.valueOf(color);
		String[] colorArray;
		if(colorString.length()>1){
			colorArray = colorString.split("(?!^)");
			color = Integer.parseInt(colorArray[0]);
		}
		gameBoard[y][x] = color;
		log();
		checkFullLines();
		checkGameOver();
	}
	
	private static void checkGameOver(){
		for(int i = 0; i < gameBoard[0].length; i++){
			if(gameBoard[0][i] != 0){
				Gdx.app.exit();
			}
		}
	}
	
	private static void checkFullLines(){
		int hitCount = 0;
		
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				if(gameBoard[i][j] != 0){
					hitCount++;
				}
				if(hitCount == 10){
					System.out.println("GOT A ROW!");
					TetrisGame.SCORE += 40;
					clearRow(i);
				}
			}
			hitCount = 0;
		}
		
		
	}
	
	private static void clearRow(int row){
		for(int i = 0; i < gameBoard[row].length; i++){
			gameBoard[row][i] = 0;
		}
		
		for(int i = 0; i < gameBoard[0].length; i++){ 
			gameBoard[0][i] = 0;
		} 
		
		for(int i = 0; i < gameBoard[0].length; i++){
			for(int j = row; j > 1; j--){
				System.out.print(gameBoard[j][i]);
				gameBoard[j][i]=gameBoard[j-1][i];
				
			}
		}
		System.out.println(row);
	}
	
	public static int[][] getGameBoard() {
		return gameBoard;
	}

	


	public static void log(){
		System.out.println("@@@@@@@@@@@@@@@@@@");
		for (int[] arr : gameBoard) {
            System.out.println(Arrays.toString(arr));
        }
	}
	
	public static void getLanded(){
		for(int i = 0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				if(gameBoard[i][j] != 0){
					System.out.println("i:"+i);
				}
			}
		}
	}
	
}
