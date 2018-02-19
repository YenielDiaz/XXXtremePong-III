package com.pong.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {
	
	private boolean[] keyDown = new boolean[2];
	
	private boolean[] keyDown2 = new boolean[2];
	
	private ObjectHandler handler;
	
	public KeyInput(ObjectHandler handler) {
		this.handler  = handler;
		
		keyDown[0] = false; // W
		keyDown[1] = false; // S
		
		keyDown2[0] = false; // UP
		keyDown2[1] = false; // DOWN
	}
	
	public void keyPressed(KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i<handler.objects.size(); i++ ) {
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getID().equals(ID.Player1)) {
				//key events for player1 object
				if(key == KeyEvent.VK_W) {
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S) {
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
			}
			if(tempObject.getID().equals(ID.Player2)) {
				//key events for player2 object
				if(key == KeyEvent.VK_UP) {
					tempObject.setVelY(-5);
					keyDown2[0] = true;
				}
				if(key == KeyEvent.VK_DOWN) {
					tempObject.setVelY(5);
					keyDown2[1] = true;
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
					
				}
				if(key == KeyEvent.VK_S) {
					keyDown[1] = false;
					
				}
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
	
			}
			
			if(tempObject.getID().equals(ID.Player2)) {
				
				if(key == KeyEvent.VK_UP) {
					keyDown2[0] = false;
				}
				
				if(key == KeyEvent.VK_DOWN) {
					keyDown2[1] = false;
				}
				
				//Vertical movement
				if(!keyDown2[0] && !keyDown2[1]) {
					tempObject.setVelY(0);
				}
			}
		}
		//closes game when esc key is pressed
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}


}
