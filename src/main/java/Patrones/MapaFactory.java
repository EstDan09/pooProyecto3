/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patrones;

/**
 *
 * @author andy2
 */
public abstract class MapaFactory {
    public abstract int[][] createMap(int stage);
    public abstract int[][] getDefaultLevel();
}
