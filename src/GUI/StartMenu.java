package src.GUI;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import src.WaitingForConnection.Playmusic;


public class StartMenu extends JFrame{
    JLabel mainFrame;

    JLabel startClick;
    JLabel stopClick;
    JLabel p1Click;
    JLabel p2Click;
    ImageIcon iconStop_Click;
    ImageIcon iconStop;
    ImageIcon hiImg;
    ImageIcon nTopic;
    ImageIcon iconP1;
    ImageIcon iconP1_Click;
    ImageIcon iconP2;
    ImageIcon iconP2_Click;
    JLabel nametopic;

    JFrame frame;

    ClickListener cl = new ClickListener();

    DemoGUIOnePlayer demoP1 = new DemoGUIOnePlayer();
    DemoGUITwoPlayer demoP2 = new DemoGUITwoPlayer();
    Playmusic Sound= new Playmusic();

    public StartMenu(){
        importIcon();
        btnClick();
        nameGame();
        menuFrame(); 
    }

    void nameGame(){
        nametopic = new JLabel();
        nametopic.setIcon(nTopic);
        nametopic.setBounds(100, 25, 750, 110);
    }

    void btnClick(){
        stopClick = new JLabel();
        stopClick.setIcon(iconStop);
        stopClick.setBounds(362, 600, 275, 115);

        p1Click=new JLabel();
        p1Click.setIcon(iconP1);
        p1Click.setBounds(362, 200, 275, 115);

        p2Click=new JLabel();
        p2Click.setIcon(iconP2);
        p2Click.setBounds(362, 400, 275, 115);

        stopClick.addMouseListener(cl);
        
        p1Click.addMouseListener(cl);

        p2Click.addMouseListener(cl);
    }

    void importIcon(){
        iconStop = new ImageIcon(new ImageIcon("asset/image/Quit-Button.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        iconStop_Click = new ImageIcon(new ImageIcon("asset/image/Quit-Buttom_Click.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        iconP1 = new ImageIcon(new ImageIcon("asset/image/1p.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        iconP1_Click = new ImageIcon(new ImageIcon("asset/image/1p-click.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        iconP2 = new ImageIcon(new ImageIcon("asset/image/2p.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        iconP2_Click = new ImageIcon(new ImageIcon("asset/image/2p-click.png").getImage().getScaledInstance(275, 115, DO_NOTHING_ON_CLOSE));
        nTopic = new ImageIcon(new ImageIcon("asset/image/name-topic.png").getImage().getScaledInstance(750, 110, DO_NOTHING_ON_CLOSE));
        hiImg = new ImageIcon(new ImageIcon("asset/image/king-heart-meme.jpg").getImage().getScaledInstance(1008, 1040, DO_NOTHING_ON_CLOSE));
    }

    void menuFrame(){
        mainFrame = new JLabel();
        mainFrame.setBounds(0, 0, 1000, 800);

        frame = new JFrame("White Jack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        mainFrame.add(stopClick);
        mainFrame.add(p1Click);
        mainFrame.add(p2Click);
        mainFrame.add(nametopic);
        mainFrame.setIcon(hiImg);
        // Sound.Playmusics("asset/Sound/soundbackground.wav");
        

        frame.add(demoP1.getMainFrame());
        frame.add(demoP2.getMainFrame());
        frame.add(mainFrame);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private class ClickListener implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == stopClick){
                System.out.println("Quit Game");
                System.exit(0);
            }else if(sourse == p1Click){
                System.out.println("1 Player Game");
            }else if(sourse == p2Click){
                System.out.println("2 Player Game");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == stopClick){
                stopClick.setIcon(iconStop_Click);
            }else if(sourse == p1Click){
                p1Click.setIcon(iconP1_Click);
            }else if(sourse == p2Click){
                p2Click.setIcon(iconP2_Click);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel sourse = (JLabel)(e.getSource());
            if(sourse == p1Click){
                Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            p1Click.setIcon(iconP1);
                            mainFrame.setVisible(false);
                            demoP1.getMainFrame().setVisible(true);
                            frame.repaint();
                        }    
                    },1000);
            }else if(sourse == p2Click){
                Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            p2Click.setIcon(iconP2);
                            mainFrame.setVisible(false);
                            demoP2.getMainFrame().setVisible(true);
                            frame.repaint();
                        }    
                    },1000);
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
    