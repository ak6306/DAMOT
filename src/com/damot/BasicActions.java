package com.damot;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicActions extends Actions{
    //allows player to perform basic actions
    //basic actions include pickup, drop, open, close
    public static final String PICK_UP= "pickup";
    public static final String DROP= "drop";
    public static final String OPEN= "open";
    public static final String CLOSE= "close";

    private ArrayList<String> action;
    private Inventory inventory;

    public BasicActions(InteractiveObjectList interactiveObjectList, Inventory inventory) {
        super(interactiveObjectList, inventory);
        this.inventory = inventory;
    }

    public void pickUp(String input) throws Exception {
        action = new ArrayList<>(Arrays.asList(preparedString(input)));
        if(action.contains(PICK_UP)) {
            if(getInteractiveObjectsName().contains(action.get(1))){
                inventory.add(getObject(action.get(1)));
            }else{
                System.out.println("This Object can't be picked up. Refer Guide!");
            }
        }
    }
    public void drop() {

    }
    public void open() {

    }
    public void close() {

    }
}
