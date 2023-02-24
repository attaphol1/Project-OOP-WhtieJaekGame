package src.GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.plaf.ColorUIResource;

import src.model.Card;
import src.model.Deck;
import src.model.LogicGUI;
import src.model.Player;
import src.WaitingForConnection.DefaultFramWin;
import src.logic.CheckWinLogic;

public class DemoGUI{
    private LogicGUI lg = new LogicGUI();

    private int xPosLy;
    private int yPosLy;
    private int xPosCard = 0;
    private int yPosCard = 0;
    
    private int cntZOrder = 0;

    private boolean swap = false;
    private boolean swapPlayer = true;

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
    private JLabel roundText;
    private JLabel whiteJackNumber;
    private JLabel bg;

    private ImageIcon backgroundGame;
    public DemoGUI(){
        initVariable();
        initLayer();
        initButton();
        initFrame();
        defaultGame();
        initLogic();
    }   
    
    void initVariable(){
        backgroundGame = new ImageIcon(new ImageIcon("asset/image/backgroundGame.png").getImage().getScaledInstance(1000, 800, 0));

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
        roundText = new JLabel("ROUND " + lg.getRound());
        whiteJackNumber = new JLabel("Whitejack " + cwLogic.getVictory());
        
        bg = new JLabel(backgroundGame);
        bg.setBounds(0, 0, 1000, 800);
    }

    void initLayer(){
        xPosLy = 10;
        yPosLy = 10;

        roundText.setForeground(new ColorUIResource(255,215,0));
        bg.setBounds(0, 0, 1000, 800);

        layer1.setBounds(xPosLy, yPosLy, 200, 800);
        layer2.setBounds(xPosLy+822, yPosLy, 200, 800);

        DefaultFramWin.customFont(drawText, 100);
        drawText.setBounds(350, 400, 500, 300);
        drawText.setForeground(new ColorUIResource(255,250,250));

        DefaultFramWin.customFont(roundText, 100);
        roundText.setBounds(280, 20, 600, 100);

        DefaultFramWin.customFont(whiteJackNumber, 75);
        whiteJackNumber.setBounds(200, 50, 800, 300);
        whiteJackNumber.setForeground(new ColorUIResource(255,250,250));
    }

    void initFrame(){
        frame.add(roundText);
        frame.add(drawText).setVisible(false);
        frame.add(whiteJackNumber);
        frame.add(layer1);
        frame.add(layer2);
        frame.add(btnHit);
        frame.add(btnStand);
        frame.add(btnSurrender);
        frame.getContentPane().add(bg);
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
                        swapPlayer = false;
                        System.out.println("Stand : "+ swapPlayer);
                        btnStand.setEnabled(true);
                        frame.repaint();
                    }
                }
                else if(!swap){
                    Card c = deck.getCardRand(player1,player2);
                    
                    player1.setListCard(c);
                    player1.setSumScore(c.getRank());
                    
                    c.getLabel().setLocation(xPosCard, yPosCard);
                    yPosCard += 50;
                    
                    System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
                    
                    layer1.add(c.getLabel(),Integer.valueOf(cntZOrder++));

                    cwLogic.checkWin(player1, player2);

                    if(player2.getSumScore() == player1.getSumScore() && player1.getSumScore() != 0){
                        swapPlayer = false;
                        System.out.println("Stand : "+ swapPlayer);
                        btnStand.setEnabled(true);
                        frame.repaint();
                    }
                }
                if(cwLogic.isSomeOneWin()){
                    disableBtn();
                    Timer timer1 = new Timer();
                    timer1.schedule(new TimerTask() {
                    @Override
                        public void run() {
                        enableBtn();
                        reset();
                        }    
                    },5000);
                    cwLogic.setCheck(false);
                }
            }
        });

        btnStand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                if(!swapPlayer){
                    draw();
                    swapPlayer = true;
                }
                else{
                    swap = (lg.getRound() % 2 == 0)? false:true;
                    yPosCard = 50;
                    cntZOrder = 1;
                    btnStand.setEnabled(false);
                }
            }
        });

        btnSurrender.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cwLogic.reset(player1, player2);        
                lg.resetRound();
                reset();
            }
            
        });
        
    }
    
    private void draw() {
        System.out.println("draw");
        drawText.setVisible(true);
        disableBtn();
        Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    drawText.setVisible(false);
                    enableBtn();
                    reset();
                }    
            },5000);
    }

    public void disableBtn(){
        btnHit.setEnabled(false);
        btnStand.setEnabled(false);
        btnSurrender.setEnabled(false);
    }

    public void enableBtn(){
        btnHit.setEnabled(true);
        btnStand.setEnabled(true);
        btnSurrender.setEnabled(true);
    }
    
    public void reset(){
        checkWin();
        swap = (lg.getRound() %2 == 0) ? false:true;
    
        lg.setRound(1);
        cwLogic.setRound(lg.getRound());
        System.out.println("round "+lg.getRound());
        roundText.setText("ROUND " + lg.getRound());

        xPosLy = 10;
        yPosLy = 10;
        yPosCard = 0;
        cntZOrder = 0;
        layer1.removeAll();
        layer2.removeAll();
        btnSurrender.setLocation(450, 450);
        // frame.add(btnStand);
        btnStand.setEnabled(true);
        
        player1.clearCard();
        player1.resetSumScore();
        player2.clearCard();        
        player2.resetSumScore();   

        defaultGame();
        frame.repaint();
    } 

    void checkWin(){
        if(player1.getWinCollect() == 6 || player2.getWinCollect() == 6){
            Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    cwLogic.reset(player1, player2); 
                    whiteJackNumber.setText("Whitejack " + cwLogic.getVictory());
                    frame.repaint();
                }    
            },500);
            lg.resetRound();
        }
    }

    void defaultGame(){
        Card c = deck.getCardRand(player1,player2);
        player1.setListCard(c);
        player1.setSumScore(c.getRank());

        c.getLabel().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
        layer1.add(c.getLabel(),Integer.valueOf(0));    
        
        c = deck.getCardRand(player1,player2);
        player2.setListCard(c);
        player2.setSumScore(c.getRank());

        c.getLabel().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p2: "+player2.getSumScore());
        layer2.add(c.getLabel(),Integer.valueOf(0));  

        cntZOrder++;
        yPosCard+=50;
    }
}