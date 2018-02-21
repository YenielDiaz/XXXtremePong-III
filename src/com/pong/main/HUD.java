package com.pong.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	private int p1Score = 0;
	private int p2Score = 0;

	
	public int setP1Score(int score) {
		return this.p1Score = score;
	}
	
	public int setP2Score(int score) {
		return this.p2Score = score;
	}
	
	public int getP1Score() {
		return p1Score;
	}
	
	public int getP2Score() {
		return p2Score;
	}
	
	public void render(Graphics g) {
		//temporary font
		Font fnt = new Font("arial", 1, 75);
		
		g.setColor(Color.white);
		g.drawLine(0, 95, Main.WIDTH, 95);
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, Main.WIDTH, 95);
		
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString(Integer.toString(p1Score), 100,70);
		g.drawString(Integer.toString(p2Score), Main.WIDTH - 170, 70);
	}
}
