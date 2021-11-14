package com.damot.Objects.Weapons;

import com.damot.Objects.InteractiveObjects;

public class Weapon extends InteractiveObjects {
   private int health;
    private int damage;

    public Weapon(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName(){
        return null;
    }
}
