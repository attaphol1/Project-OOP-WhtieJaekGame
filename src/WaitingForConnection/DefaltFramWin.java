package src.WaitingForConnection;

import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class DefaltFramWin {
    private WinGame panel;
    JFrame frame;
    public DefaltFramWin(){
        frame = new JFrame("Win");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new WinGame();
        frame.add(panel);
        frame.setSize(1000, 800);
        frame.setVisible(false);
        
        
    }

    public void playerOneWin(int points) {   
        frame.setVisible(true);
        panel.setPointsPlayerTwo(points);

        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.setVisible(false);
                }    
            },4000);
    }

    public void playerTwoWin(int points) {
        frame.setVisible(true);
        panel.setPointsPlayerOne(points);

        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.setVisible(false);
                }    
            },4000);
    }

    public void resetWinGame(){
        panel.resetFrame();
    }

}