package com.company;

public class Player {
    private int health;
    private int Xdistance;
    private int Ydistance;

    public Player(int health, int xdistance, int ydistance) {
        this.health = health;
        Xdistance = xdistance;
        Ydistance = ydistance;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setXdistance(int xdistance) {
        Xdistance = xdistance;
    }

    public void setYdistance(int ydistance) {
        Ydistance = ydistance;
    }

    public int getXdistance() {
        return Xdistance;
    }

    public int getYdistance() {
        return Ydistance;
    }

    public void West(int increment){
        Xdistance -= increment;
    }
    public void East(int increment){
        Xdistance += increment;
    }public void North(int increment){
        Ydistance += increment;
    }
    public void South(int increment){
        Ydistance -= increment;
    }
    public void currentPosition() {
        System.out.println("Currently player is at: X-->" +Xdistance + " and Y-->" +Ydistance);
    }

}
