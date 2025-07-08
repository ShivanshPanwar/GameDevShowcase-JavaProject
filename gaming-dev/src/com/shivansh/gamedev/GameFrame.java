package com.shivansh.gamedev;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	public GameFrame() {
		Board board=new Board();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Game Dev in Java");
		setResizable(false);
		setSize(1500,920);
		setLocationRelativeTo(null);
		add(board);
		setVisible(true);
	}
public static void main(String[] args) {
	GameFrame frame=new GameFrame();
	
}
}
