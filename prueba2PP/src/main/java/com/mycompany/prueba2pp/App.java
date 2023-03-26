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
        
        for (int i=0; i<7; i++){
            arreglo.add( (int)Math.floor(Math.random()*(99-1+1)+1));
        }
        
        for (int i=0; i<7; i++){
            System.out.println(arreglo.get(i)+ " ");
        }
       
        
        Label etiqueta = new Label(arreglo.toString());
        anchor.getChildren().add(etiqueta);
        
        Rectangle rectangulo1 = new Rectangle ();
        rectangulo1.setX(50);
        rectangulo1.setY(50);
        rectangulo1.setFill(Color.RED);
        rectangulo1.setWidth(10);
        rectangulo1.setHeight(50);
        anchor.getChildren().add(rectangulo1);
        
        stage.setScene(scena);
        
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
          }
          arreglo.set(j+1, aux);
        }
        
    
    }

    public static void main(String[] args) {
        launch();
    }

}