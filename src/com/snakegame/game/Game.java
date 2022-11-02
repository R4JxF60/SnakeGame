package com.snakegame.game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game {
	final static String WindowTitle = "Snake Game";
	
	public static void main(String []args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(GameWindow.SCREEN_SIZE, GameWindow.SCREEN_SIZE));
		frame.setTitle(Game.WindowTitle);
		frame.add(new GameWindow());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
