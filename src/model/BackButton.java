package src.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackButton {
    private JLabel label;
    private ImageIcon imgBlack;
    private ImageIcon imgYellow;

    public BackButton(){
        label = new JLabel();
        imgBlack = new ImageIcon(new ImageIcon("asset/image/back.png").getImage().getScaledInstance(100, 20, 0));
        imgYellow = new ImageIcon(new ImageIcon("asset/image/back-yellow.png").getImage().getScaledInstance(100, 20, 0));

        label.setIcon(imgBlack);
        label.setBounds(850, 700, 100, 20);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setImgYellow() {
        label.setIcon(imgYellow);
    }
    
    public void setImgBlack() {
        label.setIcon(imgBlack);
    }
}
