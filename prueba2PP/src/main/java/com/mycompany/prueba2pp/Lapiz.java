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
     
     Line line10= new Line();
     line10.setStartX(0);
     line10.setStartY(100);
     line10.setEndX(10);
     line10.setEndY(75);
     line10.setStrokeWidth(5);     
     
     Line line11= new Line();
     line11.setStartX(10);
     line11.setStartY(75);
     line11.setEndX(25);
     line11.setEndY(90);
     line11.setStrokeWidth(5); 
     
     Line line12= new Line();
     line12.setStartX(25);
     line12.setStartY(90);
     line12.setEndX(45);
     line12.setEndY(70);
     line12.setStrokeWidth(5); 
     
     Line line13= new Line();
     line13.setStartX(45);
     line13.setStartY(70);
     line13.setEndX(70);
     line13.setEndY(100);
     line13.setStrokeWidth(5); 
     
     Line line14= new Line();
     line14.setStartX(70);
     line14.setStartY(100);
     line14.setEndX(100);
     line14.setEndY(80);
     line14.setStrokeWidth(5); 
     
     Line line15= new Line();
     line15.setStartX(500);
     line15.setStartY(200);
     line15.setEndX(530);
     line15.setEndY(230);
     line15.setStrokeWidth(5); 
     
     Line line16= new Line();
     line16.setStartX(530);
     line16.setStartY(230);
     line16.setEndX(550);
     line16.setEndY(210);
     line16.setStrokeWidth(5);
     
     Line line17= new Line();
     line17.setStartX(550);
     line17.setStartY(210);
     line17.setEndX(580);
     line17.setEndY(240);
     line17.setStrokeWidth(5);
     
     Line line18= new Line();
     line18.setStartX(580);
     line18.setStartY(240);
     line18.setEndX(640);
     line18.setEndY(200);
     line18.setStrokeWidth(5);
     
     Line line19= new Line();
     line19.setStartX(640);
     line19.setStartY(200);
     line19.setEndX(670);
     line19.setEndY(250);
     line19.setStrokeWidth(5);
     
     Line line20= new Line();
     line20.setStartX(670);
     line20.setStartY(250);
     line20.setEndX(720);
     line20.setEndY(220);
     line20.setStrokeWidth(5);
     
     Line line21= new Line();
     line21.setStartX(900);
     line21.setStartY(135);
     line21.setEndX(950);
     line21.setEndY(190);
     line21.setStrokeWidth(5);
     
     Line line22= new Line();
     line22.setStartX(950);
     line22.setStartY(190);
     line22.setEndX(980);
     line22.setEndY(150);
     line22.setStrokeWidth(5);
     
     Line line23= new Line();
     line23.setStartX(980);
     line23.setStartY(150);
     line23.setEndX(1000);
     line23.setEndY(170);
     line23.setStrokeWidth(5);
     
     Line line24= new Line();
     line24.setStartX(1000);
     line24.setStartY(170);
     line24.setEndX(1020);
     line24.setEndY(140);
     line24.setStrokeWidth(5);
     
     Line line25= new Line();
     line25.setStartX(1020);
     line25.setStartY(140);
     line25.setEndX(1050);
     line25.setEndY(180);
     line25.setStrokeWidth(5);
     
     Line line26= new Line();
     line26.setStartX(1050);
     line26.setStartY(180);
     line26.setEndX(1148);
     line26.setEndY(150);
     line26.setStrokeWidth(5);
     
     Line line27= new Line();
     line27.setStartX(1230);
     line27.setStartY(140);
     line27.setEndX(1260);
     line27.setEndY(160);
     line27.setStrokeWidth(5);
     
     Line line28= new Line();
     line28.setStartX(1260);
     line28.setStartY(160);
     line28.setEndX(1290);
     line28.setEndY(140);
     line28.setStrokeWidth(5);
     
     Line line29= new Line();
     line29.setStartX(1290);
     line29.setStartY(140);
     line29.setEndX(1320);
     line29.setEndY(170);
     line29.setStrokeWidth(5);
     
     Line line30= new Line();
     line30.setStartX(1320);
     line30.setStartY(170);
     line30.setEndX(1340);
     line30.setEndY(150);
     line30.setStrokeWidth(5);
     
     Line line31= new Line();
     line31.setStartX(1340);
     line31.setStartY(150);
     line31.setEndX(1360);
     line31.setEndY(160);
     line31.setStrokeWidth(5);
     
     Line line32= new Line();
     line32.setStartX(1360);
     line32.setStartY(160);
     line32.setEndX(1380);
     line32.setEndY(155);
     line32.setStrokeWidth(5);
     
     Line line33= new Line();
     line33.setStartX(1475);
     line33.setStartY(170);
     line33.setEndX(1520);
     line33.setEndY(200);
     line33.setStrokeWidth(5);
     
     Line line34= new Line();
     line34.setStartX(1520);
     line34.setStartY(200);
     line34.setEndX(1550);
     line34.setEndY(180);
     line34.setStrokeWidth(5);
     
     Line line35= new Line();
     line35.setStartX(1550);
     line35.setStartY(180);
     line35.setEndX(1590);
     line35.setEndY(210);
     line35.setStrokeWidth(5);
     
     Line line36= new Line();
     line36.setStartX(1590);
     line36.setStartY(210);
     line36.setEndX(1603);
     line36.setEndY(190);
     line36.setStrokeWidth(5);
     
     Line line37= new Line();
     line37.setStartX(1825);
     line37.setStartY(170);
     line37.setEndX(1870);
     line37.setEndY(190);
     line37.setStrokeWidth(5);
     
     Line line38= new Line();
     line38.setStartX(1870);
     line38.setStartY(190);
     line38.setEndX(1900);
     line38.setEndY(160);
     line38.setStrokeWidth(5);
     
     Line line39= new Line();
     line39.setStartX(1900);
     line39.setStartY(160);
     line39.setEndX(1920);
     line39.setEndY(190);
     line39.setStrokeWidth(5);
     
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
     this.anchor.getChildren().add(line10);
     this.anchor.getChildren().add(line11);
     this.anchor.getChildren().add(line12);
     this.anchor.getChildren().add(line13);
     this.anchor.getChildren().add(line14);
     this.anchor.getChildren().add(line15);
     this.anchor.getChildren().add(line16);
     this.anchor.getChildren().add(line17);
     this.anchor.getChildren().add(line18);
     this.anchor.getChildren().add(line19);
     this.anchor.getChildren().add(line20);
     this.anchor.getChildren().add(line21);
     this.anchor.getChildren().add(line22);
     this.anchor.getChildren().add(line23);
     this.anchor.getChildren().add(line24);
     this.anchor.getChildren().add(line25);
     this.anchor.getChildren().add(line26);
     this.anchor.getChildren().add(line27);
     this.anchor.getChildren().add(line28);
     this.anchor.getChildren().add(line29);
     this.anchor.getChildren().add(line30);
     this.anchor.getChildren().add(line31);
     this.anchor.getChildren().add(line32);
     this.anchor.getChildren().add(line33);
     this.anchor.getChildren().add(line34);
     this.anchor.getChildren().add(line35);
     this.anchor.getChildren().add(line36);
     this.anchor.getChildren().add(line37);
     this.anchor.getChildren().add(line38);
     this.anchor.getChildren().add(line39);
     //this.anchor.getChildren().add(line40);
     //this.anchor.getChildren().add(line41);
     
     
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
