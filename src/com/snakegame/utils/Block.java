package com.snakegame.utils;

public class Block {
	
	public final static int BLOCK_SIZE = 16;
	
	private Position position;
	
	public Block(Position position) {
		this.position = position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
}
