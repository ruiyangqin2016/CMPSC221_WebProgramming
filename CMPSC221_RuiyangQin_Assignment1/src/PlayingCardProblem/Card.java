package PlayingCardProblem;

public class Card implements Comparable{
    private String CardFace;//2,3,4,5,6,7,8,9,10,J,Q,K,A
    private String suit;//Hearts, clubs, diamonds, spades

    public Card(String suit, String cardFace) {
        this.CardFace = cardFace;
        this.suit = suit;
    }

    public String getCardFace() {
        return CardFace;
    }

    public void setCardFace(String cardFace) {
        CardFace = cardFace;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String toString() {
        return (suit+" "+CardFace);
    }

    @Override
    public int compareTo(Object o){
        Card c = (Card) o;
        return c.getSuit().compareTo(suit);
    }
}
