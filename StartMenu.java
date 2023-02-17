import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;
import java.awt.*;


public class StartMenu extends JFrame{

    JLabel startClick;
    JLabel stopClick;
    ImageIcon iconStart_Click;
    ImageIcon iconStart;
    ImageIcon iconStop_Click;
    ImageIcon iconStop;
    ImageIcon hiImg;
    JLabel nametopic;

    StartMenu(){
        importIcon();
        btnClick();
        nameGame();
        menuFrame(); 
    }

    void nameGame(){
        nametopic = new JLabel();
        nametopic.setText("WhiteJack");
        nametopic.setHorizontalAlignment(JLabel.CENTER);
        nametopic.setVerticalAlignment(JLabel.TOP);
        nametopic.setFont(new Font("MV Boli",Font.PLAIN,100));
    }

    void btnClick(){
              
        startClick = new JLabel();
        startClick.setIcon(iconStart);
        startClick.setBounds(295, 300, 400, 100);
        // startClick.setOpaque(true);

        stopClick = new JLabel();
        stopClick.setIcon(iconStop);
        stopClick.setBounds(295, 500, 400, 100);
        // stopClick.setOpaque(true);

        startClick.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start Game");              
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startClick.setIcon(iconStart_Click);
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startClick.setIcon(iconStart);
                    }    
                },200);
                
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });

        stopClick.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Quit Game");
                System.exit(0);
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                stopClick.setIcon(iconStop_Click);
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                stopClick.setIcon(iconStop);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
    }

    void importIcon(){
        iconStart = new ImageIcon(new ImageIcon("image/Start-Button.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStart_Click = new ImageIcon(new ImageIcon("image/Start-Button-Click.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStop = new ImageIcon(new ImageIcon("image/Quit-Button.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStop_Click = new ImageIcon(new ImageIcon("image/Quit-Buttom_Click.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        
        hiImg = new ImageIcon(new ImageIcon("image/Hi_Img.jpg").getImage().getScaledInstance(1000, 800, DO_NOTHING_ON_CLOSE));
    }

    void menuFrame(){
        JFrame frame = new JFrame("White Jack");
        JLabel background = new JLabel(hiImg);
        background.setBounds(0, 100, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLayout(null);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.add(stopClick);
        frame.add(startClick);
        frame.add(nametopic);
        frame.setVisible(true);
        frame.getContentPane().add(background);
    }

}
    