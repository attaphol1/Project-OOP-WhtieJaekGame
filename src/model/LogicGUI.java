package src.model;

public class LogicGUI {
    private int round;
    private boolean stan;

     public LogicGUI(){
        round = 1;
        stan = false;
    }

    public void setRound(int r){
        round += r;
    }

    public int getRound(){
        return round;
    }

    public void resetRound(){
        round = 0;
        stan = false;
    }

    public void setCheckStanTrue(){
        stan = true;
    }

    public void setCheckStanFalse(){
        stan = false;
    }
    
    public boolean getCheckStan(){
        return stan;
    }
}
