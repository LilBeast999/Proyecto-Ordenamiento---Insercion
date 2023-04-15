/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2pp;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

/**
 *
 * @author gusta
 */
public class Almacen extends Lapiz {
    ArrayList <Caja> cajas= new ArrayList();

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

   public AnchorPane dibujarcaja (int posx,int posy, AnchorPane anchor, ArrayList <Group> numeros){
      AnchorPane caja= new AnchorPane();
      caja.setLayoutX(posx);
      caja.setLayoutY(posy);
      caja.setPrefSize(60, 60);
      Rectangle rectangulo= new Rectangle(60,60);
      rectangulo.setFill(Color.web("#784A32"));
      rectangulo.setStroke(Color.BLACK);
      rectangulo.setStrokeWidth(2);
      Rectangle rectangulo1= new Rectangle(7.5,7.5,45,45);
      rectangulo1.setFill(Color.web("#A46644"));
      rectangulo1.setStroke(Color.BLACK);
      rectangulo1.setStrokeWidth(1);
      caja.getChildren().add(rectangulo);
      caja.getChildren().add(rectangulo1);
      
      
       DibujarNumeros(caja, cajas.get(5).peso, numeros);
   

      
      
      
      
      
      
      
      
      
      
     
      anchor.getChildren().add(caja);
      return caja;
       
   }
    
   
    
   
    
    

}
