package com.damot;

import java.util.ArrayList;
import java.util.List;

public class Actions {

    private final InteractiveObjectList interactiveObjectList;
    ArrayList<String> interactiveObjectArrayList;

    public Actions(Inventory inventory){
        interactiveObjectList = new InteractiveObjectList();
    }

    protected String[] preparedString(String input){
        String preparedString = input.toLowerCase();
        String[] words = preparedString.split(" ");
        return words;
    }

    protected ArrayList<String> getInteractiveObjectsName(){
       interactiveObjectArrayList = interactiveObjectList.getInteractiveObjectsName();
       return interactiveObjectArrayList;
    }
}
