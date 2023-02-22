package src.WaitingForConnection;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
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
        DefaltFramWin.customFont(winText,50);
        winText.setBounds(280, 150, 500, 500);

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
    }

    public void statusPlayerTwoWin(){
        winText.setText("Player 2 WIN!!!");
        
    }

    public void resetWinGame() {  
        
        frame.setVisible(true);
        panel.setPointsPlayerOne(0);
        panel.setPointsPlayerTwo(0);
        winText.setText("RESET");
        winText.setBounds(410, 150, 500, 500);

        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.setVisible(false);
                }    
            },3000);

    }

    public static void customFont(JLabel label, float size){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("asset/Font/SFPixelateShaded.ttf")).deriveFont(size);
            font.deriveFont(Font.PLAIN);
            label.setFont(font);
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}