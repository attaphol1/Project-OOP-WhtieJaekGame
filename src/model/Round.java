package src.model;

public class Round {
    private int round;

     public Round(){
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
