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
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Button;
import javafx.scene.text.*;




/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        AnchorPane anchor = new AnchorPane();

        Scene scena = new Scene (anchor);
        stage.setWidth(1024);
        stage.setHeight(768);
        scena.setFill(Color.web("#AABDD8"));
        stage.setMaximized(true);

        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        Almacen almacen = new Almacen(0,0);
        System.out.println("Probando la herencia");
        System.out.println("la posicion x es: "+almacen.getPosicionx());
        int numerodecajas=18;
        
        
        Lapiz lapiz= new Lapiz(anchor);
        //AnchorPane caja = new AnchorPane();
        anchor=lapiz.dibujarfondo();
        anchor=lapiz.dibujargrua();
        //caja.setLayoutX(600);
        //caja.setLayoutY(800);
        //caja.setPrefSize(60, 60);
        
        AnchorPane caja = new AnchorPane();
        anchor=lapiz.dibujarfondo();
        
        //anchor.getChildren().add(caja);
        
        ArrayList<AnchorPane> cajasAnchor = new ArrayList();
        
        
        for(int i=0;i<numerodecajas;i++){
            Caja caja1 = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
            almacen.cajas.add(caja1);
            cajasAnchor.add(almacen.dibujarcaja(200+(80*i),850, anchor));
            
        }
        
        for (int i=0; i<18; i++){
            arreglo.add( almacen.cajas.get(i).peso);
        }
        
        for (int i=0; i<18; i++){
            System.out.println(arreglo.get(i)+ " ");
        }
        
        AnchorPane gancho = new AnchorPane();
        gancho=almacen.dibujargancho(anchor);
        
        anchor=lapiz.dibujargrua();
        //caja.setLayoutX(600);
        //caja.setLayoutY(800);
        //caja.setPrefSize(60, 60);
        
        //aja.setStyle("-fx-background-color: #533E00;");
        
        //anchor.getChildren().add(caja);
        
        
        
        Ordenamiento(arreglo,cajasAnchor,gancho);
        
      
        
        stage.setScene(scena);
        stage.show();
    }

    public void Ordenamiento (ArrayList<Integer> arreglo, ArrayList<AnchorPane>cajasAnchor,AnchorPane gancho){
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            int velocidad = 1000 ;
            SequentialTransition movCajas = new SequentialTransition ();
            SequentialTransition movGancho = new SequentialTransition ();
            int aux=0,j=0;
            AnchorPane cajaAux = new AnchorPane();
            for(int i=1;i<arreglo.size();i++){
                
                aux = arreglo.get(i);       //Se saca el elemento que se va a comparar
                cajaAux = cajasAnchor.get(i);
                TranslateTransition trasGancho = new TranslateTransition(Duration.millis(velocidad),gancho);
                trasGancho.setToX(cajaAux.getLayoutX()-200);
                movGancho.getChildren().add(trasGancho);
                
                TranslateTransition bajaGancho = new TranslateTransition(Duration.millis(velocidad),gancho);
                bajaGancho.setByY(300);
                movGancho.getChildren().add(bajaGancho);
                
                TranslateTransition subeGancho = new TranslateTransition(Duration.millis(velocidad),gancho);
                subeGancho.setByY(-300);
                movGancho.getChildren().add(subeGancho);
                
                
                TranslateTransition trasVacioCaja = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja);
                
                TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja1);
                
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja.setByY(-300);
                movCajas.getChildren().add(trasCaja);         
                j=i-1;
          
                while (j>=0 && aux<arreglo.get(j)){
                    
                    arreglo.set(j+1, arreglo.get(j));
                    cajasAnchor.set(j+1, cajasAnchor.get(j));
                       
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByX(80);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioGancho = new TranslateTransition(Duration.millis(velocidad));
                    movGancho.getChildren().add(trasVacioGancho);
                    
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                    trasCaja2.setByX(-80);
                    movCajas.getChildren().add(trasCaja2);
                    
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                    trasGancho1.setByX(-80);
                    movGancho.getChildren().add(trasGancho1);

                    j--;
                
                    System.out.print("--->  ");
                    imprimeArreglo(arreglo);
                }
                
                TranslateTransition bajaGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                bajaGancho1.setByY(300);
                movGancho.getChildren().add(bajaGancho1);
                
                arreglo.set(j+1, aux);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja3.setByY(300);
                movCajas.getChildren().add(trasCaja3);
                
                TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja2);
                
                TranslateTransition subeGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho);
                subeGancho1.setByY(-300);
                movGancho.getChildren().add(subeGancho1);
                
                
                cajasAnchor.set(j+1, cajaAux);
            }
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
        
            movCajas.play();
            movGancho.play();
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