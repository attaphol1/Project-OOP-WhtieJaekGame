package src.WaitingForConnection;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DefaultFramWin {
    private JLabel winText;
    private JLabel imgKor1;
    private JLabel imgKor2;
    private JLabel labelBG;

    private ImageIcon img1_P1;
    private ImageIcon img2_P1;
    private ImageIcon img3_P1;
    private ImageIcon img4_P1;
    private ImageIcon img5_P1;
    private ImageIcon img6_P1;
    private ImageIcon p1lose;

    private ImageIcon img1_P2;
    private ImageIcon img2_P2;
    private ImageIcon img3_P2;
    private ImageIcon img4_P2;
    private ImageIcon img5_P2;
    private ImageIcon img6_P2;
    private ImageIcon p2lose;
    private ImageIcon background;

    private ImageIcon reset;
    private JFrame frame;

    private  Timer timer1;

    private Playmusic kunPee = new Playmusic();

    public DefaultFramWin(){
        newImage();
        
        frame = new JFrame("");
        
        winText = new JLabel("Player 1 WIN!!!");
        winText.setForeground(Color.WHITE);

        labelBG = new JLabel();
        labelBG.setIcon(background);
        imgKor1 = new JLabel();
        imgKor1.setBounds(0, 140, 350, 600);
        imgKor2 = new JLabel();
        imgKor2.setBounds(700, 200, 250, 500);

        DefaultFramWin.customFont(winText,60);

        frame.add(winText);
        frame.add(imgKor2);
        frame.add(imgKor1);
        frame.add(labelBG);
        frame.setSize(1000, 800);
        frame.setVisible(false);  
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void newImage(){
       img1_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar01.png").getImage().getScaledInstance(250, 600, 0));
       img2_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar02.png").getImage().getScaledInstance(250, 600, 0));
       img3_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar03.png").getImage().getScaledInstance(250, 600, 0));
       img4_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar04.png").getImage().getScaledInstance(250, 600, 0));
       img5_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar05.png").getImage().getScaledInstance(250, 600, 0));
       img6_P1 = new ImageIcon(new ImageIcon("asset/image/kor/dar06.png").getImage().getScaledInstance(250, 600, 0));
       p1lose = new ImageIcon(new ImageIcon("asset/image/kor/p1lose.png").getImage().getScaledInstance(320, 600, 0));

       img1_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w01.png").getImage().getScaledInstance(250, 500, 0));
       img2_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w02.png").getImage().getScaledInstance(250, 500, 0));
       img3_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w03.png").getImage().getScaledInstance(250, 500, 0));
       img4_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w04.png").getImage().getScaledInstance(250, 500, 0));
       img5_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w05.png").getImage().getScaledInstance(250, 500, 0));
       img6_P2 = new ImageIcon(new ImageIcon("asset/image/kor/w06.png").getImage().getScaledInstance(250, 500, 0));
       p2lose = new ImageIcon(new ImageIcon("asset/image/kor/p2lose.png").getImage().getScaledInstance(250,500, 0));

       reset = new ImageIcon("asset/image/kor/reset.png");
       background = new ImageIcon("asset/image/kor/background.png");
    }

    public void playerOneWin(int points) {     
        kunPee.Playmusics("asset/sound/kunPeYuJangWatRiKa.wav");
        winText.setText("Player 1 WIN!!!");
        winText.setBounds(240, 0, 600, 100);
        frame.setVisible(true);
        timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (points) {
                    case 1 : imgKor1.setIcon(img1_P1); break;
                    case 2 : imgKor1.setIcon(img2_P1); break;
                    case 3 : imgKor1.setIcon(img3_P1); break; 
                    case 4 : imgKor1.setIcon(img4_P1); break;
                    case 5 : imgKor1.setIcon(img5_P1); break;
                    case 6 : imgKor1.setIcon(img6_P1); break;
                }    
            }    
        },1000);    
        timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.setVisible(false);
                }    
            },4000);
    }

    public void playerTwoWin(int points) {
        kunPee.Playmusics("asset/sound/kunPeYuJangWatRiKa.wav");
        winText.setText("Player 2 WIN!!!");
        winText.setBounds(240, 0, 600, 100);
        frame.setVisible(true);
        timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                switch (points) {
                    case 1 : imgKor2.setIcon(img1_P2); break;
                    case 2 : imgKor2.setIcon(img2_P2); break;
                    case 3 : imgKor2.setIcon(img3_P2); break; 
                    case 4 : imgKor2.setIcon(img4_P2); break;
                    case 5 : imgKor2.setIcon(img5_P2); break;
                    case 6 : imgKor2.setIcon(img6_P2); break;
                }    
            }    
        },1000);

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                frame.setVisible(false);
            }    
        },4000);

    }

    public void resetWinGame() {      
        frame.setVisible(true);
        imgKor1.setIcon(p1lose);
        imgKor2.setIcon(p2lose);
        winText.setText("RESET");
        winText.setBounds(400, 150, 500, 500);

        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    imgKor1.setIcon(reset);
                    imgKor2.setIcon(reset);
                    frame.setVisible(false);
                }    
            },3000);
    }

    public static void customFont(JLabel label, float size){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("asset/font/SFPixelateShaded.ttf")).deriveFont(size);
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