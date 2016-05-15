import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer implements Runnable {
	String soundFile;

	public SoundPlayer(String f) {
		soundFile = f;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			File f = new File(soundFile);
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(f));
			c.start();
			Thread.sleep(c.getMicrosecondLength() / 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");

		}

	}
}
