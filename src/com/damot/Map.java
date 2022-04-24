package com.damot;

import com.damot.Objects.InteractiveObjects;
import com.damot.Objects.Weapons.Sword;
import com.damot.Objects.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static com.damot.Constants.ColorConstant.*;

public class Map {
    //boolean gameCond;
    private final List<List<Integer>> map1;
    private final Player player;
    private final Plane plane;
    private  final InteractiveObjectList interactiveObjectList;
    private ArrayList<Integer> innerList;
    private final List<Enemy> enemies;
    private final Integer[][] nonInteractiveObjectList;

    public Map(Player player, Plane plane, InteractiveObjectList interactiveObjectList,
               Integer[][] nonInteractiveObjectList,  Enemy ...enemies) {
        this.player = player;
        this.plane = plane;
        this.interactiveObjectList = interactiveObjectList;
        this.map1 = new ArrayList<List<Integer>>();
        this.innerList = new ArrayList<>();
        this.enemies = Arrays.asList(enemies);
        this.nonInteractiveObjectList = nonInteractiveObjectList;

    }

    public void makeMap() {
        List<InteractiveObjects> interactiveObjects = interactiveObjectList.getInteractiveObjects();
        for(int i = 0; i < plane.getYDistance(); i++) {
            innerList = new ArrayList<Integer>();
            if (i==0 || i==plane.getYDistance()-1){
                for(int j = 0; j <plane.getXDistance(); j++){
                    innerList.add(2);
                }
            } else {
                innerList.add(2);
                int lineFlag = 0;
                Random rn = new Random();
                lineFlag = rn.nextInt(2);

                for (int j = 1; j < plane.getXDistance() - 1; j++) {
                    //adds player position
                    if (i == player.getYdistance() && j == player.getXdistance()) {
                        innerList.add(3);
                    }else innerList.add(0);
//                    if (lineFlag == 0) {
//                        innerList.add(0);
//                    }
                    if (interactiveObjects != null) {
                        for (InteractiveObjects interactiveObjects1 : interactiveObjects) {
                            if (i == interactiveObjects1.getYDistance() && j == interactiveObjects1.getXDistance()) {
                                innerList.add(4);
                            }
                        }
                    }
                    if (enemies != null) {
                        for (Enemy enemy : enemies) {
                            if (enemy.getHealth()>0 && i == enemy.getYdistance() && j == enemy.getXdistance()) {
                                innerList.add(5);
                            }
                        }
                    }
                    if(nonInteractiveObjectList[i][j] == 1) {
                        innerList.add(2);
                    }
                }
                innerList.add(2);
            }
            this.map1.add(innerList);
            }
        }

//    public void updateMap() {
//        for(int i = 0; i < plane.getYDistance(); i++) {
//            for (int j = 1; j < plane.getXDistance() - 1; j++) {
//                if(i == player.getYdistance() && j == player.getXdistance()) {
//                    innerList.add(3);
//                }
//            }
//        }
//        this.map1.add(innerList);
//    }

    public void printMap(){
       Integer[][] theMap = (Integer[][]) flipInPlace(map1.
                stream()
                .map(arr -> arr.toArray(Integer[]::new))
                .toArray(Integer[][]::new));

        for(int i = 0; i < plane.getYDistance(); i++){
            for(int j = 0; j < plane.getXDistance(); j++){
                if(theMap[i][j] == 1){
                    System.out.print("*");
                }
                else if(theMap[i][j] == 2) {
                    System.out.print("");
                }else if(theMap[i][j] == 3) {
                    System.out.print(ANSI_GREEN_BACKGROUND + "*" + ANSI_RESET);
                }
                else if(theMap[i][j] == 4) {
                    System.out.print(ANSI_YELLOW_BACKGROUND + "^" + ANSI_RESET);
                }
                else if(theMap[i][j] == 5) {
                    System.out.print(ANSI_RED_BACKGROUND + "|" + ANSI_RESET);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void showMiniMap() {
        System.out.println();
        Integer[][] theMap = (Integer[][]) flipInPlace(map1.
                stream()
                .map(arr -> arr.toArray(Integer[]::new))
                .toArray(Integer[][]::new));
        int xLimitLeft = Math.max(player.getXdistance() - 5, 0);
        int xLimitRight = Math.min(player.getXdistance() + 5, plane.getXDistance());
        int yLimitTop = Math.min(plane.getYDistance()- player.getYdistance() + 5, plane.getYDistance());
        int yLimitBottom = Math.max(plane.getYDistance()- player.getYdistance() - 5, 0);

        for(int i = yLimitBottom; i < yLimitTop; i++) {
            for (int j = xLimitLeft; j <xLimitRight; j++) {
                if(theMap[i][j] == 1) {
                    System.out.print("*");
                }
                else if(theMap[i][j] == 2) {
                    System.out.print(ANSI_BLACK_BACKGROUND + " " + ANSI_RESET);
                }else if(theMap[i][j] == 3) {
                    System.out.print(ANSI_GREEN_BACKGROUND + "*" + ANSI_RESET);
                }
                else if(theMap[i][j] == 4) {
                    System.out.print(ANSI_YELLOW_BACKGROUND + "^" + ANSI_RESET);
                }
                else if(theMap[i][j] == 5) {
                    System.out.print(ANSI_RED_BACKGROUND + "|" + ANSI_RESET);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getMap1() {
        return map1;
    }

    public void showMap(String input) {
        if(input.contains("map")) {
            makeMap();
            showMiniMap();
        }
    }

    private static Object[][] flipInPlace(Object[][] theArray) {
        for (int i = 0; i < (theArray.length / 2); i++) {
            Object[] temp = theArray[i];
            theArray[i] = theArray[theArray.length - i - 1];
            theArray[theArray.length - i - 1] = temp;
        }
        return theArray;
    }
}
