/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Patrones;

/**
 *
 * @author andy2
 * @param <T>
 */
public interface IPrototype<T extends IPrototype> extends Cloneable{
    public T clone(); 
}
