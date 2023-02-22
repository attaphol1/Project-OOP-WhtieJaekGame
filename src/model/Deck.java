package src.model;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private Card[] card;
    private List<Card> listDeck;
    private Random rand = new Random();

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
        shuffle();
        int i = (int)(rand.nextInt(52));
        while(p1.getListCard().contains(card[i]) || p2.getListCard().contains(card[i])){
            i = (int)(rand.nextInt(52));
        }
        return card[i];
    }

    void shuffle(){
        Collections.shuffle(listDeck);
        listDeck.toArray(card);
    }
}
