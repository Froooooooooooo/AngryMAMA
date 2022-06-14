package gamepack;
import java.io.File;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Hudba
{
    public void playMusic(String filepath) {
        try {
            File fil = new File(filepath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(fil);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch(Exception e) {
        }
    }
    public void playBackground(String filepath) {
        try {
            File bak = new File(filepath);
            AudioInputStream audio = AudioSystem.getAudioInputStream(bak);
            Clip clipy = AudioSystem.getClip();
            clipy.open(audio);
            clipy.start();
            clipy.loop(clipy.LOOP_CONTINUOUSLY);
        } catch(Exception e) {
        }
    }
}
