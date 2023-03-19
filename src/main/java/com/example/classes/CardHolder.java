package com.example.classes;

import java.util.ArrayList;

public class CardHolder {
    public static ArrayList<Card> cardHolder = new ArrayList<>();

    static {
        cardHolder.add(new Card(1234, 4321, 1000));
        cardHolder.add(new Card(3214, 5678, 2000));
        cardHolder.add(new Card(1413, 1314, 3000));
        cardHolder.add(new Card(5643, 5209, 4000));
        cardHolder.add(new Card(1234, 5158, 5000));
        cardHolder.add(new Card(5150, 5051, 6000));
        cardHolder.add(new Card(8989, 9898, 7000));
        cardHolder.add(new Card(3232, 3333, 8000));
        cardHolder.add(new Card(9095, 9590, 9000));
        cardHolder.add(new Card(4541, 4541, 10000));
    }
    public static Card findCard(int number, int pinCode){
        for(Card cardFromHolder : cardHolder){
            int cNumber = cardFromHolder.getNumber();
            int cPin = cardFromHolder.getPinCode();
            if(cNumber == number && cPin == pinCode) {
                return cardFromHolder;
            }
        }
        return null;
    }
    public static void loadClass(){}
}
