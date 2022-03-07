package com.damot;

import com.damot.Combat.BasicCombat;
import com.damot.Objects.Weapons.Sword;
import com.damot.Objects.Weapons.Halberd;
import com.damot.StoryWeaver.StoryWeaver;

import java.util.Scanner;

import static com.damot.Constants.ColorConstant.ANSI_BLUE;
import static com.damot.Constants.ColorConstant.ANSI_RESET;

public class Main {

    public static void main(String[] args) throws Exception {
        Plane plane = new Plane(50, 50);
        Player player = new Player(100, 0, 0);

        Sword sword = new Sword(100, 50, 2, 4);
        Halberd halberd = new Halberd(50,35,6,6);

        Enemy enemy = new Enemy(50, 2, 2);
        Enemy enemy1 = new Enemy(50, 4,4);

        Inventory inventory = new Inventory(10);
        Navigation navigation = new Navigation(player, plane);
        InteractiveObjectList interactiveObjectList = new InteractiveObjectList(halberd, sword);
        BasicActions basicActions = new BasicActions(interactiveObjectList, inventory);
        BasicCombat basicCombat = new BasicCombat(player,inventory, enemy, enemy1);
        StoryWeaver storyWeaver = new StoryWeaver(player);

        System.out.println(ANSI_BLUE + "Hello!, Use Walk and direction(North, South, East, West) to walk\nExample: Walk South\nType 'help' anytime for help" + ANSI_RESET);
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

            if (input.equalsIgnoreCase("exit") || player.getHealth()<=0) {
                if(player.getHealth() <= 0) {
                    System.out.println("YOU ARE DEAD :(");
                }
                flag = 0;
            }

            //TODO Remove these actions from the main class
            if (player.getYdistance() == sword.getYdistance() && player.getXdistance() == sword.getXdistance()) {
                System.out.println("You found a Sword!");
                System.out.println("use Actions to interact");
            }
            if (player.getYdistance() == halberd.getYdistance() && player.getXdistance() == halberd.getXdistance()) {
                System.out.println("You found a Halberd!");
                System.out.println("use Actions to interact");
            }
        }
    }
}
