package com.damot;

public class Navigation {
    private Player player;
    private Plane plane;


    public Navigation(Player player, Plane plane) {
        this.player = player;
        this.plane = plane;
    }

    public void move(String input) {
        int increment;
        if (input.contains("walk"))
            increment = 2;
        else if (input.contains("run"))
            increment = 4;
        else
            increment = 0;
//        if(!checkPosition(direction)){
//            System.out.println("You can't go "+direction);
//            return;
//        }

            if(input.contains("north")) {
                player.North(increment);
                if (player.getYdistance() > plane.getYdistance())
                    player.setYdistance(plane.getYdistance());
            }
           else if(input.contains("south")) {
                player.South(increment);
                if (player.getYdistance() < 0)
                    player.setYdistance(0);
            }else if(input.contains("east")) {
                    player.East(increment);
                    if (player.getXdistance() > plane.getXdistance())
                        player.setXdistance(plane.getXdistance());
            }else if(input.contains("west")){
                player.West(increment);
                if (player.getXdistance() < 0)
                    player.setXdistance(0);
        }
    }}

