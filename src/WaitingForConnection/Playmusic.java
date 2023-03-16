package src.WaitingForConnection;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Playmusic {
    Clip clip;
        public void Playmusics(String location){
        try{
            File music=new File(location);
            if(music.exists()){
                AudioInputStream audioinput=AudioSystem.getAudioInputStream(music);
                clip= AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
            }else{
                System.out.println("can't play");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void stopMusic(){
            clip.stop();
        }
}
