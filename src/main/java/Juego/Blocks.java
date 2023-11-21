/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

/**
 *
 * @author Esteban
 */
public enum Blocks {
    
    /**
     * Enum types for blocks on the map
     */
    BLANK(0), BRICK(1), STEEL(2), BASE(3), RIVER(4), TREE(5), EDGE(6), TANK(7), STAR(
            8), BOMB(9), CLOCK(10), SHOVEL(11), SHIELD(12);
    // Integer that represents the value of each enum type
    private final int value;

    /**
     * Constructor of the block type
     *
     * @param value integer that represents the value of each enum type
     */
    private Blocks(int value) {
        this.value = value;
    }

    /**
     * Return integer values that correspond each enum type
     *
     * @return an integer value that corresponds each enum type
     */
    public int getValue() {
        return value;
    }

    /**
     * Return block type given integer value
     *
     * @param value an integer value that corresponds each enum type
     * @return BlockType in the game
     */
    public static Blocks getTypeFromInt(int value) {
        return Blocks.values()[value];
    }
    
}
