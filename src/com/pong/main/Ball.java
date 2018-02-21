package com.pong.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Ball extends GameObject {

	private ObjectHandler handler;
	private HUD hud;
	private int timer = 80;
	private boolean pointMade = false;
	Random r = new Random();
	private int[] startSpeed = {5,-5};
	private int choice = r.nextInt(2);
	
	public Ball(float x, float y, ID id, ObjectHandler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		
		velX = startSpeed[choice];
		velY = startSpeed[choice];
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		
		if(y<= 100 || y>= Main.HEIGHT - 32) {
			velY *= -1;
		}
		
		if(x<=0 || x>= Main.WIDTH - 16) {
			//velX *= -1;
			pointMade = true;
			if(x<= 0) {
				hud.setP2Score(hud.getP2Score() + 1);
			}
			if(x>= Main.WIDTH - 16) {
				hud.setP1Score(hud.getP1Score() + 1);
			}
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
				choice = r.nextInt(2);
				velX = startSpeed[choice];
				choice = r.nextInt(2);
				velY = startSpeed[choice];
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
