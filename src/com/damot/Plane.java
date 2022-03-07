package com.damot;

public class Plane {
    private int Xdistance;
    private int Ydistance;
    public Plane(){
        this.Xdistance = 10;
        this.Ydistance = 10;
    }
    public Plane(int Xdistance, int Ydistance) {
        this.Xdistance = Xdistance;
        this.Ydistance = Ydistance;
    }

    public int getXdistance() {
        return Xdistance;
    }

    public int getYdistance() {
        return Ydistance;
    }
}
