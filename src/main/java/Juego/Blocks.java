/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

/**
 * 
 * Clase
 *
 * @author Esteban
 */
public enum Blocks {
    
    /**
     * Enum tipos de bloques en el mapa
     */
    BLANK(0), BRICK(1), STEEL(2), BASE(3), RIVER(4), TREE(5), EDGE(6), TANK(7), STAR(
            8), BOMB(9), CLOCK(10), SHOVEL(11), SHIELD(12);
    // Integer that represents the value of each enum type
    private final int value;

    /**
     * Constructor del tipo de bloque
     *
     * @param value integer que representa un enum del tipo de bloque
     */
    private Blocks(int value) {
        this.value = value;
    }

    /**
     * Return integer del valor del tipo de bloque
     *
     * @return integer del valor del tipo de bloque
     */
    public int getValue() {
        return value;
    }

    /**
     * Return tipo de bloque dado un int
     *
     * @param value integer para determinar el tipo de bloque que es
     * @return tipo de bloque
     */
    public static Blocks getTypeFromInt(int value) {
        return Blocks.values()[value];
    }
    
}
