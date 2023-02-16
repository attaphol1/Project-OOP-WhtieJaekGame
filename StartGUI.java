import javax.swing.*;
import java.awt.*;

public class StartGUI {
    private JButton btnStart;
    private JButton btnExit;

    private ImageIcon iconStartClick;
    private ImageIcon iconExitClick;
    private ImageIcon iconStartImage;
    private ImageIcon iconExitImage;

    
    public StartGUI(){
        initVariable();
    }

    public void initVariable(){
            
            // iconExitImage = iconExit.getScaledInstance(200, 100, Image.SCALE_DEFAULT);
        iconExitImage = new ImageIcon(new ImageIcon("asset/button/Exit-Button.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        iconExitClick = new ImageIcon(new ImageIcon("asset/button/Exit-Button-Click.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        iconStartImage = new ImageIcon(new ImageIcon("asset/button/Start-Button.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));
        iconStartClick = new ImageIcon(new ImageIcon("asset/button/Start-Button-Click.png").getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT));

        btnStart = new JButton("");
        btnExit = new JButton("");

        btnStart.setIcon(iconStartImage);
        btnExit.setIcon(iconExitImage);
    }

    public JButton getStartButton(){
        return btnStart;
    }

    public JButton getExistButton(){
        return btnExit;
    }

    public ImageIcon getIconStartClick() {
        return iconStartClick;
    }

    public ImageIcon getIconExitClick() {
        return iconExitClick;
    }

    public Icon getIconStartImage() {
        return iconStartImage;
    }

    public Icon getIconExitImage() {
        return iconExitImage;
    }

}
