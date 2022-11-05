package com.snakegame.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.snakegame.utils.*;

public class GameWindow extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	public final static int SCREEN_SIZE = 640;
	private Snake snake;
	private Timer timer;
	public final static int DELAY = 100;
	private Control control;
	
	public GameWindow() {
		super();
		this.snake = new Snake();
		this.control = new Control(this.snake.getDirection());
		this.setSize(new Dimension(GameWindow.SCREEN_SIZE, GameWindow.SCREEN_SIZE));
		this.addKeyListener(this.control);
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.timer = new Timer(DELAY, this);
		this.timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.initGrapics(g);
		this.draw(g);
    }
	
	private void initGrapics(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		        
        for(int line = 0; line <= GameWindow.SCREEN_SIZE; line += Block.BLOCK_SIZE) {
        	g.drawLine(line, 0, line, GameWindow.SCREEN_SIZE);
        	g.drawLine(0, line, GameWindow.SCREEN_SIZE, line);
        }
	}
	
	private void draw(Graphics g) {
		g.setColor(Color.GREEN);
		for(Block snakeBodyBlock : this.snake.getSnakeBody()) {
			g.fillRect(snakeBodyBlock.getPosition().getPositionX(), snakeBodyBlock.getPosition().getPositionY(), Block.BLOCK_SIZE, Block.BLOCK_SIZE);
		}
		g.setColor(Color.RED);
		g.fillRect(this.snake.getFood().getPosition().getPositionX(), this.snake.getFood().getPosition().getPositionY(), Block.BLOCK_SIZE, Block.BLOCK_SIZE);
	}
	
	private void listenToDirectionChanges() {
		int snakeCurrentDirection = this.snake.getDirection();
		int nextDirection = this.control.getDirection();
		
		if(snakeCurrentDirection == Directions.RIGHT && nextDirection == Directions.LEFT) return;
		if(snakeCurrentDirection == Directions.LEFT && nextDirection == Directions.RIGHT) return;
		if(snakeCurrentDirection == Directions.UP && nextDirection == Directions.DOWN) return;
		if(snakeCurrentDirection == Directions.DOWN && nextDirection == Directions.UP) return;
		
		this.snake.setDirection(this.control.getDirection());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.snake.move();
		this.listenToDirectionChanges();
		this.updateUI();
	}

}
