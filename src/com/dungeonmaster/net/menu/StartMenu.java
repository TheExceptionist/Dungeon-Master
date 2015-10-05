package com.dungeonmaster.net.menu;

import java.awt.Color;
import java.awt.Graphics;

import com.dungeonmaster.net.GameMain;
import com.dungeonmaster.net.assets.JukeBox;
import com.dungeonmaster.net.input.Key;


public class StartMenu extends Menu {
	public StartMenu(Key k, GameMain game){
		super(k, game);
		
		options = new String[3];
		
		options[0] = "Start";
		options[1] = "Help";
		options[2] = "Exit";
		
		JukeBox.loop("Escape");
	}
	
	public void initOption(String option){
		if(option == options[0]){
			JukeBox.stop("Escape");
			game.setMenu(null);
		}
		if(option == options[1]){

		}
		if(option == options[2]){
			System.exit(0);
		}
	}
	
	public void tick(){
		super.tick();
	}
	
	public void render(Graphics g){
		super.render(g);
		
		f.draw(GameMain.title, "Times New Roman", 50, GameMain.WIDTH/4, (GameMain.HEIGHT/2 - GameMain.HEIGHT/4), Color.GRAY, g);
	}
}
