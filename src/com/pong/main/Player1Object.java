package com.pong.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player1Object extends GameObject {

	ObjectHandler handler;
	
	public Player1Object(float x, float y, ID id, ObjectHandler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}

	@Override
	public void tick() {
		//this moves the object according to its speed;
		x += velX;
		y += velY;
	
		x = Main.clamp(x, 0, Main.WIDTH - 40);
		y = Main.clamp(y, 100, Main.HEIGHT - 105);

	}
	

	@Override
	public void render(Graphics g) {
		//set player color and dimensions
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y,10, 70);
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,10,70);
	}

}
