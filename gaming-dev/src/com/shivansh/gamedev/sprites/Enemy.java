package com.shivansh.gamedev.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {

	    public Enemy(int x,int speed) {
	        
	        weidth = 150;
	        height = 150;
	        // to create three enemies at different distance 
	        this.x =x;
	       this.speed=speed;
	        y = 30;
	        image=new ImageIcon(Enemy.class.getResource("spider-enemy.gif"));

	    }
	    public void move() {
	    	if(y>900) {
	    		y=0;
	    	}
			y+=speed;
		}

}

