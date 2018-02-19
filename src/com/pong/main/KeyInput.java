package com.pong.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
	
	private boolean[] keyDown = new boolean[2];
	
	private ObjectHandler handler;
	
	public KeyInput(ObjectHandler handler) {
		this.handler  = handler;
		
		keyDown[0] = false; // W
		keyDown[1] = false; // S
	}
	
	public void keyPressed(KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i<handler.objects.size(); i++ ) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getID().equals(ID.Player1)) {
				//key events for player object
				if(key == KeyEvent.VK_W) {
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S) {
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i<handler.objects.size(); i++ ) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getID().equals(ID.Player1)) {
				//key events for player object
				if(key == KeyEvent.VK_W) {
					keyDown[0] = false;
					//tempObject.setVelY(0);
				}
				if(key == KeyEvent.VK_S) {
					keyDown[1] = false;
					//tempObject.setVelY(0);
				}
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
				
			}
		}
		//closes game when esc key is pressed
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}


}
