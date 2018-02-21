package com.pong.main;

import java.awt.Color;
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
		g.setColor(Color.white);
	}
}
