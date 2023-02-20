package src.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import src.model.Card;
import src.model.Deck;
import src.model.Player;
import src.WaitingForConnection.DefaltFramWin;
import src.WaitingForConnection.WinGame;

public class DemoGUI{

    private int xPosLy;
    private int yPosLy;
    private int xPosCard = 0;
    private int yPosCard = 0;
    
    private int cntZOrder = 0;

    private boolean swap = false;

    private JFrame frame;

    private JLayeredPane layer1;
    private JLayeredPane layer2;

    private JButton btnHit; //Draw
    private JButton btnSurrender; //Give up
    private JButton btnStand; //Next Player

    private Deck deck;
    private Player player1;
    private Player player2;

    
    DemoGUI(){
        initVariable();
        initLayer();
        initButton();
        initFrame();
        initLogic();
    }   
    
    void initVariable(){
        frame = new JFrame("Demo WhiteJack");

        layer1 = new JLayeredPane();
        layer2 = new JLayeredPane();

        btnHit = new JButton("Hit");
        btnStand = new JButton("Stand");
        btnSurrender = new JButton("Surrender");

        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
    }

    void initLayer(){
        xPosLy = 10;
        yPosLy = 10;
        layer1.setBounds(xPosLy, yPosLy, 200, 800);
        layer2.setBounds(xPosLy+822, yPosLy, 200, 800);
    }

    void initFrame(){
        frame.add(layer1);
        frame.add(layer2);
        frame.add(btnHit);
        frame.add(btnStand);
        frame.add(btnSurrender);
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initButton(){
        btnHit.setBounds(450, 350, 50, 40);
        btnStand.setBounds(450, 400, 100, 40);
        btnSurrender.setBounds(450, 450, 100, 40);
    }

    void initLogic(){

        btnHit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if(swap){
                    Card c = deck.getCardRand(player1,player2);
                    player2.setListCard(c);
                    player2.setSumScore(c.getRank());
                    c.getLabel().setLocation(xPosCard, yPosCard);
                    yPosCard += 50;
                    System.out.println(c.getRank()+" "+c.getType());
                    layer2.add(c.getLabel(),Integer.valueOf(cntZOrder++));
                    frame.repaint();

                    setNum2(c.getRank());
                }
                else{
                    Card c = deck.getCardRand(player1,player2);
                    player1.setListCard(c);
                    player1.setSumScore(c.getRank());
                    c.getLabel().setLocation(xPosCard, yPosCard);
                    yPosCard += 50;
                    System.out.println(c.getRank()+" "+c.getType());
                    layer1.add(c.getLabel(),Integer.valueOf(cntZOrder++));
                    frame.repaint();
                    
                    setNum1(c.getRank());
                }
            }
        });

        btnStand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                swap = true;
                yPosCard = 0;
                cntZOrder = 0;
                frame.remove(btnStand);
                btnSurrender.setLocation(450, 400);
            }
        });

        btnSurrender.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                df.resetWinGame();
                lose1 = 0;
                lose2 = 0;
                // TODO Auto-generated method stub
                reset();
                swap = false;
                xPosLy = 10;
                yPosLy = 10;
                yPosCard = 0;
                cntZOrder = 0;
                layer1.removeAll();
                layer2.removeAll();
                btnSurrender.setLocation(450, 450);
                frame.add(btnStand);
                frame.repaint();

                player1.clearCard();
                player2.clearCard();        
            }
            
        });
        
    }
    
    //------------------- Play zone -------------------------//
    private int lose1 = 0;
    public void reset(){
        sumPlayer1 = 0;
        sumPlayer2 = 0;

        swap = false;
        xPosLy = 10;
        yPosLy = 10;
        yPosCard = 0;
        cntZOrder = 0;
        layer1.removeAll();
        layer2.removeAll();
        btnSurrender.setLocation(450, 450);
        frame.add(btnStand);
        
        player1.clearCard();
        player2.clearCard();   
        
        frame.repaint();
    }
    
    private int sumPlayer1 = 0;
    private int lose2 = 0;
    private int sumPlayer2 = 0;

    private DefaltFramWin df = new DefaltFramWin();

    public void setNum1(int num){       
        sumPlayer1 += num;

        if(sumPlayer1 > 21){
            lose1++;
            df.playerTwoWin(lose1);
            reset();
        }else if(sumPlayer1 == 21){
            lose2++;
            df.playerOneWin(lose2);
            reset();
        }
    }

    public void setNum2(int num){
        sumPlayer2 += num;

        if(sumPlayer2 > 21){
            lose2++;
            df.playerTwoWin(lose2);
            reset();
        }else if(sumPlayer2 > sumPlayer1 && sumPlayer2 < 21){
            lose1++;
            df.playerOneWin(lose1);
            reset();
        }
        else if(sumPlayer2 == 21){
            lose1++;
            df.playerOneWin(lose1);
            reset();
        }
    }
    //------------------- Play zone -------------------------//

    
}