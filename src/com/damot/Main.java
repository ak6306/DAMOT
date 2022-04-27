package com.damot;

import com.damot.Combat.BasicCombat;
import com.damot.Objects.NonInteractiveObjects;
import com.damot.Objects.Weapons.Halberd;
import com.damot.Objects.Weapons.Sword;
import com.damot.StoryWeaver.StoryWeaver;

import java.util.Scanner;

import static com.damot.Constants.ColorConstant.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Plane plane = new Plane(50, 50);
        Player player = new Player(100, 1, 1);

        Sword sword = new Sword(100, 50, 3, 5);
        Halberd halberd = new Halberd(50,35,21,14);

        Enemy enemy = new Enemy(50, 7, 7);
        Enemy enemy1 = new Enemy(50, 35,35);
        Enemy enemy2 = new Enemy(25, 1,5);
        Inventory inventory = new Inventory(10);
        NonInteractiveObjects nonInteractiveObjects = new NonInteractiveObjects();
        Integer[][] nonInteractiveObjectList = nonInteractiveObjects.generateNonInteractiveObjects(plane);
        Navigation navigation = new Navigation(player, plane, nonInteractiveObjectList);
        InteractiveObjectList interactiveObjectList = new InteractiveObjectList(halberd, sword);
        BasicActions basicActions = new BasicActions(interactiveObjectList, inventory);
        BasicCombat basicCombat = new BasicCombat(player,inventory, enemy, enemy1, enemy2);
        Map map = new Map(player, plane, interactiveObjectList,nonInteractiveObjectList , enemy, enemy1, enemy2);
        StoryWeaver storyWeaver = new StoryWeaver(player);
        System.out.println(ANSI_BLUE + "Hello!, Use Walk and direction(North, South, East, West) to walk\nExample: " +
                "Walk South\nType 'help' anytime for help" + ANSI_RESET);
        int flag = 1;
        while (flag == 1) {
            player.currentPosition();
            storyWeaver.showBits();
            inventory.show();
            String input;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            input = input.toLowerCase();
            navigation.move(input);
            basicActions.pickUp(input);
            basicActions.drop(input);
            basicCombat.initCombatState();
            map.showMap(input);

            if (input.equalsIgnoreCase("exit") || player.getHealth()<=0) {
                if(player.getHealth() <= 0) {
                    System.out.println("YOU ARE DEAD :(");
                }
                flag = 0;
            }

            //TODO Remove these actions from the main class
            if (player.getYdistance() == sword.getYDistance() && player.getXdistance() == sword.getXDistance()) {
                System.out.println(ANSI_GREEN + "You found a Sword!" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "use Actions to interact" + ANSI_RESET);
            }
            if (player.getYdistance() == halberd.getYDistance() && player.getXdistance() == halberd.getXDistance()) {
                System.out.println(ANSI_GREEN + "You found a Halberd!" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "use Actions to interact" + ANSI_RESET);
            }
        }
    }
}
