package com.damot.Objects.Weapons;

public class Halberd extends Weapon{
    public static final String HALBERD = "halberd";
    private int Xdistance;
    private int Ydistance;

    public Halberd(int health, int damage, int xdistance, int ydistance) {
        super(health, damage);
        Xdistance = xdistance;
        Ydistance = ydistance;
    }
    public void currentPosition() {
        System.out.println("Halberd is at: X-->" +Xdistance + " and Y-->" +Ydistance);
    }

    public int getXDistance() {
        return Xdistance;
    }

    public void setXdistance(int xdistance) {
        Xdistance = xdistance;
    }

    public int getYDistance() {
        return Ydistance;
    }

    public void setYdistance(int ydistance) {
        Ydistance = ydistance;
    }

    public String getName(){
        return HALBERD;
    }
}
