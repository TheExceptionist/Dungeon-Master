package com.dungeonmaster.net.gen;

import java.util.Random;

public class LevelGen {
	private int width, height;
	private Random r;
	
	public int[] tiles;
	
	public LevelGen(int width, int height){
		this.width = width;
		this.height = height;
		
		tiles = new int[width * height];
		r = new Random(System.nanoTime());
	}
	
	public void genLevel(){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				tiles[x+y] = r.nextInt(2);
			}
		}
	}
}
