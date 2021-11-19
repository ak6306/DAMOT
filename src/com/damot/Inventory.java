package com.damot;

import com.damot.Objects.InteractiveObjects;

import java.util.Arrays;

public class Inventory {
    private int count;
    private InteractiveObjects[] arr;
    int size;



    public Inventory(int size) {
        this.count = 0;
        this.size = size;
        this.arr = new InteractiveObjects[size];
    }


    public void add(InteractiveObjects s) {
        if(count<size) {
            arr[count] = s;
            count++;
        }else{
            System.out.println("Inventory Full!");
        }
    }
    public void drop(String s){
        for(int i=0;i<size;i++){
            if(arr[i].getName().equals(s))
                arr[i] = null;
        }
    }
    public void show(){
        if(count ==0){
            System.out.println("Your inventory is empty.");
        }else{
        System.out.print("Your Inventory");
        for(int i=0;i<count;i++){
                System.out.println("\n"+ arr[i].getName());

            }
        }}
    public boolean findByString(String weaponName) {
        for(int i =0; i < arr.length; i ++) {
            if (arr[i].getName() == weaponName) {
                return true;
            }
        }
        return false;
    }

    public InteractiveObjects fetch(String weaponName) {
        if(arr[0] == null)
            return null;
        else {
            for (InteractiveObjects interactiveObjects : arr) {
                if (interactiveObjects.getName().equals(weaponName))
                    return interactiveObjects;
            }
        }
        return null;
    }
}
