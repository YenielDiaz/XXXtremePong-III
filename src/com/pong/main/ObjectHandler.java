package com.pong.main;

import java.awt.Graphics;
import java.util.ArrayList;


public class ObjectHandler {

	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	//invokes tick on all our gameObjects
		public void tick() {
			for(int i=0; i<objects.size(); i++) {
				GameObject tempObject = objects.get(i);
				
				tempObject.tick();
			}
		}
		
		//invokes render on all our gameObjects
		public void render(Graphics g) {
			for(int i=0; i<objects.size(); i++) {
				GameObject tempObject = objects.get(i);
				
				tempObject.render(g);
			}
		}
	
	
	
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
}
