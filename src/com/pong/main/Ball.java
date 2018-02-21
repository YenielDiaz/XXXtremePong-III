package com.pong.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball extends GameObject {

	private ObjectHandler handler;
	private int timer = 80;
	private boolean pointMade = false;
	
	public Ball(float x, float y, ID id, ObjectHandler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		
		if(y<= 0 || y>= Main.HEIGHT - 32) {
			velY *= -1;
		}
		
		if(x<=0 || x>= Main.WIDTH - 16) {
			//velX *= -1;
			pointMade = true;
		}
		
		nextPoint();
		collision();
		
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
	
	private void nextPoint() {
		if(pointMade) {
			velX = 0;
			velY = 0;
			this.setX(Main.WIDTH/2);
			this.setY(Main.HEIGHT/2 - 32);
			if(timer <= 0) {
				velX = 5;
				velY = 5;
				pointMade = false;
				timer = 80;
			}else {
				timer--;
			}
			
			
		}
	}
	
	private void collision() {
		for(int i=0; i<handler.objects.size(); i++) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getID() == ID.Player1 || tempObject.getID() == ID.Player2) {
				if(getBounds().intersects(tempObject.getBounds())){
					velX = -velX;
				}
				
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,16,16);
	}

}
