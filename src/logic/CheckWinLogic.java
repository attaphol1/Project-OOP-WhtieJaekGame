
package src.logic;

import java.util.Timer;
import java.util.TimerTask;

import src.WaitingForConnection.DefaltFramWin;
import src.model.Player;

public class CheckWinLogic{
    private boolean stan = false;
    private int round = 1;
    private int victory;
    private boolean check = false;

    private DefaltFramWin df;
    private Timer timer = new Timer();
    public CheckWinLogic(){
        victory = 21;
        df = new DefaltFramWin();
    }

    public void checkWin(Player p1, Player p2){
        System.out.println(round);
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
        else if(round % 2 != 0 && p2.getSumScore() > p1.getSumScore()){
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

        else if(stan == true && p1.getSumScore() > p2.getSumScore()){
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
    public void setStan(boolean s){
        stan = s;
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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    
}