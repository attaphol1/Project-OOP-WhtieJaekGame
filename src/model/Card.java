package src.model;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
    private int width;
    private int height;
    
    private int rank;
    private String path = "asset/card/";

    private JLabel label;

    Card(int rank, String type){
        this.rank = (rank >= 10)? 10:rank;
        path = path+type+"/"+rank+type.toLowerCase().charAt(0)+".png";

        width = 138;
        height = 210;

        initLabel();
    }

    void initLabel(){
        label = new JLabel();
        ImageIcon image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        label.setIcon(image);
        label.setSize(width,height);
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

    public JLabel getLabel() {
        return label;
    }

}
