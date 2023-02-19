package src.model;
import java.util.ArrayList;

public class Player {
    private ArrayList<Card> listCard;

    public Player(){
        listCard = new ArrayList<>();
    }

    public ArrayList<Card> getListCard() {
        return listCard;
    }

    public void setListCard(Card c) {
        listCard.add(c);
    }

    public void clearCard(){
        listCard.clear();
    }
}
