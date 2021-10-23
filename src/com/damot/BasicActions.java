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

    public BasicActions(String input, Inventory inventory) {
        super(inventory);
        action = new ArrayList<String>(Arrays.asList(preparedString(input)));
    }

    public void pickUp() {
        if(action.contains(PICK_UP)){
            if(getInteractiveObjectsName().contains(action)){
                inventory.add(action.get(1));
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
