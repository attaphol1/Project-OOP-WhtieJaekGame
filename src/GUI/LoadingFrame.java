package src.GUI;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

import src.WaitingForConnection.DefaultFramWin;

public class LoadingFrame {
    JLabel mainFrame;
    JLabel text;
    Timer time;

    int second;

    public LoadingFrame(int s){
        second = s;
        mainFrame = new JLabel();
        mainFrame.setBounds(0, 0, 1000, 800);
        mainFrame.setVisible(false);
        time = new Timer();

        text = new JLabel("return in " + second);
        DefaultFramWin.customFont(text, 50);
        text.setBounds(0, 0, 500, 200);
        mainFrame.add(text);
    }

    private final int seti() {
        if (second == 1) time.cancel();
        return --second;
    }

    public void start(JFrame frame){
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                text.setText("return in "+Integer.toString(seti()));
                frame.repaint();
            }    
        },1000,1000);
    }

    public JLabel getMainFrame(){
        return mainFrame;
    }
}
