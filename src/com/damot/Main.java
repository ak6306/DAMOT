package com.damot;

import com.damot.Object.Sword;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Plane plane = new Plane(10, 10);
        Player player = new Player(100, 0, 0);
        Sword sword = new Sword(100, 25, 4, 4);
        Inventory inventory = new Inventory(10);
        Navigation navigation = new Navigation(player, plane);
        InteractiveObjectList interactiveObjectList = new InteractiveObjectList();
        System.out.println("Hello!, Use Walk and direction(North, South, East, West) to walk\nExample: Walk South\nType 'help' anytime for help");
        int flag = 1;
        while (flag == 1) {
            player.currentPosition();
            inventory.show();
            String input;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            input = input.toLowerCase();
            navigation.move(input);
            BasicActions basicActions = new BasicActions(input, inventory);
            basicActions.pickUp();

            if (input.equalsIgnoreCase("exit")) {
                flag = 0;
            }

            if (player.getYdistance() == sword.getYdistance() && player.getXdistance() == sword.getXdistance()) {
                System.out.println("You found a Sword!!");
                inventory.add("Sword");
            }
        }
    }
}
