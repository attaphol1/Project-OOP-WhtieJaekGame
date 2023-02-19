package src.model;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private Card[] card;
    private List<Card> listDeck;

    public Deck(){
        int cnt = 0;
        card = new Card[52];
        for(int i=1;i<14;i++){
            Card c = new Card(i, "Clubs");
            card[cnt++] = c;
        }
        for(int i=1;i<14;i++){
            Card c = new Card(i, "Diamond");
            card[cnt++] = c;
        }
        for(int i=1;i<14;i++){
            Card c = new Card(i, "Heart");
            card[cnt++] = c;
        }
        for(int i=1;i<14;i++){
            Card c = new Card(i, "Sprade");
            card[cnt++] = c;
        }

        listDeck = Arrays.asList(card);
    }

    public Card getCardRand(Player p1, Player p2){
        while(p1.getListCard().contains(card[0]) || p2.getListCard().contains(card[0])){
            shuffle();
        }
        return card[0];
    }

    void shuffle(){
        Collections.shuffle(listDeck);
        listDeck.toArray(card);
    }
}
