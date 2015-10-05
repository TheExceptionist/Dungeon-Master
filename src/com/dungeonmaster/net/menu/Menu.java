package com.dungeonmaster.net.menu;

import java.awt.Color;
import java.awt.Graphics;

import com.dungeonmaster.net.GameMain;
import com.dungeonmaster.net.gfx.GameFont;
import com.dungeonmaster.net.input.Key;

public class Menu {
	public String[] options;
	
	protected GameFont f;
	protected GameMain game;
	protected int currentOption;
	protected Key k;
	
	public Menu(Key k, GameMain game){
		this.k = k;
		this.game = game;
		
		f = new GameFont();
	}
	
	public void initOption(String option){
		
	}
	
	public void tick(){
		if(k.up.clicked){
			if(currentOption == 0){
				currentOption = options.length - 1;
			}else{		
				currentOption--;
			}
		}
		
		if(k.down.clicked){
			if(currentOption == options.length - 1){
				currentOption = 0;
			}else{		
				currentOption++;
			}
		}
		
		if(k.activate.clicked){
			initOption(options[currentOption]);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < options.length; i++){
			f.draw(options[i], "Times New Roman", 30, GameMain.WIDTH/3 + 80, (GameMain.HEIGHT/2 + GameMain.HEIGHT/4 - 80) + i * 45, Color.GRAY, g);
			
			if(i == currentOption){
				f.draw(">>", "Times New Roman", 30, GameMain.WIDTH/3 + 30, (GameMain.HEIGHT/2 + GameMain.HEIGHT/4 - 80) + i * 45, Color.GRAY, g);
			}
		}
	}
}
