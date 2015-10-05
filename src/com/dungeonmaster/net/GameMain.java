package com.dungeonmaster.net;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.dungeonmaster.net.assets.Assets;
import com.dungeonmaster.net.input.Key;
import com.dungeonmaster.net.menu.Menu;
import com.dungeonmaster.net.menu.StartMenu;

public class GameMain extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final String title = "Dungeon Master";
	public static final int WIDTH = 600, HEIGHT = 600;
	
	public int[] titles;
	public Menu menu;
	
	private boolean running;
	
	private Thread thread;
	private Key k;
	
	public void setMenu(Menu m){
		menu = m;
	}
	
	public GameMain(){
		k = new Key(this);
		
		Assets.load();
		
		setMenu(new StartMenu(k, this));
	}
	
	private synchronized void start(){
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
		}
		
		running = false;
		
		try{
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double delta = 0;
		double amountOfTicks = 60.0;
		double ns = 1000000000.0 / amountOfTicks;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					frames = 0;
				}
			}
		}
		stop();
	}
	
	private void tick(){
		if(menu instanceof StartMenu){
			menu.tick();
			k.tick();
		}
		if(menu == null){
			
		}
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(menu instanceof StartMenu){
			g.drawImage(Assets.rain, 0, 0, null);
			menu.render(g);
		}
		if(menu == null){
			
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		JFrame window = new JFrame(title);
		GameMain game = new GameMain();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.add(game);
		window.setResizable(false);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
		game.start();
	}
}