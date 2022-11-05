package com.snakegame.game;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game implements Runnable {
	final static String WindowTitle = "Snake Game";
	
	public static void main(String []args) {
		Game game = new Game();
		Thread thread = new Thread(game);
		thread.start();
	}

	@Override
	public void run() {
		JFrame frame = new JFrame();
		frame.setTitle(Game.WindowTitle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(new GameWindow());
		frame.setMinimumSize(new Dimension(GameWindow.SCREEN_SIZE, GameWindow.SCREEN_SIZE));
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
