package src.GUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import src.model.Card;
import src.model.Deck;
import src.model.LogicGUI;
import src.model.Player;
import src.WaitingForConnection.DefaltFramWin;
import src.logic.CheckWinLogic;
import src.model.LogicGUI;

public class DemoGUI{
    private LogicGUI lg = new LogicGUI();

    private int xPosLy;
    private int yPosLy;
    private int xPosCard = 0;
    private int yPosCard = 0;
    
    private int cntZOrder = 0;

    private boolean swap = false;
    private boolean standP2 = false;

    private JFrame frame;

    private JLayeredPane layer1;
    private JLayeredPane layer2;

    private JButton btnHit; //Draw
    private JButton btnSurrender; //Give up
    private JButton btnStand; //Next Player

    private Deck deck;
    private Player player1;
    private Player player2;
    private CheckWinLogic cwLogic;

    private JLabel drawText;
    
    public DemoGUI(){
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
        btnSurrender = new JButton("Reset");

        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        cwLogic = new CheckWinLogic();

        drawText = new JLabel("Draw");
        drawText.setFont(new Font("SF Pixelate Shaded",Font.PLAIN,100));
        drawText.setBounds(350, 50, 500, 300);
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

                    System.out.println(c.getRank()+" "+c.getType()+" p2: "+player2.getSumScore());
                    layer2.add(c.getLabel(),Integer.valueOf(cntZOrder++));

                    cwLogic.checkWin(player1, player2);

                    if(player2.getSumScore() == player1.getSumScore()){
                        standP2 = true;
                        btnSurrender.setLocation(450, 450);
                        frame.add(btnStand);
                        frame.repaint();
                    }

                    if(cwLogic.isCheck()){
                        enableFalse();
                        Timer timer1 = new Timer();
                        timer1.schedule(new TimerTask() {
                        @Override
                            public void run() {
                            enableTrue();
                            reset();
                            }    
                        },2000);
                        cwLogic.setCheck(false);
                    }
                }
                else{
                    Card c = deck.getCardRand(player1,player2);

                    player1.setListCard(c);
                    player1.setSumScore(c.getRank());
                    
                    c.getLabel().setLocation(xPosCard, yPosCard);
                    yPosCard += 50;
                    
                    System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
                    
                    layer1.add(c.getLabel(),Integer.valueOf(cntZOrder++));
                    
                    cwLogic.checkWin(player1, player2);

                    if(player2.getSumScore() == player1.getSumScore() && player1.getSumScore() != 0){
                        standP2 = true;
                        btnSurrender.setLocation(450, 450);
                        frame.add(btnStand);
                        frame.repaint();
                    }
                    
                    if(cwLogic.isCheck()){
                        enableFalse();
                        Timer timer1 = new Timer();
                        timer1.schedule(new TimerTask() {
                        @Override
                            public void run() {
                            enableTrue();
                            reset();
                            }    
                        },2000);

                        cwLogic.setCheck(false);
                    }

                    // frame.repaint();
                    
                }
            }
        });

        btnStand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                if(standP2){
                    draw();
                    standP2 = false;
                    reset();
                }
                else{
                    if(lg.getRound() % 2 == 0){
                        swap = false;
                        lg.setCheckStanTrue();
                        cwLogic.setStan(lg.getCheckStan());
                    }else{ swap = true;}
                    yPosCard = 0;
                    cntZOrder = 0;
                    frame.remove(btnStand);
                    btnSurrender.setLocation(450, 400);
                }
            }
        });

        btnSurrender.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                lg.resetRound();
                reset();        
            }
            
        });
        
    }
    Timer timer1;
    private void draw() {
        System.out.println("draw");
        frame.add(drawText);
        frame.repaint();
        enableFalse();
        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    frame.remove(drawText);
                    frame.repaint();
                    enableTrue();
                }    
            },2000);
        reset();
    }

    public void enableFalse(){
        btnHit.setEnabled(false);
        btnStand.setEnabled(false);
        btnSurrender.setEnabled(false);
    }

    public void enableTrue(){
        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnSurrender.setEnabled(true);
    }
    
    //------------------- Play zone -------------------------//
    // private int lose1 = 0;
    public void reset(){
        if(lg.getRound() % 2 == 0){
            swap = false;
        }else{ swap = true; }
        
        lg.setRound(1);
        lg.setCheckStanFalse();
        cwLogic.setRound(lg.getRound());
        cwLogic.setStan(lg.getCheckStan());
        System.out.println("Round in Demo :"+lg.getRound());

        xPosLy = 10;
        yPosLy = 10;
        yPosCard = 0;
        cntZOrder = 0;
        layer1.removeAll();
        layer2.removeAll();
        btnSurrender.setLocation(450, 450);
        frame.add(btnStand);
        
        player1.clearCard();
        player1.resetSumScore();
        player2.clearCard();        
        player2.resetSumScore();   

        frame.repaint();
    }
    
//     private int sumPlayer1 = 0;
//     private int lose2 = 0;
//     private int sumPlayer2 = 0;
//     private Timer timer1 = new Timer();

//     private DefaltFramWin df = new DefaltFramWin();

//     public void setNum1(int num){       
//         sumPlayer1 += num;

//         if(sumPlayer1 > 21){
//             timer1.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     df.statusPlayerTwoWin();
//                     lose1++;
//                     df.playerTwoWin(lose1);
//                     reset();
//                 }    
//             },1000);
            
//         }else if(sumPlayer1 == 21){
//             timer1.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     df.statusPlayerTwoWin();
//                     lose2++;
//                     df.playerOneWin(lose2);
//                     reset();
//                 }    
//             },1000);
            
//         }
//     }

//     public void setNum2(int num){
//         sumPlayer2 += num;

//         if(sumPlayer2 > 21){
//             timer1.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     df.statusPlayerOneWin();
//                     lose2++;
//                     df.playerTwoWin(lose2);
//                     reset();
//                 }    
//             },1000);     
//         }else if(sumPlayer2 > sumPlayer1 && sumPlayer2 < 21){
//             timer1.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     df.statusPlayerOneWin();
//                     lose1++;
//                     df.playerOneWin(lose1);
//                     reset();
//                 }    
//             },1000);      
//         }else if(sumPlayer2 == 21){
//             timer1.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     df.statusPlayerOneWin();
//                     lose1++;
//                     df.playerOneWin(lose1);
//                     reset();
//                 }    
//             },1000);      
//         }   
//     }
//     //------------------- Play zone -------------------------//

    
}
