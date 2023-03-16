package src.model;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
    private int width = 138;
    private int height = 210;
    
    private int rank;
    private String type;
    private String path = "asset/card/";

    private JLabel labelFront;
    private JLabel labelBack; 

    Card(int rank, String type){
        this.rank = (rank >= 10)? 10:rank;
        this.type = type;
        path = path+type+"/"+rank+type.toLowerCase().charAt(0)+".png";

        initLabel();
    }

    void initLabel(){
        labelFront = new JLabel();
        ImageIcon image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        labelFront.setIcon(image);
        labelFront.setSize(width,height);
        
        labelBack = new JLabel();
        image = new ImageIcon(new ImageIcon("asset/card/back-card.png").getImage().getScaledInstance(width, height, 1));
        labelBack.setIcon(image);
        labelBack.setSize(width, height);
        
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public JLabel getLabelFront() {
        return labelFront;
    }

    public String getType(){
        return type;
    }

    public JLabel getLabelBack() {
        return labelBack;
    }
}
