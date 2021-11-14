package com.damot.Objects.Weapons;

public class Sword extends Weapon {
    public static final String SWORD = "sword";
    private int Xdistance;
    private int Ydistance;

    public Sword(int health, int damage, int xdistance, int ydistance) {
        super(health, damage);
        Xdistance = xdistance;
        Ydistance = ydistance;
    }
    public void currentPosition() {
        System.out.println("Sword is at: X-->" +Xdistance + " and Y-->" +Ydistance);
    }

    public int getXdistance() {
        return Xdistance;
    }

    public void setXdistance(int xdistance) {
        Xdistance = xdistance;
    }

    public int getYdistance() {
        return Ydistance;
    }

    public void setYdistance(int ydistance) {
        Ydistance = ydistance;
    }

    public String getName(){
        return SWORD;
    }
}