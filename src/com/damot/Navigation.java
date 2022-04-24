package com.damot;

import static com.damot.Constants.ColorConstant.ANSI_RED;
import static com.damot.Constants.ColorConstant.ANSI_RESET;

/**
 * Contains functions move
 */
public class Navigation {
    private final Player player;
    private final Plane plane;
    private final Integer[][] nonInteractiveObjectList;


    public Navigation(Player player, Plane plane, Integer[][] nonInteractiveObjectList) {
        this.player = player;
        this.plane = plane;
        this.nonInteractiveObjectList = nonInteractiveObjectList;
    }

    public void move(String input) {
        if(canMove(player.getXdistance(), player.getYdistance(), input)) {
            int increment;
            if (input.contains("walk"))
                increment = 1;
            else if (input.contains("run"))
                increment = 2;
            else
                increment = 0;

            if(input.contains("north")) {
                player.North(increment);
                if (player.getYdistance() > plane.getYDistance())
                    player.setYdistance(plane.getYDistance());
            }
            else if(input.contains("south")) {
                player.South(increment);
                if (player.getYdistance() < 0)
                    player.setYdistance(0);
            }
            else if(input.contains("east")) {
                player.East(increment);
                if (player.getXdistance() > plane.getXDistance())
                    player.setXdistance(plane.getXDistance());

            }
            else if(input.contains("west")){
                player.West(increment);
                if (player.getXdistance() < 0)
                    player.setXdistance(0);
            }
        }else {
            System.out.println(ANSI_RED + "Path blocked! You can't go there" + ANSI_RESET );
        }
    }

    private boolean canMove(int xPosition, int yPosition, String input) {
        if(input.contains("walk")) {
            if(input.contains("north")){
                return nonInteractiveObjectList[yPosition + 1][xPosition] != 1;
            }else if(input.contains("east")){
                return nonInteractiveObjectList[yPosition][xPosition + 1] != 1;
            }else if(input.contains("west")){
                return nonInteractiveObjectList[yPosition + 1][xPosition] != 1;
            }else if(input.contains("south")){
                return nonInteractiveObjectList[yPosition - 1][xPosition] != 1;
            }
        }
        return true;
    }

}

