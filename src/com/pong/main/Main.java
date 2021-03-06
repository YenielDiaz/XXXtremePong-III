package com.pong.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Main extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3896263674762839232L;
	
	Random r;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH/12 * 9;
	
	private Thread thread;
	private ObjectHandler handler;
	private HUD hud;
	private boolean running = false;
	
	public Main() {
		new Window(WIDTH, HEIGHT, "Pong", this);
		
		handler = new ObjectHandler();
		hud = new HUD();
		
		this.addKeyListener(new KeyInput(handler));
		
		r = new Random();
		
		handler.addObject(new Player1Object(50, HEIGHT/2 - 32, ID.Player1, handler));
		handler.addObject(new Player2Object(WIDTH - 50, HEIGHT/2 - 32, ID.Player2, handler));
		handler.addObject(new Ball(WIDTH/2, HEIGHT/2 - 32, ID.Ball, handler, hud));
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			//creates 3 buffers within game
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, WIDTH, HEIGHT);
		
		handler.render(g);
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	//find out how this works. tutorial guy could not quite explain.
		public void run() {
			//gameLoop to make game keep updating itself
			//tutorial guy says it is not his own code
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			long timer = System.currentTimeMillis();
			int frames = 0;
			
			while(running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while(delta >= 1) {
					tick();
					delta--;
				}
				if(running) render();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000) {
					timer+= 1000;
					System.out.println("FPS: " + frames);
					frames = 0;
				}
			}
			stop();
	}
		
	public static float clamp(float var, float min, float max) {
		if(var >= max) {
			return var =  max;
		}else if(var <= min) {
			return var =  min;
		}else {
			return var;
		}
	}
		
	public synchronized void start() {
		//initializes thread (this refers to this game instance) and starts it
		thread = new Thread(this);
		thread.start();
		this.requestFocus();
		running = true;
	}
		
	public synchronized void stop() {
		try {
			//thread.join basically just stops the thread
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
