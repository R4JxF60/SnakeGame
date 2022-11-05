package com.snakegame.utils;

public class Position {
	private int positionX;
	private int positionY;
	
	
	public Position(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public boolean equals(Position other) {
		if(other.positionX == this.positionX && other.positionY == this.positionY) {
			return true;
		}
		return false;
	}
}
