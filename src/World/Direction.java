package World;

import java.util.Random;

/**
 * @author Oscar van Leusen
 */
public enum Direction {
    Left ("L"),
    Right ("R"),
    Up ("U"),
    Down ("D");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}