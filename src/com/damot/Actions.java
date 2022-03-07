package com.damot;

import java.util.ArrayList;
import com.damot.InteractiveObjectList;
import com.damot.Objects.InteractiveObjects;
public class Actions {

    private InteractiveObjectList interactiveObjectList = null;
    ArrayList<String> interactiveObjectArrayList;

    public Actions(InteractiveObjectList interactiveObjectList, Inventory inventory){
        this.interactiveObjectList = interactiveObjectList;
    }
    public Actions(InteractiveObjectList interactiveObjectList) {
        this.interactiveObjectList = interactiveObjectList;
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

    protected InteractiveObjects getObject(String objectName) throws Exception{
        return interactiveObjectList.getObject(objectName);
    }
}
