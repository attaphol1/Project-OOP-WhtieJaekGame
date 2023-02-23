
package src.logic;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import src.WaitingForConnection.DefaultFramWin;
import src.model.Player;

public class CheckWinLogic{
    private int round = 1;
    private int victory;
    private boolean check = false;

    private Random random;

    private DefaultFramWin df;
    private Timer timer = new Timer();
    public CheckWinLogic(){
        random = new Random();
        victory = random.nextInt(31-21)+21;
        System.out.println("Victory is "+victory);
        df = new DefaultFramWin();
    }

    public void checkWin(Player p1, Player p2){
        // System.out.println(round);
        if(p1.getSumScore() == victory){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p1.setWinCollect();
                    df.playerOneWin(p1.getWinCollect());
                    df.statusPlayerOneWin();
                }    
            },1000);
            check = true;


        }
        else if(p2.getSumScore() == victory){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p2.setWinCollect();
                    df.playerTwoWin(p2.getWinCollect());
                    df.statusPlayerTwoWin();            }    
            },1000);
            check = true;
        }
        else if(p1.getSumScore() > victory) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p2.setWinCollect();
                    df.playerTwoWin(p2.getWinCollect());
                    df.statusPlayerTwoWin();
                }    
            },1000);
            check = true;
        }
        else if(p2.getSumScore() > victory){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p1.setWinCollect();
                    df.playerOneWin(p1.getWinCollect());
                    df.statusPlayerOneWin();
                }    
            },1000);
            check = true;
        }
        else if(round % 2 != 0 && p2.getSumScore() > p1.getSumScore() && p1.getSumScore() != 0){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p2.setWinCollect();
                    df.playerTwoWin(p2.getWinCollect());
                    df.statusPlayerTwoWin();
                }    
            },1000);
            check = true;
        }

        else if(round % 2 == 0 && p1.getSumScore() > p2.getSumScore() && p2.getSumScore() != 0){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    p1.setWinCollect();
                    df.playerOneWin(p1.getWinCollect());
                    df.statusPlayerOneWin();
                }    
            },1000);
            check = true;
        }
    }

    public void reset(Player p1, Player p2){
        victory = random.nextInt(31-21) + 21;
        p1.reset();
        p2.reset();
        df.resetWinGame();
    }
    
    public void setRound(int r){
        round = r;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public boolean isSomeOneWin() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    
}