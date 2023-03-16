package src.model;

import javax.swing.JLayeredPane;

public class Bot extends Player {
    
    public void showCard(){
        
    }

    public void showCard(JLayeredPane layer) {
        layer.removeAll();
        int zOrder = 0;
        for(Card c : this.getListCard()){
            layer.add(c.getLabelFront(),Integer.valueOf(zOrder++));
        }
    }
}
