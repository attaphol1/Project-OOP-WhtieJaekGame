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

import src.model.Bot;
import src.model.Card;
import src.model.Deck;
import src.model.DrawCardButton;
import src.model.LogicGUI;
import src.model.Player;
import src.WaitingForConnection.DefaultFramWin;
import src.WaitingForConnection.Playmusic;
import src.logic.CheckWin1P;
import src.WaitingForConnection.Playmusic;

public class DemoGUIOnePlayer{
    private LogicGUI lg = new LogicGUI();

    private int xPosLy = 10;
    private int yPosLy = 10;
    private int xPosCard = 0;
    private int yPosCard = 0;
    
    private int cntZOrder = 0;

    private JLayeredPane layer1;
    private JLayeredPane layer2;

    private JButton btnSurrender; //Give up
    private JButton btnStand; //Next Player

    private Deck deck;
    private Player player1;
    private Bot bot;
    private CheckWin1P cwLogic;
    private DrawCardButton btnDraw;

    private JLabel mainFrame;

    private JLabel drawText;
    private JLabel roundText;
    private JLabel whiteJackNumber;
    private JLabel bg;
    private JLabel sumScoreP1;
    private JLabel sumScoreP2;

    private ImageIcon backgroundGame;

    private ClickListener cl;
    private Playmusic soundDraw = new Playmusic();
    public DemoGUIOnePlayer(){
        initVariable();
        initLayer();
        initButton();
        initFrame();
        defaultGame();
        // initLogic();
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
        bot = new Bot();
        cwLogic = new CheckWin1P();
        btnDraw = new DrawCardButton();

        drawText = new JLabel("Draw");
        roundText = new JLabel("ROUND " + lg.getRound());
        whiteJackNumber = new JLabel(Integer.toString(cwLogic.getVictory()));
        
        bg = new JLabel(backgroundGame);
        bg.setBounds(0, 0, 1000, 800);

        cl = new ClickListener();

        sumScoreP1 = new JLabel("");
        sumScoreP2 = new JLabel("");
    }

    void initLayer(){

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
        whiteJackNumber.setBounds(425, 20, 800, 100);
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
        mainFrame.add(btnStand);
        mainFrame.add(btnSurrender);
        mainFrame.setIcon(backgroundGame);
        mainFrame.setVisible(false);
    }

    void initButton(){
        btnDraw.getLabel().setLocation(375,300);
        btnStand.setBounds(450, 500, 100, 40);
        btnSurrender.setBounds(450, 550, 100, 40);
        btnDraw.getLabel().addMouseListener(cl);
        btnStand.addActionListener(new ActionHandle());
        btnSurrender.addActionListener(new ActionHandle());
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
        sumScoreP2.setText(Integer.toString(bot.getSumScore()));
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
        whiteJackNumber.setText(Integer.toString(cwLogic.getVictory()));
    
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
        
        player1.clearCard();
        player1.resetSumScore();
        bot.clearCard();        
        bot.resetSumScore();   

        defaultGame();
        mainFrame.repaint();
    } 

    void checkWin(){
        if(player1.getWinCollect() == 6 || bot.getWinCollect() == 6){
            Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    cwLogic.reset(player1, bot); 
                    whiteJackNumber.setText(Integer.toString(cwLogic.getVictory()));
                    mainFrame.repaint();
                }    
            },500);
            lg.resetRound();
        }
    }

    void defaultGame(){

        Card c = deck.getCardRand(player1,bot);
        player1.setListCard(c);
        player1.setSumScore(c.getRank());

        c.getLabelFront().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
        layer1.add(c.getLabelFront(),Integer.valueOf(0));    
        
        c = deck.getCardRand(player1,bot);
        bot.setListCard(c);
        bot.setSumScore(c.getRank());

        c.getLabelFront().setLocation(xPosCard, yPosCard);
        c.getLabelBack().setLocation(xPosCard, yPosCard);

        System.out.println(c.getRank()+" "+c.getType()+" p2: "+bot.getSumScore());
        layer2.add(c.getLabelBack(),Integer.valueOf(0));  

        cntZOrder = 1;
        yPosCard+=50;

        if(lg.getRound() %2 == 0){
            botPlay();
            btnStand.setEnabled(false);
            yPosCard = 50;
        }

        if(player1.getListCard().size() == 1 && bot.getListCard().size() == 1){
            btnStand.setEnabled(false);
        }
    }

    public JLabel getMainFrame() {
        return mainFrame;
    }  

    void checkSomeOneWin(){
        if(cwLogic.isSomeOneWin()){
            disableBtn();
            Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
            @Override
                public void run() {
                enableBtn();
                reset();
                }    
            },6000);
            cwLogic.setCheck(false);
        }
    }

    void botPlay(){
        soundDraw.Playmusics(("asset/sound/sounddrawcard.wav"));
        while(bot.getSumScore() < cwLogic.getVictory()-9){
            Card c = deck.getCardRand(player1,bot);

            bot.setListCard(c);
            bot.setSumScore(c.getRank());
            
            c.getLabelFront().setLocation(xPosCard, yPosCard);
            c.getLabelBack().setLocation(xPosCard, yPosCard);
            layer2.add(c.getLabelBack(),Integer.valueOf(cntZOrder++));
            
            yPosCard += 50;
            
            System.out.println(c.getRank()+" "+c.getType()+" p2: "+bot.getSumScore());

        }
    }
    private class ClickListener implements MouseInputListener{
    
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            if((JLabel)e.getSource() == btnDraw.getLabel()){
                soundDraw.Playmusics(("asset/sound/sounddrawcard.wav"));
                Card c = deck.getCardRand(player1,bot);
                
                player1.setListCard(c);
                player1.setSumScore(c.getRank());
                
                c.getLabelFront().setLocation(xPosCard, yPosCard);
                yPosCard += 50;
                
                System.out.println(c.getRank()+" "+c.getType()+" p1: "+player1.getSumScore());
                layer1.add(c.getLabelFront(),Integer.valueOf(cntZOrder++));

                if(lg.getRound() % 2 == 0 || (lg.getRound() % 2 == 1 && (player1.getListCard().size() > 1))){
                    btnStand.setEnabled(true);
                }
                if(player1.getSumScore() > cwLogic.getVictory()){
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bot.showCard(layer2);
                        }    
                    },1000);
                    cwLogic.checkWin(player1, bot);
                    checkSomeOneWin();
                }
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

    private class ActionHandle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JButton b = (JButton)e.getSource();
            if(b == btnStand){
                if(lg.getRound() % 2 == 0){
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bot.showCard(layer2);
                        }    
                    },1000);
                    if(player1.getSumScore() == bot.getSumScore()){
                        draw();
                    }
                    else{
                        cwLogic.checkWin(player1, bot);
                    }
                    checkSomeOneWin();
                    btnStand.setEnabled(false);
                }
                else{
                    yPosCard = 50;
                    botPlay();
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            bot.showCard(layer2);
                        }    
                    },1000);
                    if(player1.getSumScore() == bot.getSumScore()){
                        draw();
                    }
                    else{
                        cwLogic.checkWin(player1, bot);
                    }
                    checkSomeOneWin();
                }
            }
            else if(b == btnSurrender){
                cwLogic.reset(player1, bot);        
                lg.resetRound();
                whiteJackNumber.setText(Integer.toString(cwLogic.getVictory()));
                mainFrame.repaint();
                reset();
            }
        }

    }
}

