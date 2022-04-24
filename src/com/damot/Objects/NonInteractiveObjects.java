package com.damot.Objects;

import com.damot.Plane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NonInteractiveObjects {
    private List<List<Integer>> listInteractiveObjects;

    public NonInteractiveObjects() {
        this.listInteractiveObjects = new ArrayList<>();
    }

    public String getNonNames(){return null;}

    public Integer[][] generateNonInteractiveObjects(Plane plane) {
        int lineFlag = 0;
        Random rn = new Random();
        lineFlag = rn.nextInt(3);
        for(int i = 0; i < plane.getYDistance(); i++) {
            List<Integer> innerList = new ArrayList<Integer>(plane.getXDistance());
            for (int j = 0; j < plane.getXDistance(); j++) {
                if ((i == 0 || i == plane.getYDistance() - 1)) innerList.add(1);
                else {
                    if (lineFlag != 0) {
                        int Obs = rn.nextInt(plane.getXDistance() - 3) + 1;
                        int negObs = plane.getXDistance() - Obs;
                        List<Integer> cordObs = new ArrayList<Integer>();
                        for (int k = 0; k < negObs; k++) {
                            cordObs.add(rn.nextInt(plane.getXDistance() - 2) + 1);
                        }
                        if (cordObs.contains(j)) {
                            innerList.add(0);
                        } else {
                            innerList.add(1);
                        }
                    }
                    innerList.add(0);
                }
            }
            this.listInteractiveObjects.add(innerList);
        }
        Integer[][] theList = (Integer[][]) flipInPlace(listInteractiveObjects.
                stream()
                .map(arr -> arr.toArray(Integer[]::new))
                .toArray(Integer[][]::new));

        for(int i = 0; i < plane.getYDistance(); i++) {
            for(int j = 0; j< plane.getXDistance() ; j++){
                System.out.print(theList[i][j] + " ");
            }
            System.out.println();
        }
        return theList;
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
