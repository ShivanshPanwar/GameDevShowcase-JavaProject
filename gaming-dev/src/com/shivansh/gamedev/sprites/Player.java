package com.shivansh.gamedev.sprites;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Player extends Sprite {
   
    public Player() {
        
        weidth = 200;
        height = 200;
        x = 100;
        y = 400;
        image = new ImageIcon(Player.class.getResource("player.gif"));

    }
public void move() {
	x+=speed;
	// we need to move player if a key is pressed
}
public boolean outOfScreen() {
	return x>1400;
}
}
