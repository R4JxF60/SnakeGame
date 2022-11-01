package com.snakegame.game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final static int ScreenWidth = 640;
	final static int ScreenHeight = 420;
	final static String WindowTitle = "Snake Game";
	
	public GameWindow() {
		super();
		this.setVisible(true);
		this.setTitle(GameWindow.WindowTitle);
		this.setSize(new Dimension(GameWindow.ScreenWidth, GameWindow.ScreenHeight));
	}
}
