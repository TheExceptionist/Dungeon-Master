package com.dungeonmaster.net.menu;

import java.awt.Graphics;

import com.dungeonmaster.net.GameMain;
import com.dungeonmaster.net.input.Key;


public class StartMenu extends Menu {
	public StartMenu(Key k, GameMain game){
		super(k, game);
		
		options = new String[3];
		
		options[0] = "Start";
		options[1] = "Help";
		options[2] = "Exit";
	}
	
	public void initOption(String option){
		if(option == options[0]){
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
	}
}
