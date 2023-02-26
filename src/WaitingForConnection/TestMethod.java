package src.WaitingForConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

public class TestMethod {
    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        JLabel lb1 = new JLabel();
        lb1.setText("page 1");
        lb1.setBounds(200, 200, 100, 100);
        new Test2(f);
        
        f.add(lb1);
        f.setLayout(null);
        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Test2{
    JFrame fT2;
    JButton btn;
    JLabel lb;
    int cnt;

    Test2(JFrame f1){
        btn = new JButton("HI");
        lb = new JLabel();
        fT2 = f1;
        cnt= 0;
        initBtn();
        initLabel();
        initFrame();
    }

    void initLabel(){
        lb.setText(String.format("%d", cnt));
    }

    void initFrame(){
        btn.setBounds(100, 100, 50, 50);
        lb.setBounds(200, 100, 100, 100);
        fT2.add(btn);
        fT2.add(lb);
        fT2.repaint();
    }

    void initBtn(){
        btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cnt++;
                // TODO Auto-generated method stub
                // fT2.removeAll();
                initLabel();
                fT2.repaint();
            } 
        });
    }
}
