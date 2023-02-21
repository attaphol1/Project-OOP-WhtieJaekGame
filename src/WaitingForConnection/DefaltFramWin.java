package src.WaitingForConnection;

import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DefaltFramWin {
    private JLabel winText;
    private WinGame panel;
    JFrame frame;
    public DefaltFramWin(){
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new WinGame();
        winText = new JLabel("Player 1 WIN!!!");
        winText.setFont(new Font("SF Pixelate Shaded",Font.PLAIN,50));
        frame.add(winText);
        frame.add(panel);
        frame.setSize(1000, 800);
        frame.setVisible(false);  
        frame.setResizable(false);
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

    public void statusPlayerOneWin(){
        winText.setText("Player 1 WIN!!!");
        winText.setBounds(280, 150, 500, 500);
    }

    public void statusPlayerTwoWin(){
        winText.setText("Player 2 WIN!!!");
        winText.setBounds(280, 150, 500, 500);
    }

    public void resetWinGame() {   
        frame.setVisible(true);
        panel.resetFrame();
        winText.setText("RESET");
        winText.setBounds(410, 150, 500, 500);
        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.setVisible(false);
                }    
            },1000);
    }

}