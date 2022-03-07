package com.damot.Combat;

import com.damot.Enemy;
import com.damot.Inventory;
import com.damot.Objects.Weapons.Weapon;
import com.damot.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.damot.Constants.ColorConstant.*;

//Basic combat enables turn based combat. Changes the game state to locked combat state upon activation.
public class BasicCombat {
    Player player;
    Inventory inventory;
    List<Enemy> enemies;
    Enemy currentEnemy = null;
    ArrayList<String> action;
    public BasicCombat(Player player, Inventory inventory, Enemy... enemies) {
        this.player = player;
        this.inventory = inventory;
        this.enemies = Arrays.asList(enemies);
        this.action = null;
    }
    public void initCombatState() throws InterruptedException {
        if(shouldInitCombatState()) {
            System.out.println("Threat present at your current location");
            System.out.println("Entering Combat\n Use Attack <weapon name> to attack the enemy.\n If weapon is not present basic fist damage will be dealt");
            currentEnemy.showHealth();
            //TODO set state variable -- future task
            combat(player, currentEnemy, inventory);
        }
    }

    private void combat(Player player, Enemy enemy, Inventory inventory) throws InterruptedException {
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase(Locale.ROOT);
            action = new ArrayList<>(Arrays.asList(preparedString(input)));
            if(action.contains("attack") && action.size() > 1 && inventory.fetch(action.get(1))!=null) {
                Weapon weapon = (Weapon) inventory.fetch(action.get(1));
                enemy.setHealth(enemy.getHealth() - weapon.getDamage());
                System.out.println("Attacked with "+weapon.getName() + ". This weapon did "+ weapon.getDamage()+ " damage.");
            }else if(action.contains("attack")) {
                System.out.println("Weapon not found in inventory. Attacking with fists");
                enemy.setHealth(enemy.getHealth() - 20);
            }else {
                System.out.println("Invalid command!");
            }
            enemy.showHealth();

            if(enemy.getHealth() > 0) {
                //TimeUnit.SECONDS.sleep(1);
                System.out.println(ANSI_RED + "Enemy Attacked You." + ANSI_RESET);
                //currently enemy does 25 damage and kills in 4 hits
                player.setHealth(player.getHealth() - 25);
                player.showHealth();
        }
            if(enemy.getHealth() <= 0 )
                System.out.println(ANSI_GREEN + "\nYou won this fight!\nYour current health: "+ player.getHealth() + ANSI_RESET);
        }
    }

    private boolean shouldInitCombatState() {
        for(Enemy e : enemies) {
            if (isAroundEnemy(player, e)) {
                currentEnemy = e;
                return true;
            }
        }
        return false;
    }

    private boolean isAroundEnemy(Player player, Enemy enemy){
        return player.getXdistance() == enemy.getXdistance() && player.getYdistance() == enemy.getYdistance();
    }

    private String[] preparedString(String input){
        String preparedString = input.toLowerCase();
        String[] words = preparedString.split(" ");
        return words;
    }
}
