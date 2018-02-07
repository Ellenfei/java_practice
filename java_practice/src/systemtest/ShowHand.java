package systemtest;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by ye on 2016/11/27.
 */
public class ShowHand {
    private final int PLAY_NUM = 5;
    private String[] types = {"·½¿é","²ÝÐÄ","ºìÐÄ","ºÚÌÒ"};
    private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    private List<String> cards = new LinkedList<String >();
    private String [] players = new String [PLAY_NUM];
    private List<String>[] playersCards = new List[PLAY_NUM];



    public void initCards () {
        for (int i = 0;i<types.length;i++) {
            for (int j = 0;j<values.length;j++) {
                cards.add(types[i]+values[j]);
            }
        }
        Collections.shuffle(cards);
    }

    public void initPlayser (String... names) {
        if (names.length>PLAY_NUM || names.length<2) {
            System.out.println("err");
            return;
        } else {
            for (int i = 0;i<names.length;i++) {
                players[i] = names[i];
            }
        }
    }

    public void initPlayerCards () {
        for (int i = 0; i<players.length; i++) {
            if (players[i] != null && !players[i].equals("")) {
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    public void showAllCards () {
        for (String card : cards) {
            System.out.println(card);
        }
    }

    public void deliverCard () {
        int firstPos = 0;
        for (int i = firstPos; i<players.length; i++) {
            if (players[i] != null) {
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }

    public void showPlayerCards () {
        for (int i = 0; i<PLAY_NUM; i++) {
            if (players[i] != null) {
                System.out.print(players[i] + ": ");
                for (String card : playersCards[i]) {
                    System.out.print(card + "\t");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main (String [] args) {
        ShowHand sh = new ShowHand();
        sh.initPlayser("david", "ellen", "ass");
        sh.initCards();
        sh.initPlayerCards();

        sh.showAllCards();
        System.out.println("------------");

        sh.deliverCard();
        sh.showPlayerCards();

        sh.deliverCard();
        sh.showPlayerCards();
        System.out.println(System.currentTimeMillis());


    }
}
