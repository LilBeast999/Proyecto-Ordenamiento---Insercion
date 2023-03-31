/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2pp;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author gusta
 */
public class Lapiz {
    int posicionx, posiciony;
    AnchorPane anchor= new AnchorPane();

    public Lapiz(int posicionx, int posiciony) {
        this.posicionx = posicionx;
        this.posiciony = posiciony;
    }

    public Lapiz(AnchorPane anchor) {
        this.anchor= anchor;
    }
    
    
    
    public  AnchorPane dibujarfondo(){
     Line line= new Line();
     line.setStartX(0);
     line.setStartY(0);
     line.setEndX(400);
     line.setEndY(300);
     line.setStrokeWidth(5);
     
     Line line1= new Line();
     line1.setStartX(300);
     line1.setStartY(400);
     line1.setEndX(600);
     line1.setEndY(100);
     line1.setStrokeWidth(5);
     
     Line line2= new Line();
     line2.setStartX(600);
     line2.setStartY(100);
     line2.setEndX(900);
     line2.setEndY(400);
     line2.setStrokeWidth(5);
     
     Line line3= new Line();
     line3.setStartX(700);
     line3.setStartY(200);
     line3.setEndX(1000);
     line3.setEndY(100);
     line3.setStrokeWidth(5);
     
     Line line4= new Line();
     line4.setStartX(1000);
     line4.setStartY(100);
     line4.setEndX(1300);
     line4.setEndY(200);
     line4.setStrokeWidth(5);
     
     Line line5= new Line();
     line5.setStartX(1183);
     line5.setStartY(160);
     line5.setEndX(1300);
     line5.setEndY(100);
     line5.setStrokeWidth(5);
     
     
     
     Line line6= new Line();
     line6.setStartX(1300);
     line6.setStartY(100);
     line6.setEndX(1450);
     line6.setEndY(200);
     line6.setStrokeWidth(5);
     
     Line line7= new Line();
     line7.setStartX(1300);
     line7.setStartY(400);
     line7.setEndX(1525);
     line7.setEndY(100);
     line7.setStrokeWidth(5);
     
     Line line8= new Line();
     line8.setStartX(1525);
     line8.setStartY(100);
     line8.setEndX(1800);
     line8.setEndY(400);
     line8.setStrokeWidth(5);
     
     Line line9= new Line();
     line9.setStartX(1665);
     line9.setStartY(250);
     line9.setEndX(1920);
     line9.setEndY(120);
     line9.setStrokeWidth(5);
     
     this.anchor.getChildren().add(line);
     this.anchor.getChildren().add(line1);
     this.anchor.getChildren().add(line2);
     this.anchor.getChildren().add(line3);
     this.anchor.getChildren().add(line4);
     this.anchor.getChildren().add(line5);
     this.anchor.getChildren().add(line6);
     this.anchor.getChildren().add(line7);
     this.anchor.getChildren().add(line8);
     this.anchor.getChildren().add(line9);
     //this.anchor.getChildren().add(line10);
     //this.anchor.getChildren().add(line11);
     //this.anchor.getChildren().add(line12);
     //this.anchor.getChildren().add(line7);
     return this.anchor;
     
    }
    
    public void dibujarcaja(){
    
    }
    
     public void dibujargrua(){
    
    }
     
    public void dibujar1(){
    
    } 
    
    public void dibujar2(){
    
    }
    
    public void dibujar3(){
    
    }
    
    public void dibujar4(){
    
    }
    
    public void dibujar5(){
    
    }
    
    public void dibujar6(){
    
    }
    
    public void dibujar7(){
    
    }
    
    public void dibujar8(){
    
    }
    
    public void dibujar9(){
    
    }
    
    public void dibujargancho(){
    
    }
}
