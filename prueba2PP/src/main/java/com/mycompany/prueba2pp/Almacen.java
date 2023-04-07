/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2pp;

import java.util.ArrayList;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author gusta
 */
public class Almacen extends Lapiz {
    ArrayList <Cajas> cajas= new ArrayList();

    public Almacen(int posicionx, int posiciony) {
        super(posicionx, posiciony);
    }

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public AnchorPane getAnchor() {
        return anchor;
    }

    public void setAnchor(AnchorPane anchor) {
        this.anchor = anchor;
    }
    
   
    
   
    
    

}
