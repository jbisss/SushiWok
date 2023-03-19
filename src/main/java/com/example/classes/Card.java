package com.example.classes;

public class Card {
    private final int pinCode;
    private final int number;
    private int money;

    public Card(int number, int pinCode, int money) {
        this.pinCode = pinCode;
        this.number = number;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPinCode() {
        return pinCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Card otherCard){
            if(this == otherCard){
                return true;
            } else {
                return this.number == otherCard.number && this.pinCode == otherCard.pinCode;
            }
        } else {
            return false;
        }
    }
}
