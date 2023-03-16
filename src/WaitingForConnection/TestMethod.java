package src.WaitingForConnection;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.event.MouseInputListener;

import src.model.Card;
import src.model.Deck;
import src.model.DrawCardButton;
import src.model.Player;

public class TestMethod{
    JFrame frame;
    private JLabel mainFrame;
    
    private JLayeredPane layer1;
    private JLayeredPane layer2;

    private Deck deck;
    private Player player1;
    private Player bot;
    private DrawCardButton btnDraw;

    private int xPosLy = 0;
    private int yPosLy = 0;
    private int xPosCard = 0;
    private int yPosCard = 0;
    private int zOrder = 0;

    TestMethod(){
        frame = new JFrame("Test");
        mainFrame = new JLabel();
        layer1 = new JLayeredPane();
        layer2 = new JLayeredPane();
        deck = new Deck();
        player1 = new Player();
        bot = new Player();
        btnDraw = new DrawCardButton();

        btnDraw.getLabel().setLocation(375,300);
        btnDraw.getLabel().addMouseListener(new ClickHandle());

        mainFrame.setBounds(0,0,1000,800);

        layer1.setBounds(xPosLy, yPosLy, 200, 800);
        layer2.setBounds(xPosLy+822, yPosLy, 200, 800);

        mainFrame.add(layer1);
        mainFrame.add(layer2);
        mainFrame.add(btnDraw.getLabel());
        frame.add(mainFrame);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ClickHandle implements MouseInputListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel jlb = (JLabel)e.getSource();
            // TODO Auto-generated method stub
            if(jlb == btnDraw.getLabel()){
                Card c = deck.getCardRand(player1,bot);
                
                player1.setListCard(c);
                player1.setSumScore(c.getRank());
                
                c.getLabel().setLocation(xPosCard, yPosCard);
                yPosCard += 50;
                
                System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
                layer1.add(c.getLabel(),Integer.valueOf(zOrder++));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel jlb = (JLabel)e.getSource();
            if(jlb == btnDraw.getLabel()){
                btnDraw.setBorder();
                mainFrame.repaint();
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            JLabel jlb = (JLabel)e.getSource();
            if(jlb == btnDraw.getLabel()){
                btnDraw.removeBorder();
                mainFrame.repaint();
            }
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



    public static void main(String[] args) {
        new TestMethod();
    }
}