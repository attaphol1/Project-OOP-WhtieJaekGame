package src.model;

public class LogicGUI {
    private int round;

     public LogicGUI(){
        round = 1;
    }

    public void setRound(int r){
        round += r;
    }

    public int getRound(){
        return round;
    }

    public void resetRound(){
        round = 0;
    }
}
