package com.damot.StoryWeaver;

/**
 * Add story bits here. Story bits can be added as enums.
 * Usage: define x and y position where your story bit will be displayed.
 */
public enum StoryBits {
    HELLO(0,0, "Hello, Traveller!\n"),
    FIRST(0, 2, "Move Ahead... Fear Not Traveller\nYour Journey ahead is long."),
    ;
    private final int xPosition;
    private final int yPosition;
    private final String storyBit;



    StoryBits(int xPosition, int yPosition, String storyBit) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.storyBit = storyBit;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
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
