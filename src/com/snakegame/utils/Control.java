package com.snakegame.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control extends KeyAdapter {
	private int direction;
	
	public Control(int currentDirection) {
		this.direction = currentDirection;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		int key = keyEvent.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			this.direction = Directions.RIGHT;
		}
		
		if(key == KeyEvent.VK_LEFT) {
			this.direction = Directions.LEFT;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			this.direction = Directions.DOWN;
		}
		
		if(key == KeyEvent.VK_UP) {
			this.direction = Directions.UP;
		}
		
	}
}
