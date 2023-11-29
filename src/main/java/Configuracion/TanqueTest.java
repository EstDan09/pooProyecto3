/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

/**
 *
 * @author andy2
 */
public class TanqueTest {
    private int velocidadDisparo;
    private int velocidadMovimiento;
    private int tiempoAparicion;
    
    private static TanqueTest singletonInstance;
    
    protected TanqueTest(){}
    
    public static TanqueTest getInstance()
    {
        if (singletonInstance == null)
            singletonInstance = new TanqueTest();
        
        return singletonInstance;
    }

    public int getVelocidadDisparo() {
        return velocidadDisparo;
    }

    public void setVelocidadDisparo(int velocidadDisparo) {
        this.velocidadDisparo = velocidadDisparo;
    }

    public int getVelocidadMovimiento() {
        return velocidadMovimiento;
    }

    public void setVelocidadMovimiento(int velocidadMovimiento) {
        this.velocidadMovimiento = velocidadMovimiento;
    }

    public int getTiempoAparicion() {
        return tiempoAparicion;
    }

    public void setTiempoAparicion(int tiempoAparicion) {
        this.tiempoAparicion = tiempoAparicion;
    }
    
}
