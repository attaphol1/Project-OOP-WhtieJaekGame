import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Game {
    private JFrame frame; 
    private JPanel panel;

    private StartGUI startGUI;
    private JButton btnStart;
    private JButton btnExit;

    private int width;
    private int height;
    
    public Game(){
        initVariable();
        initWindow();
        update();
    }

    public void initWindow(){
        btnStart.setBounds(100, 200, 200, 100);
        btnExit.setBounds(400, 200, 200, 100);

        btnStart.setSize(200, 100);
        btnExit.setSize(200, 100);
        btnStart.setBorderPainted(false);
        btnStart.setFocusPainted(false);
        btnStart.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setFocusPainted(false);
        btnExit.setContentAreaFilled(false);

        btnStart.add(Box.createHorizontalGlue());
        btnStart.add(Box.createVerticalGlue());
        btnExit.add(Box.createHorizontalGlue());
        btnExit.add(Box.createVerticalGlue());

        btnStart.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                btnStart.setIcon(startGUI.getIconStartClick());
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                btnStart.setIcon(startGUI.getIconStartImage());

                
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
        
        btnExit.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                btnExit.setIcon(startGUI.getIconExitClick());
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                btnExit.setIcon(startGUI.getIconExitImage());
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
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(btnStart);
        panel.add(btnExit);

        frame.add(panel);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initVariable(){
        frame = new JFrame("White Jack");

        panel = new JPanel();

        startGUI = new StartGUI();
        btnStart = startGUI.getStartButton();
        btnExit = startGUI.getExistButton();

        width = 800;
        height = 600;
    }

    public void update(){

    }

}
