package com.damot;

public class Enemy extends Player{
    public Enemy(int health, int xdistance, int ydistance) {
        super(health, xdistance, ydistance);
    }
    public void showHealth() {
        int health = Math.max(getHealth(), 0);
        System.out.println("------------------\n Current Enemy Health Point is: "+ health +"\n------------------");
    }
}
