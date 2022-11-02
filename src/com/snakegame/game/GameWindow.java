package com.snakegame.game;

import javax.swing.*;
import java.awt.*;

import com.snakegame.utils.*;

public class GameWindow extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public final static int SCREEN_SIZE = 640;
	
	public GameWindow() {
		super();
		this.setBackground(Color.BLACK);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        
        for(int line = 0; line < GameWindow.SCREEN_SIZE; line += Block.BLOCK_SIZE) {
        	g.drawLine(line, 0, line, GameWindow.SCREEN_SIZE);
        	g.drawLine(0, line, GameWindow.SCREEN_SIZE, line);
        }
    }
}
