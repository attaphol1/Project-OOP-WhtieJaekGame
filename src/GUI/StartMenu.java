package src.GUI;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import java.awt.*;


public class StartMenu extends JFrame{
    JLabel mainFrame;

    JLabel startClick;
    JLabel stopClick;
    ImageIcon iconStart_Click;
    ImageIcon iconStart;
    ImageIcon iconStop_Click;
    ImageIcon iconStop;
    ImageIcon hiImg;
    JLabel nametopic;

    JFrame frame;

    ClickListener cl = new ClickListener();

    DemoGUI demo = new DemoGUI();
    LoadingFrame loading = new LoadingFrame(5);

    public StartMenu(){
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

        startClick.addMouseListener(cl);

        stopClick.addMouseListener(cl);
    }

    void importIcon(){
        iconStart = new ImageIcon(new ImageIcon("asset/image/Start-Button.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStart_Click = new ImageIcon(new ImageIcon("asset/image/Start-Button-Click.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStop = new ImageIcon(new ImageIcon("asset/image/Quit-Button.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        iconStop_Click = new ImageIcon(new ImageIcon("asset/image/Quit-Buttom_Click.png").getImage().getScaledInstance(400, 100, DO_NOTHING_ON_CLOSE));
        
        hiImg = new ImageIcon(new ImageIcon("asset/image/Hi_Img.jpg").getImage().getScaledInstance(1000, 800, DO_NOTHING_ON_CLOSE));
    }

    void menuFrame(){
        mainFrame = new JLabel();
        mainFrame.setBounds(0, 0, 1000, 800);

        frame = new JFrame("White Jack");
        // JLabel background = new JLabel(hiImg);
        // background.setBounds(0, 0, 800, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLayout(null);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        mainFrame.add(stopClick);
        mainFrame.add(startClick);
        // mainFrame.add(nametopic);
        mainFrame.setIcon(hiImg);

        frame.add(mainFrame);
        frame.add(demo.getMainFrame());
        frame.add(loading.getMainFrame());
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private class ClickListener implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == startClick){
                System.out.println("Start Game"); 
            }
            else if(sourse == stopClick){
                System.out.println("Quit Game");
                System.exit(0);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == startClick){
                startClick.setIcon(iconStart_Click);
            }
            else if(sourse == stopClick){
                stopClick.setIcon(iconStop_Click);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == startClick){
                Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            startClick.setIcon(iconStart);
                            loading.getMainFrame().setVisible(false);
                            demo.getMainFrame().setVisible(true);
                            frame.repaint();
                        }    
                    },5000);
                    
                    mainFrame.setVisible(false);
                    loading.getMainFrame().setVisible(true);
                    loading.start(frame);
            }
            else if(sourse == stopClick){
                stopClick.setIcon(iconStop);
            }
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

    }

}
    