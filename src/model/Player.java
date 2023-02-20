package src.model;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> listCard;
    private int sumScore;

    public Player(){
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

    public void clearCard(){
        listCard.clear();
    }
}
