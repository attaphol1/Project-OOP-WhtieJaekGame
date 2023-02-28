package src.model;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawCardButton {
    private JLabel lb;
    private ImageIcon imageIcon;
    private ImageIcon imageIconBorder;

    private int width;
    private int height;
    
    public DrawCardButton(){
        width = 227;
        height = 162;
        lb = new JLabel();
        imageIcon = new ImageIcon(new ImageIcon("asset/card/deck-of-card.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        imageIconBorder = new ImageIcon(new ImageIcon("asset/card/deck-of-card-border-yellow.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        lb.setIcon(imageIcon);
        lb.setSize(new Dimension(width, height));
    }

    public JLabel getLabel(){
        return lb;
    }

    public void setBorder() {
        lb.setIcon(imageIconBorder);
    }

    public void removeBorder() {
        lb.setIcon(imageIcon);
    }
}
