package com.damot;

import com.damot.Object.Sword;
import com.damot.Object.Weapon;

import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//provides and maintain a list of available objects that can be interacted with

public class InteractiveObjectList {
    Sword sword;
    List<Object> list;

    public InteractiveObjectList(){
        list = initList();
        sword = new Sword(100, 25, 4, 4);
    }

    public List<Object> getInteractiveObjects(){
        return list;
    }

    public ArrayList<String> getInteractiveObjectsName(){
        ArrayList<String> arrayList = new ArrayList<>();
        for(Object o : list){
            Weapon weapon = (Weapon) o;
            arrayList.add(weapon.getName());
        }
        return arrayList;
    }

    public List<Object> initList(){
        List<Object> list = new LinkedList<>();
        list.add(sword);
        return list;
    }
}
