package com.entwicklungspark.games.tetris.helpers;

import com.badlogic.gdx.math.MathUtils;

public class TetrominoShapes {
	
	private int currentShape;
	
	/*
	 * 
	 */
	private int[][] twoUp = 	{ 	// 1
			{1, 1, 0},
			{0, 1, 1},
		};
	private int[][] twoDown = 	{	// 11
			{0, 1},
			{1, 1},
			{1, 0}
		};
	/*
	 * 
	 */
	private int[][] sUp = 	{	// 2
			{0, 1, 1},
			{1, 1, 0},
		};
	private int[][] sDown = {	// 21
			{1, 0},
			{1, 1},
			{0, 1}
		};
	/*
	 * 
	 */
	private int[][] sevenUp = 	{ 	// 3
			{1, 1},
			{0, 1},
			{0, 1}
		};
	private int[][] sevenRight = 	{	//31
			{0, 0, 1},
			{1, 1, 1}
		};
	private int[][] sevenDown = 	{	//32
			{1, 0},
			{1, 0},
			{1, 1}
		};
	private int[][] sevenLeft = 	{	//33
			{1, 1, 1},
			{1, 0, 0}
		};
	/*
	 * 
	 */
	private int[][] rUp = 	{	// 4
			{1, 1},
			{1, 0},
			{1, 0}
		};
	private int[][] rRight = 	{	// 41
			{1, 1, 1},
			{0, 0, 1}
		};
	private int[][] rDown = 	{ 	// 42
			{0, 1},
			{0, 1},
			{1, 1}
		};
	private int[][] rLeft = 	{	// 43
			{1, 0, 0},
			{1, 1, 1}
		};
	/*
	 * 
	 */
	private static int[][] tUp = 	{	// 5
			{1, 1, 1},
			{0, 1, 0}
		};
	private static int[][] tRight = 	{	// 51
			{0, 1},
			{1, 1},
			{0, 1}
		};
	private static int[][] tDown = 	{	// 52
			{0, 1, 0},
			{1, 1, 1}
		};
	private static int[][] tLeft = 	{	// 53
			{1, 0},
			{1, 1},
			{1, 0}
		};
	/*
	 * 
	 */
	private int[][] lineUp = 	{	// 6
			{1},
			{1},
			{1},
			{1}
		};
	private int[][] lineRight = 	{	// 61
			{1, 1, 1, 1}
		};
	/*
	 * 
	 */
	private int[][] cube = 	{	// 7
			{1, 1},
			{1, 1}
		};
	
	
	
	public int[][] generateRandomShape(){
		
		switch (MathUtils.random(1, 7)){
			case 1:
				currentShape = 1;
				return twoUp;
			case 2:
				currentShape = 2;
				return sUp;
			case 3:
				currentShape = 3;
				return sevenUp;
			case 4:
				currentShape = 4;
				return rUp;	
			case 5:
				currentShape = 5;
				return tUp;		
			case 6:
				currentShape = 6;
				return lineUp;	
			case 7:
				currentShape = 7;
				return cube;	
			default:
				return null;
		}

	}
	
	
	public int[][] generateRandomShape(int i){
			
		switch (i){
			case 1:
				currentShape = 1;
				return twoUp;
			case 11:
				currentShape = 11;
				return twoDown;
			case 2:
				currentShape = 2;
				return sUp;
			case 21:
				currentShape = 21;
				return sDown;
			case 3:
				currentShape = 3;
				return sevenUp;
			case 31:
				currentShape = 31;
				return sevenRight;
			case 32:
				currentShape = 32;
				return sevenDown;
			case 33:
				currentShape = 33;
				return sevenLeft;
			case 4:
				currentShape = 4;
				return rUp;	
			case 41:
				currentShape = 41;
				return rRight;		
			case 42:
				currentShape = 42;
				return rDown;		
			case 43:
				currentShape = 43;
				return rLeft;	
			case 5:
				currentShape = 5;
				return tUp;		
			case 51:
				currentShape = 51;
				return tRight;		
			case 52:
				currentShape = 52;
				return tDown;
			case 53:
				currentShape = 53;
				return tLeft;
			case 6:
				currentShape = 6;
				return lineUp;	
			case 61:
				currentShape = 61;
				return lineRight;
			case 7:
				currentShape = 7;
				return cube;	
			default:
				return null;
		}
	}

	public int getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(int currentShape) {
		this.currentShape = currentShape;
	}
	
	public int[][] getTwoUp() {
		return twoUp;
	}

	public void setTwoUp(int[][] twoUp) {
		this.twoUp = twoUp;
	}

	public int[][] getTwoDown() {
		return twoDown;
	}

	public void setTwoDown(int[][] twoDown) {
		this.twoDown = twoDown;
	}

	public int[][] getsUp() {
		return sUp;
	}

	public void setsUp(int[][] sUp) {
		this.sUp = sUp;
	}

	public int[][] getsDown() {
		return sDown;
	}

	public void setsDown(int[][] sDown) {
		this.sDown = sDown;
	}

	public int[][] getSevenUp() {
		return sevenUp;
	}

	public void setSevenUp(int[][] sevenUp) {
		this.sevenUp = sevenUp;
	}

	public int[][] getSevenRight() {
		return sevenRight;
	}

	public void setSevenRight(int[][] sevenRight) {
		this.sevenRight = sevenRight;
	}

	public int[][] getSevenDown() {
		return sevenDown;
	}

	public void setSevenDown(int[][] sevenDown) {
		this.sevenDown = sevenDown;
	}

	public int[][] getSevenLeft() {
		return sevenLeft;
	}

	public void setSevenLeft(int[][] sevenLeft) {
		this.sevenLeft = sevenLeft;
	}

	public int[][] getrUp() {
		return rUp;
	}

	public void setrUp(int[][] rUp) {
		this.rUp = rUp;
	}

	public int[][] getrRight() {
		return rRight;
	}

	public void setrRight(int[][] rRight) {
		this.rRight = rRight;
	}

	public int[][] getrDown() {
		return rDown;
	}

	public void setrDown(int[][] rDown) {
		this.rDown = rDown;
	}

	public int[][] getrLeft() {
		return rLeft;
	}

	public void setrLeft(int[][] rLeft) {
		this.rLeft = rLeft;
	}

	public static int[][] gettUp() {
		return tUp;
	}

	public void settUp(int[][] tUp) {
		this.tUp = tUp;
	}

	public static int[][] gettRight() {
		return tRight;
	}

	public void settRight(int[][] tRight) {
		this.tRight = tRight;
	}

	public static int[][] gettDown() {
		return tDown;
	}

	public void settDown(int[][] tDown) {
		this.tDown = tDown;
	}

	public static int[][] gettLeft() {
		return tLeft;
	}

	public void settLeft(int[][] tLeft) {
		this.tLeft = tLeft;
	}

	public int[][] getLineUp() {
		return lineUp;
	}

	public void setLineUp(int[][] lineUp) {
		this.lineUp = lineUp;
	}

	public int[][] getLineRight() {
		return lineRight;
	}

	public void setLineRight(int[][] lineRight) {
		this.lineRight = lineRight;
	}

	public int[][] getCube() {
		return cube;
	}

	public void setCube(int[][] cube) {
		this.cube = cube;
	}
}
