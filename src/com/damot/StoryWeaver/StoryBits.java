package com.damot.StoryWeaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Add story bits here. Story bits can be added as enums.
 * Usage: define x and y position where your story bit will be displayed.
 */
public enum StoryBits {
    HELLO(Collections.singletonList(0), Collections.singletonList(0),"Hello, Traveller!\n"),
    MOVE_AHEAD(Arrays.asList(0,1), Collections.singletonList(2), "Move Ahead... Fear Not Traveller\nYour Journey ahead is long."),
    AHEAD_1(Arrays.asList(0),Arrays.asList(6),"Welcome to the city of Agora !!!"),
    AHEAD_2(Arrays.asList(0),Arrays.asList(4,8),"Let me take you through the city  !!!"),
    AHEAD_3(Arrays.asList(0),Arrays.asList(10),"This city is historic in nature ... I mean let me take you through the history of Agora"),
    AHEAD_4(Arrays.asList(1),Arrays.asList(2),"This city was a beautiful , prosperous town and was expanding its horizon"),
    AHEAD_5(Arrays.asList(1),Arrays.asList(4),"This city was a beautiful , prosperous town and was expanding its horizon"),
    AHEAD_6(Arrays.asList(1),Arrays.asList(6,8),"This city was a beautiful , prosperous town and was expanding its horizon"),
    AHEAD_7(Arrays.asList(1),Arrays.asList(10),"The bad force left people with no choice "),
    AHEAD_8(Arrays.asList(2),Arrays.asList(1),"Since then , people are struggling to make ends meet , doing petty jobs"),

    HOUSE(Arrays.asList(2,4),Arrays.asList(6),"Look around...A chocolate house"),
    HILLS(Arrays.asList(3),Arrays.asList(10),"Climb up the hill to see the whole city"),
    CHILDREN(Arrays.asList(4,5),Arrays.asList(9,4),"Such cute kids running around... wanna spend some time with them?"),
    HELP(Arrays.asList(6,7),Arrays.asList(8),"These kids need help .. someone stole their coins"),
    HELP_1(Arrays.asList(6),Arrays.asList(10),"Coins are kept inside the dragon's cave"),
    RESCUE(Arrays.asList(7),Arrays.asList(10),"Hurray... The dragon is now gone... You can give the coins to the kids."),
    WILD_DOGS(Arrays.asList(8),Arrays.asList(2,4),"Wild dogs are after you... Run for your life!!!"),
    RESCUE_3(Arrays.asList(8),Arrays.asList(6),"Phew... left those dogs behind!!"),
    EVIL(Arrays.asList(8),Arrays.asList(8),"Something is fishy... The sky turns green ... pungent smell makes you harder to breathe"),
    EVIL_1(Arrays.asList(8),Arrays.asList(10),"You can see a women from a distance... Her eyes are red ... looks like a vampire... run!! "),
    EVIL_2(Arrays.asList(9),Arrays.asList(4)," Vampire leaves behind a trail ... leading to a secret chamber ... There is a note left behind... walk further to know more"),
    EVIL_3(Arrays.asList(9),Arrays.asList(6),"Note says : I am the guardian of the city ... some bad force entered this town few decades ago...ruined the life there ... killed me... but through a bite of a kind vampire, I got this life as a Vampire... My mission is to ensure everyone is safe here "),
    SAFE(Arrays.asList(9),Arrays.asList(8),"The city is now visible... the sky turns blue again... the sun shines , the birds chirp"),
    RESCUE_1(Arrays.asList(10), Arrays.asList(1),"Kids thank you for your effort... keep going ahead"),
    END(Arrays.asList(10),Arrays.asList(4,6,8),"Hang on there ... reaching the end of game"),
    END_1(Arrays.asList(10),Arrays.asList(10),"Congratulations !!! .... completed the game...How did you like the story?"),
    TREE(Arrays.asList(1,3,8),Arrays.asList(2,6,8),"Wanna rest here...sit under a tree"),



    ;
    private final List<Integer> xPosition;
    private final List<Integer>  yPosition;
    private final String storyBit;



    StoryBits(List<Integer>  xPosition, List<Integer>  yPosition, String storyBit) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.storyBit = storyBit;
    }

    public List<Integer>  getxPosition() {
        return xPosition;
    }

    public List<Integer>  getyPosition() {
        return yPosition;
    }

    public String getStoryBit() {
        return storyBit;
    }

    @Override
    public String toString() {
        return storyBit;
    }
}
