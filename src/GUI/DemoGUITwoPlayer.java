package src.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ColorUIResource;

import src.model.BackButton;
import src.model.Card;
import src.model.Deck;
import src.model.DrawCardButton;
import src.model.Round;
import src.model.Player;
import src.WaitingForConnection.DefaultFramWin;
import src.logic.CheckWin2P;
import src.WaitingForConnection.Playmusic;

public class DemoGUITwoPlayer{
    private Round lg = new Round();

    private int xPosLy;
    private int yPosLy;
    private int xPosCard = 0;
    private int yPosCard = 0;
    
    private int cntZOrder = 0;

    private boolean swap = false;
    private boolean swapPlayer = true;
    private boolean pressStand = false;

    private JLayeredPane layer1;
    private JLayeredPane layer2;

    private JButton btnSurrender; //Give up
    private JButton btnStand; //Next Player

    private Deck deck;
    private Player player1;
    private Player player2;
    private CheckWin2P cwLogic;
    private DrawCardButton btnDraw;
    private BackButton btnBack;

    private JLabel mainFrame;

    private JLabel drawText;
    private JLabel roundText;
    private JLabel whiteJackNumber;
    private JLabel bg;
    private JLabel sumScoreP1;
    private JLabel sumScoreP2;

    private ImageIcon backgroundGame;

    private ClickListener cl;
    Playmusic sounddraw= new Playmusic();
    public DemoGUITwoPlayer(){
        initVariable();
        initLayer();
        initButton();
        initFrame();
        defaultGame();
        initLogic();
    }   
    
    void initVariable(){
        backgroundGame = new ImageIcon(new ImageIcon("asset/image/backgroundGame.png").getImage().getScaledInstance(1000, 800, 0));

        mainFrame = new JLabel();

        layer1 = new JLayeredPane();
        layer2 = new JLayeredPane();

        btnStand = new JButton("Stand");
        btnSurrender = new JButton("New Game");

        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        cwLogic = new CheckWin2P();
        btnDraw = new DrawCardButton();
        btnBack = new BackButton();

        drawText = new JLabel("Draw");
        roundText = new JLabel("ROUND " + lg.getRound());
        whiteJackNumber = new JLabel("< " + cwLogic.getVictory());
        
        bg = new JLabel(backgroundGame);
        bg.setBounds(0, 0, 1000, 800);

        cl = new ClickListener();
        
        sumScoreP1 = new JLabel("");
        sumScoreP2 = new JLabel("");
    }

    void initLayer(){
        xPosLy = 10;
        yPosLy = 10;

        mainFrame.setBounds(0, 0, 1000, 800);

        roundText.setForeground(new ColorUIResource(255,215,0));
        bg.setBounds(0, 0, 1000, 800);

        layer1.setBounds(xPosLy, yPosLy, 200, 800);
        layer2.setBounds(xPosLy+822, yPosLy, 200, 800);

        DefaultFramWin.customFont(drawText, 100);
        drawText.setBounds(350, 250, 500, 300);
        drawText.setForeground(new ColorUIResource(255,250,250));

        DefaultFramWin.customFont(roundText, 80);
        roundText.setBounds(325, 120, 600, 100);

        DefaultFramWin.customFont(whiteJackNumber, 100);
        whiteJackNumber.setBounds(325, 20, 800, 100);
        whiteJackNumber.setForeground(new ColorUIResource(255,250,250));

        DefaultFramWin.customFont(sumScoreP1, 80);
        DefaultFramWin.customFont(sumScoreP2, 80);
        sumScoreP1.setBounds(25, 600 , 200, 100);
        sumScoreP2.setBounds(825, 600 , 200, 100);
        sumScoreP1.setForeground(new ColorUIResource(255,215,0));
        sumScoreP2.setForeground(new ColorUIResource(255,215,0));
        sumScoreP1.setVisible(false);
        sumScoreP2.setVisible(false);
    }

    void initFrame(){
        mainFrame.add(roundText);
        mainFrame.add(drawText).setVisible(false);
        mainFrame.add(whiteJackNumber);
        mainFrame.add(sumScoreP1);
        mainFrame.add(sumScoreP2);
        mainFrame.add(layer1);
        mainFrame.add(layer2);
        mainFrame.add(btnDraw.getLabel());
        mainFrame.add(btnBack.getLabel());
        mainFrame.add(btnStand);
        mainFrame.add(btnSurrender);
        mainFrame.setIcon(backgroundGame);
        mainFrame.setVisible(false);
    }

    void initButton(){
        btnDraw.getLabel().setLocation(375,300);
        btnStand.setBounds(450, 500, 100, 40);
        btnStand.setFocusable(false);
        btnSurrender.setBounds(450, 550, 100, 40);
        btnSurrender.setFocusable(false);
    }

    void initLogic(){

        btnDraw.getLabel().addMouseListener(cl);
        btnBack.getLabel().addMouseListener(cl);
        btnStand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                pressStand = true;
                if(!swapPlayer){
                    draw();
                    swapPlayer = true;
                }
                else{
                    swap = (lg.getRound() % 2 == 0)? false:true;
                    if(swap == false){
                        whiteJackNumber.setText("< "+cwLogic.getVictory());
                    }
                    else{
                        whiteJackNumber.setText("  "+cwLogic.getVictory() + " >");
                    }
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
                whiteJackNumber.setText("< " + cwLogic.getVictory());
                mainFrame.repaint();
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
        
        btnDraw.getLabel().setVisible(false);
        btnStand.setEnabled(false);
        btnSurrender.setEnabled(false);
        sumScoreP1.setText(Integer.toString(player1.getSumScore()));
        sumScoreP2.setText(Integer.toString(player2.getSumScore()));
        sumScoreP1.setVisible(true);
        sumScoreP2.setVisible(true);
    }

    public void enableBtn(){
        btnDraw.getLabel().setVisible(true);
        btnStand.setEnabled(true);
        btnSurrender.setEnabled(true);
        sumScoreP1.setVisible(false);
        sumScoreP2.setVisible(false);
    }
    
    public void reset(){
        checkWin();
        swap = (lg.getRound() %2 == 0) ? false:true;
        if(swap == false){
            whiteJackNumber.setText("< "+cwLogic.getVictory());
        }
        else{ 
            whiteJackNumber.setText("  "+cwLogic.getVictory() + " >");
        }
        pressStand = false;
        swapPlayer = true;
    
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
        btnSurrender.setLocation(450, 550);
        btnStand.setEnabled(true);
        
        player1.clearCard();
        player1.resetSumScore();
        player2.clearCard();        
        player2.resetSumScore();   

        defaultGame();
        mainFrame.repaint();
    } 

    void checkWin(){
        if(player1.getWinCollect() == 6 || player2.getWinCollect() == 6){
            Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    cwLogic.reset(player1, player2); 
                    whiteJackNumber.setText("< " + cwLogic.getVictory());
                    mainFrame.repaint();
                }    
            },500);
            lg.resetRound();
        }
    }

    void defaultGame(){

        Card c = deck.getCardRand(player1,player2);
        player1.setListCard(c);
        player1.setSumScore(c.getRank());

        c.getLabelFront().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
        layer1.add(c.getLabelFront(),Integer.valueOf(0));    
        
        c = deck.getCardRand(player1,player2);
        player2.setListCard(c);
        player2.setSumScore(c.getRank());

        c.getLabelFront().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p2: "+player2.getSumScore());
        layer2.add(c.getLabelFront(),Integer.valueOf(0));  

        cntZOrder++;
        yPosCard+=50;

        if(player1.getListCard().size() == 1 && player2.getListCard().size() == 1){
            btnStand.setEnabled(false);
        }
    }

    public JLabel getMainFrame() {
        return mainFrame;
    }  
    
    private class ClickListener implements MouseInputListener{
    
        @Override
        public void mouseClicked(MouseEvent e) {
            
            JLabel jlb = (JLabel)e.getSource();
            // TODO Auto-generated method stub
            if(jlb == btnDraw.getLabel()){
                sounddraw.Playmusics(("asset/sound/sounddrawcard.wav"));
                if(swap){
                    Card c = deck.getCardRand(player1,player2);

                    player2.setListCard(c);
                    player2.setSumScore(c.getRank());

                    c.getLabelFront().setLocation(xPosCard, yPosCard);

                    yPosCard += 50;

                    System.out.println(c.getRank()+" "+c.getType()+" p2: "+player2.getSumScore());
                    layer2.add(c.getLabelFront(),Integer.valueOf(cntZOrder++));

                    cwLogic.checkWin(player1, player2);

                    if(player2.getSumScore() == player1.getSumScore() && player1.getListCard().size() > 1){
                        swapPlayer = false;
                        System.out.println("Stand : "+ swapPlayer);
                        btnStand.setEnabled(true);
                        mainFrame.repaint();
                    }
                }
                else if(!swap){
                    Card c = deck.getCardRand(player1,player2);
                    
                    player1.setListCard(c);
                    player1.setSumScore(c.getRank());
                    
                    c.getLabelFront().setLocation(xPosCard, yPosCard);
                    yPosCard += 50;
                    
                    System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
                    
                    layer1.add(c.getLabelFront(),Integer.valueOf(cntZOrder++));

                    cwLogic.checkWin(player1, player2);

                    if(player2.getSumScore() == player1.getSumScore() && player2.getListCard().size() > 1){
                        swapPlayer = false;
                        System.out.println("Stand : "+ swapPlayer);
                        btnStand.setEnabled(true);
                        mainFrame.repaint();
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

                if(!pressStand && (player1.getListCard().size() > 1 || player2.getListCard().size() > 1)){
                    btnStand.setEnabled(true);
                }
            }
            if((JLabel)e.getSource() == btnBack.getLabel()){
                mainFrame.setVisible(false);
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
            if(jlb == btnBack.getLabel()){
                btnBack.setImgYellow();
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
            if(jlb == btnBack.getLabel()){
                btnBack.setImgBlack();
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
}