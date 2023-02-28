package src.WaitingForConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestMethod {
    static int i;
    static Timer t;
    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        JLabel lb1 = new JLabel();
        lb1.setText("return in 5");
        lb1.setBounds(200, 200, 100, 100);
        i = 5;
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                lb1.setText("return in "+Integer.toString(seti()));
                f.repaint();
            }    
        },1000,1000);
        
        f.add(lb1);
        f.setLayout(null);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private static final int seti() {
        //if interval is 1, cancel
        if (i == 1) t.cancel();
        return --i;
    }
}