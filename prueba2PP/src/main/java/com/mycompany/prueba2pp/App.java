package com.mycompany.prueba2pp;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javafx.scene.shape.*;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AnchorPane anchor = new AnchorPane();
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        Scene scena = new Scene (anchor);
        stage.setWidth(800);
        stage.setHeight(600);
        
        

        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        
        for (int i=0; i<10; i++){
            arreglo.add( (int)Math.floor(Math.random()*(99-1+1)+1));
        }
        
        for (int i=0; i<10; i++){
            System.out.println(arreglo.get(i)+ " ");
        }
       
        
        Label etiqueta = new Label(arreglo.toString());
        anchor.getChildren().add(etiqueta);
        
        
        Ordenamiento(arreglo);
        
       // ArrayList <Rectangle> rectangulos = new ArrayList();
        
        
       
        Rectangle rectangulo1 = new Rectangle ();
        rectangulo1.setX(50);
        rectangulo1.setY(50);
        rectangulo1.setFill(Color.PINK);
        rectangulo1.setWidth(40);
        rectangulo1.setHeight((arreglo.get(0)*700)/99);
        anchor.getChildren().add(rectangulo1);
        stage.setScene(scena);
        Label cantRec1 = new Label (arreglo.get(0).toString());
        anchor.getChildren().add(cantRec1);
        cantRec1.relocate(65, 60);
        
        Rectangle rectangulo2 = new Rectangle ();
        rectangulo2.setX(100);
        rectangulo2.setY(50);
        rectangulo2.setFill(Color.PINK);
        rectangulo2.setWidth(40);
        rectangulo2.setHeight((arreglo.get(1)*700)/99);
        anchor.getChildren().add(rectangulo2);
        stage.setScene(scena);    
        Label cantRec2 = new Label (arreglo.get(1).toString());
        anchor.getChildren().add(cantRec2);
        cantRec2.relocate(115, 60);
        
        Rectangle rectangulo3 = new Rectangle ();
        rectangulo3.setX(150);
        rectangulo3.setY(50);
        rectangulo3.setFill(Color.PINK);
        rectangulo3.setWidth(40);
        rectangulo3.setHeight((arreglo.get(2)*700)/99);
        anchor.getChildren().add(rectangulo3);
        stage.setScene(scena);
        Label cantRec3 = new Label (arreglo.get(2).toString());
        anchor.getChildren().add(cantRec3);
        cantRec3.relocate(165, 60);
        
        Rectangle rectangulo4 = new Rectangle ();
        rectangulo4.setX(200);
        rectangulo4.setY(50);
        rectangulo4.setFill(Color.PINK);
        rectangulo4.setWidth(40);
        rectangulo4.setHeight((arreglo.get(3)*700)/99);
        anchor.getChildren().add(rectangulo4);
        stage.setScene(scena);
        Label cantRec4 = new Label (arreglo.get(3).toString());
        anchor.getChildren().add(cantRec4);
        cantRec4.relocate(215, 60);
        
        Rectangle rectangulo5 = new Rectangle ();
        rectangulo5.setX(250);
        rectangulo5.setY(50);
        rectangulo5.setFill(Color.PINK);
        rectangulo5.setWidth(40);
        rectangulo5.setHeight((arreglo.get(4)*700)/99);
        anchor.getChildren().add(rectangulo5);
        stage.setScene(scena);
        Label cantRec5 = new Label (arreglo.get(4).toString());
        anchor.getChildren().add(cantRec5);
        cantRec5.relocate(265, 60);
        
        Rectangle rectangulo6 = new Rectangle ();
        rectangulo6.setX(300);
        rectangulo6.setY(50);
        rectangulo6.setFill(Color.PINK);
        rectangulo6.setWidth(40);
        rectangulo6.setHeight((arreglo.get(5)*700)/99);
        anchor.getChildren().add(rectangulo6);
        stage.setScene(scena);
        Label cantRec6 = new Label (arreglo.get(5).toString());
        anchor.getChildren().add(cantRec6);
        cantRec6.relocate(315, 60);
        
        Rectangle rectangulo7 = new Rectangle ();
        rectangulo7.setX(350);
        rectangulo7.setY(50);
        rectangulo7.setFill(Color.PINK);
        rectangulo7.setWidth(40);
        rectangulo7.setHeight((arreglo.get(6)*700)/99);
        anchor.getChildren().add(rectangulo7);
        stage.setScene(scena);
        Label cantRec7 = new Label (arreglo.get(6).toString());
        anchor.getChildren().add(cantRec7);
        cantRec7.relocate(365, 60);
        
        Rectangle rectangulo8 = new Rectangle ();
        rectangulo8.setX(400);
        rectangulo8.setY(50);
        rectangulo8.setFill(Color.PINK);
        rectangulo8.setWidth(40);
        rectangulo8.setHeight((arreglo.get(7)*700)/99);
        anchor.getChildren().add(rectangulo8);
        stage.setScene(scena);
        Label cantRec8 = new Label (arreglo.get(7).toString());
        anchor.getChildren().add(cantRec8);
        cantRec8.relocate(415, 60);
        
        Rectangle rectangulo9 = new Rectangle ();
        rectangulo9.setX(450);
        rectangulo9.setY(50);
        rectangulo9.setFill(Color.PINK);
        rectangulo9.setWidth(40);
        rectangulo9.setHeight((arreglo.get(8)*700)/99);
        anchor.getChildren().add(rectangulo9);
        stage.setScene(scena);
        Label cantRec9 = new Label (arreglo.get(8).toString());
        anchor.getChildren().add(cantRec9);
        cantRec9.relocate(465, 60);
        
        Rectangle rectangulo10 = new Rectangle ();
        rectangulo10.setX(500);
        rectangulo10.setY(50);
        rectangulo10.setFill(Color.PINK);
        rectangulo10.setWidth(40);
        rectangulo10.setHeight((arreglo.get(9)*700)/99);
        anchor.getChildren().add(rectangulo10);
        stage.setScene(scena);
        Label cantRec10 = new Label (arreglo.get(9).toString());
        anchor.getChildren().add(cantRec10);
        cantRec10.relocate(515, 60);
        
        

        
        stage.show();
    }
    
    public void Ordenamiento (ArrayList <Integer> arreglo){
        int aux=0,j=0;
        for(int i=1;i<arreglo.size();i++){
          aux=arreglo.get(i);
          j=i-1;
          while (j>=0 && aux<arreglo.get(j)){
             arreglo.set(j+1, arreglo.get(j));
             j--;
             System.out.print("--->  ");
             imprimeArreglo(arreglo);
          }
          
          arreglo.set(j+1, aux);
          
        }
        System.out.print("--->  ");
             imprimeArreglo(arreglo);
    
    }
    
    public void imprimeArreglo(ArrayList <Integer> arreglo){
        System.out.print("[ ");
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.print(arreglo.get(i)+" "); 
        }
        System.out.println("]");
    
    }

    public static void main(String[] args) {
        launch();
    }

}