package com.prebensoft.adventureoftheknight;

import java.io.*;
import sun.audio.*;

public class Backgroundmusic implements Runnable{
	
	boolean running;
	InputStream inputStream;
	AudioStream audioStream;
	
	public Backgroundmusic() {
	}
	
	public void run() {
		playSound();
	}
	
	public void startBackGroundMusic() {
		(new Thread(new Backgroundmusic())).start();
	}
	private void playSound() {
		try {
			inputStream = getClass().getResourceAsStream("/AOTKTheme.wav");
			audioStream = new AudioStream(inputStream);
			AudioPlayer.player.start(audioStream);
			running = true;
			
		} catch (Exception e) {
			System.out.println("Musikken Krasja spelet!");			
		}
	}
	
	public boolean getState() {
		return running;
	}

}
