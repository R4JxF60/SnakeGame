package com.snakegame.utils;

import java.util.LinkedList;
import java.util.Random;

import com.snakegame.game.GameWindow;

public class Snake {
	private LinkedList<Block> snakeBody = new LinkedList<Block>();
	private Block head;
	private int direction;
	private Block food;
	
	public Snake() {
		this.snakeBody.add(this.generateRandomBlock());
		this.head = this.snakeBody.getFirst();
		this.direction = Directions.RIGHT;
		this.generateFood();
	}
	
	public LinkedList<Block> getSnakeBody() {
		return this.snakeBody;
	}
	
	public void move() {
		Block nextBlock = getNextBlock(this.head);
		
		if(this.checkCollision(nextBlock)) {
			// game over
			System.out.println("Game Over");
			return;
		}
				
		if(this.checkForFood(nextBlock)) {
			this.snakeBody.add(nextBlock);
			this.generateFood();
		}else {
			this.snakeBody.add(nextBlock);
			this.snakeBody.remove();
		}
		this.head = this.snakeBody.getLast();
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public Block getFood() {
		return this.food;
	}
	
	private Boolean checkCollision(Block block) {
		Position blockPosition = block.getPosition();
		for(Block snakeBodyBlock: this.snakeBody) {
			if(blockPosition.equals(snakeBodyBlock.getPosition())) {
				return true;
			}
			
			if(blockPosition.getPositionX() == (GameWindow.SCREEN_SIZE/Block.BLOCK_SIZE)*Block.BLOCK_SIZE || blockPosition.getPositionX() < 0) {
				return true;
			}
			
			if(blockPosition.getPositionY() == (GameWindow.SCREEN_SIZE/Block.BLOCK_SIZE)*Block.BLOCK_SIZE || blockPosition.getPositionY() < 0) {
				return true;
			}
		}
		return false;
	}
	
	private Boolean checkForFood(Block block) {
		if(this.food.getPosition().equals(block.getPosition())) {
			return true;
		}
		return false;
	}
	
	private void generateFood() {
		Block randomBlock = this.generateRandomBlock();
		for(Block snakeBodyBlock: this.snakeBody) {
			if(randomBlock.getPosition().equals(snakeBodyBlock.getPosition())) {
				this.generateFood();
			}else {
				this.food = randomBlock;
				return;
			}
		}
		
	}
	
	private Block generateRandomBlock() {
		Random randomInt = new Random();
		int randomPositionX = randomInt.nextInt(GameWindow.SCREEN_SIZE/Block.BLOCK_SIZE)*Block.BLOCK_SIZE;
		int randomPositionY = randomInt.nextInt(GameWindow.SCREEN_SIZE/Block.BLOCK_SIZE)*Block.BLOCK_SIZE;
		return new Block(new Position(randomPositionX, randomPositionY));
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
