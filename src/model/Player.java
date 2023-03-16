package src.model;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> listCard;
    private int sumScore;
    private int winCollect;

    public Player(){
        winCollect = 0;
        sumScore = 0;
        listCard = new ArrayList<>();
    }

    public ArrayList<Card> getListCard() {
        return listCard;
    }

    public void setListCard(Card c) {
        listCard.add(c);
    }

    public void setSumScore(int rank){
        sumScore += rank;
    }

    public int getSumScore(){
        return sumScore;
    }

    public int getWinCollect() {
        return winCollect;
    }

    public void setWinCollect() {
        winCollect+=1;
    }

    public void setWinCollect(int o) {
        winCollect = o;
    }

    public void clearCard(){
        listCard.clear();
    }

    public void resetSumScore() {
        sumScore = 0;
    }

    public void reset(){
        winCollect = 0;
    }

}
