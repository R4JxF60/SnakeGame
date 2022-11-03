package com.snakegame.utils;

import java.util.LinkedList;

public class Snake {
	private LinkedList<Block> snakeBody = new LinkedList<Block>();
	private Block head;
	private int direction;
	
	public Snake() {
		this.snakeBody.add(new Block(new Position(2*Block.BLOCK_SIZE, 3*Block.BLOCK_SIZE)));
		this.head = this.snakeBody.getFirst();
		this.direction = Directions.RIGHT;
	}
	
	public LinkedList<Block> getSnakeBody() {
		return this.snakeBody;
	}
	
	public void move() {
		this.snakeBody.add(getNextBlock(this.head));
		this.snakeBody.remove();
		this.head = this.snakeBody.getFirst();
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	private Block getNextBlock(Block currentBlock) {
		Position currentBlockPosition = currentBlock.getPosition();
		
		if(this.direction == Directions.RIGHT) {
			return new Block(new Position(currentBlockPosition.getPositionX()+Block.BLOCK_SIZE, currentBlockPosition.getPositionY()));
		}
		
		if(this.direction == Directions.LEFT) {
			return new Block(new Position(currentBlockPosition.getPositionX()-Block.BLOCK_SIZE, currentBlockPosition.getPositionY()));
		}
		
		if(this.direction == Directions.UP) {
			return new Block(new Position(currentBlockPosition.getPositionX(), currentBlockPosition.getPositionY()-Block.BLOCK_SIZE));
		}
		
		return new Block(new Position(currentBlockPosition.getPositionX(), currentBlockPosition.getPositionY()+Block.BLOCK_SIZE));
	}
	
}
