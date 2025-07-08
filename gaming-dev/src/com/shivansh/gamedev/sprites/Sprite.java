package com.shivansh.gamedev.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
//	abstract means no object is created of that class 
	public int x; // horizontal position
	public int y; // vertical position
	public int weidth;
	public int height;
	public   ImageIcon image; // to hold the player's image
	    public int speed=0;
	    
	    public void draw(Graphics pen) {
	        pen.drawImage(image.getImage(), x, y, weidth, height, null);
	    }
	
}
