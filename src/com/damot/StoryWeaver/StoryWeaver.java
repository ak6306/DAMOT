package com.damot.StoryWeaver;

import com.damot.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static com.damot.Constants.ColorConstant.ANSI_PURPLE;
import static com.damot.Constants.ColorConstant.ANSI_RESET;

/**
 * StoryWeaver provides story bits to the player
 * Usage: This class reads from StoryBits Enum.
 * @version : 1.0
 */
public class StoryWeaver {
    private final Player player;

    public StoryWeaver(Player player) {
        this.player = player;
    }

    public void showBits() {
        ArrayList<StoryBits> storyBits = new ArrayList<>(Arrays.asList(StoryBits.values()));
        System.out.println(ANSI_PURPLE +storyBits.stream()
                .filter(storyBits1 -> storyBits1.getxPosition().contains(player.getXdistance()))
                .filter(storyBits1 -> storyBits1.getyPosition().contains(player.getYdistance()))
                .map(Object::toString).reduce("", String::concat) + ANSI_RESET);
    }
}
