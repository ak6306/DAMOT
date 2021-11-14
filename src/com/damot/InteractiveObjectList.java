package com.damot;

import com.damot.Objects.InteractiveObjects;
import com.damot.Objects.Weapons.Sword;
import com.damot.Objects.Weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//provides and maintain a list of available objects that can be interacted with

public class InteractiveObjectList {
    List<InteractiveObjects> list;

    public InteractiveObjectList(InteractiveObjects ...interactiveObjects){
        list = initList(interactiveObjects);
    }

    public List<InteractiveObjects> getInteractiveObjects() {
        return list;
    }

    public String getObjectName(InteractiveObjects interactiveObjects) throws Exception {
        if(list.contains(interactiveObjects)) {
            return  interactiveObjects.getName();
        }else {
            throw new Exception();
        }
    }

    public InteractiveObjects getObject(String objectName) throws Exception {
        for (InteractiveObjects i : list) {
            if (i.getName().equalsIgnoreCase(objectName)) {
                return i;
            }
        }
        throw new Exception();
    }

    public ArrayList<String> getInteractiveObjectsName() {
        ArrayList<String> arrayList = new ArrayList<>();
        for(InteractiveObjects i : list){
            arrayList.add(i.getName());
        }
        return arrayList;
    }

    public List<InteractiveObjects> initList(InteractiveObjects ...interactiveObjects) {
        List<InteractiveObjects> list = new LinkedList<>();
        for(InteractiveObjects i : interactiveObjects ) {
            list.add(i);
        }
        return list;
    }
}
