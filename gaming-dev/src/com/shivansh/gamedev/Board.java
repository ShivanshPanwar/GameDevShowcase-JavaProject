package com.shivansh.gamedev;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.shivansh.gamedev.sprites.Enemy;
import com.shivansh.gamedev.sprites.Player;

public class Board extends JPanel {
	
	 Timer timer;
    BufferedImage backgroundImage;
    Player player;
    Enemy enemy;
    Enemy[] enemies=new Enemy[3];
   

    public Board() {
    	
        setSize(1500,920);
        loadBackgroundImage();
        player=new Player();
         loadEnemies();
        gameLoop();
        
        bindEvents();
        setFocusable(true); // to set focus on board
        
    }
    private void loadEnemies() {
    	int x=400;
    	int gap=350;
    	int speed=5;
    	for(int i=0;i<enemies.length;i++) {
    		enemies[i]=new Enemy(x,speed);
    		x=x+gap;
    		speed+=5;
    	}
    }
    
    private void bindEvents() {
    	addKeyListener(new KeyListener(){
    		
    		public void keyTyped(KeyEvent e) {
    			
    		}
    		
    		public void keyReleased(KeyEvent e) {
    			player.speed=0;
    		}
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
	            player.speed=10;
    		 }
            	else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
            	player.speed=-10;
            	}
            }
    	});
    }
    private boolean isCollide(Enemy enemy) {
    	int xDistance=Math.abs(player.x-enemy.x);
    	int yDistance=Math.abs(player.y-enemy.y);
    	int maxHeight=Math.max(player.height,enemy.height);
    	int maxWeidth=Math.max(player.weidth, enemy.weidth);
    	return xDistance<=maxWeidth-65 && yDistance<=maxHeight-100;
    }
    
   

    private void gameOver(Graphics pen) {
    	if(player.outOfScreen()) {
    		pen.setFont(new Font("times",Font.BOLD,80));
			pen.setColor(Color.RED);
			pen.drawString("Game Won", getWidth() / 2 - 200, getHeight() / 2);

		    timer.stop();// to close the game 
		    return ;
    	}
    	for(Enemy enemy:enemies) {
    		if(isCollide(enemy)) {
    			pen.setFont(new Font("times",Font.BOLD,80));
    			pen.setColor(Color.RED);
    			pen.drawString("Game Over", getWidth() / 2 - 200, getHeight() / 2);

    		    timer.stop();// to close the game 
    				
    		}
    	}
    }
    
    // build for multi-tasking 
    private void gameLoop() {
    	timer = new Timer(50, (e) -> repaint()); // use repaint() bec paint component call only one time 
    	
    	timer.start();
    }

    private void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(
                Board.class.getResource("game-back.jpeg.jpg")
            );
            if (backgroundImage == null) {
                throw new IOException("Resource not found");
            }
        } catch (IOException e) {
            System.err.println("Background image not available...");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    
private void printEnemies(Graphics pen) {
	for(Enemy enemy:enemies) {
		enemy.draw(pen);
		enemy.move();
	}
	
}
    @Override
    public void paintComponent(Graphics pen) {
        super.paintComponent(pen);
       
      
          pen.drawImage(backgroundImage, 0, 0, 1500, 720, null);
            player.draw(pen);
            player.move();
            printEnemies(pen);
            gameOver(pen);
         
    }
}

 	