package src.GUI;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackMenu {
    JLabel mainFrame;
    ImageIcon image;
    ImageIcon imageClick;

    BackMenu(){
        mainFrame = new JLabel();
        mainFrame.setSize(50, 50);

        image = new ImageIcon(new ImageIcon("asset/image/menu.png").getImage().getScaledInstance(50, 50, 0));
        imageClick = new ImageIcon(new ImageIcon("asset/image/menu-click.png").getImage().getScaledInstance(50, 50, 0));
        
        mainFrame.setIcon(image);
    }

    public void clickHandle(){
        mainFrame.setIcon(imageClick);
    }

    public void noClickHandle(){
        mainFrame.setIcon(image);
    }

    public Component getLabel() {
        return mainFrame;
    }
    
}
