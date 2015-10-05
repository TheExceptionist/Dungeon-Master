package com.dungeonmaster.net.gen;

import java.util.Random;

public class LevelGen {
	public int width, height;
	private Random r;
	
	public int[] tiles;
	
	public LevelGen(int width, int height){
		this.width = width + 1;
		this.height = height + 1;
		
		tiles = new int[width * height];
		r = new Random(System.nanoTime());
	}
	
	public void genLevel(){
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				/*if(y == 0){
					tiles[x+y] = 1;
				}else{
					tiles[x+y] = 0;
				}*/
			}
		}
	}
}
