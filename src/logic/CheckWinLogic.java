package src.logic;

import src.WaitingForConnection.DefaltFramWin;
import src.model.Player;

public class CheckWinLogic {
    private int victory;
    private boolean check = false;
    private DefaltFramWin df;

    public CheckWinLogic(){
        victory = 21;
        df = new DefaltFramWin();
    }

    public void checkWin(Player p1, Player p2){
        if(p1.getSumScore() > victory) {
            p2.setWinCollect();
            df.playerTwoWin(p2.getWinCollect());
            df.statusPlayerTwoWin();
            check = true;
        }
        else if(p2.getSumScore() > victory){
            p1.setWinCollect();
            df.playerOneWin(p1.getWinCollect());
            df.statusPlayerOneWin();
            check = true;
        }
        else if(p2.getSumScore() > p1.getSumScore()){
            p2.setWinCollect();
            df.playerTwoWin(p2.getWinCollect());
            df.statusPlayerTwoWin();
            check = true;
        }
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
