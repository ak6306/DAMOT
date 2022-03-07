package com.damot;
import  com.damot.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Map extends  Plane{
    //boolean gameCond;
    private List<List<Integer>> map;
    public Map(){
        super();
        map = new ArrayList<List<Integer>>();
    }
    public Map(int Xdistance,int Ydistance){
        super(Xdistance,Ydistance);
        map = new ArrayList<List<Integer>>();
    }
    public void makeMap(){
        for(int i=0; i < this.getYdistance(); i++) {
            List<Integer> innerList = new ArrayList<Integer>();
            if (i==0 || i==this.getYdistance()-1){
                for(int j = 0; j <this.getXdistance(); j++){
                    innerList.add(1);
                }
            }
            else {
                innerList.add(1);
                int lineFlag = 0;
                Random rn = new Random();
                lineFlag = rn.nextInt(2);

                for (int j = 1; j < this.getXdistance()-1; j++) {
                    if (lineFlag == 0) {
                        innerList.add(0);
                    }
                    else {
                        //Main RNG Part
                        int Obs=rn.nextInt(this.getXdistance()-3)+1;
                        int negObs = this.getXdistance() - Obs;
                        List<Integer> cordObs= new ArrayList<Integer>() ;
                        for(int k=0; k < negObs; k++){
                            cordObs.add(rn.nextInt(this.getXdistance()-2)+1);
                        }
                        if(cordObs.contains(j)){
                            innerList.add(0);
                        }
                        else{
                            innerList.add(1);
                        }
                    }
                }
                innerList.add(1);
            }
            this.map.add(innerList);
        }
    }
    public void printMap(){
        for(int i=0; i < this.getYdistance(); i++){
            for(int j=0; j < this.getXdistance(); j++){
                if(this.map.get(i).get(j)==1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public List<List<Integer>> getMap() {
        return map;
    }
}
