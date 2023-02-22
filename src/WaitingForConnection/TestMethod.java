package src.WaitingForConnection;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

public class TestMethod extends JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("asset/Font/SFPixelateShaded.ttf")).deriveFont(50f);
            JLabel label = new JLabel();
            label.setText("TEST");
            label.setBounds(100, 100, 100, 100);
            label.setFont(font);
            f.add(label);
        } catch (FontFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        f.setSize(800, 600);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

