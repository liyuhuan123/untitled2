package Java15;

import java.util.Comparator;

class CardComparator implements Comparator<Card1> {
    @Override
    public int compare(Card1 o1, Card1 o2) {
        if(o1 == o2){
            return 0;
        }
        if(o1 == null){
            return -1;
        }
        if(o2 == null){
            return 1;
        }
        int value1 = o1.getValue();
        int value2 = o2.getValue();
        return value1 - value2;
    }
}
class Card1 implements Comparable<Card1>{
    public String rank;//数值
    public String suit;//花色

    @Override
    public int compareTo(Card1 o) {
        //如果认为this比o小，返回 < 0
        //如果认为this比o大，返回 > 0
        //如果认为this和o相等，返回0
        if(o == null){
            return 1;
        }
        int rank1 = this.getValue();
        int rank2 = this.getValue();
        return rank1 - rank2;
    }
    public int getValue(){
        int value = 0;
        if("J".equals(rank)){
            value = 11;
        }else if("Q".equals(rank)){
            value = 12;
        }else if("K".equals(rank)){
            value = 13;
        }else{
            value = Integer.parseInt(rank);
        }
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Card1)){
            return false;
        }
        Card1 other = (Card1)obj;
        return this.rank.equals(other.rank)&&
                this.suit.equals(other.suit);
    }

    public Card1(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;

    }
}
public class Learnjava_0412 {
    public static void main(String[] args) {
        Card1 p = new Card1("1", "♥");
        Card1 q = new Card1("1", "♥");
        Card1 o = p;
//        System.out.println(p == q);
//        System.out.println(p == o);
//        System.out.println(p.equals(o));
//        System.out.println(p.equals(q));
//        System.out.println(p.compareTo(o));
//        System.out.println(p.compareTo(q));
        CardComparator comparator = new CardComparator();
        System.out.println(comparator.compare(p,q));

    }
}
