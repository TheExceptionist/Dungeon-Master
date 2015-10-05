package com.dungeonmaster.net.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameFont {
	public void draw(String msg, String f, int size, int x, int y, Color c, Graphics g){
		g.setColor(c);
		g.setFont(new Font(f, Font.PLAIN, size));
		
		g.drawString(msg, x, y);
	}
}
