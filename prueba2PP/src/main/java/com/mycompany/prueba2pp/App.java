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
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.*;




/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        AnchorPane anchor = new AnchorPane();
        
        Scene scena = new Scene (anchor,1024,768);
        scena.setFill(Color.web("#AABDD8"));
        stage.setMaximized(true);

        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        Almacen almacen = new Almacen(0,0);
        System.out.println("Probando la herencia");
        System.out.println("la posicion x es: "+almacen.getPosicionx());
        int numerodecajas=18;
        
        
        Lapiz lapiz= new Lapiz(anchor);
        lapiz.dibujarfondo();
        lapiz.dibujargrua();
               
        ArrayList<AnchorPane> cajasAnchor = new ArrayList();
                
        //Crea las cajas AnchorPane y las añade al arreglo de cajas de tipo Anchor y al arreglo de cajas de Almacén
        for(int i=0;i<numerodecajas;i++){       
            Caja caja1 = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
            almacen.cajas.add(caja1);
            cajasAnchor.add(almacen.dibujarcaja(200+(80*i),850, anchor,i));
        }

        
        
        //Obtiene los números generados previamente para que los valores calcen con los del arreglo que se muestra en consola
        for (int i=0; i<18; i++){ 
            arreglo.add( almacen.cajas.get(i).peso);
            System.out.print(arreglo.get(i)+ " ");
        }
        
        
        AnchorPane gancho1 = new AnchorPane();
        gancho1 = almacen.dibujargancho(anchor,210,462);
        AnchorPane cuerda1 = new AnchorPane();
        cuerda1 = lapiz.dibujarcuerda(210,442);
        anchor.getChildren().add(cuerda1);
        
        AnchorPane gancho2 = new AnchorPane ();
        gancho2 = almacen.dibujargancho(anchor, 350, 442);
        AnchorPane cuerda2 = new AnchorPane();
        cuerda2 = lapiz.dibujarcuerda(350,422);
        anchor.getChildren().add(cuerda2);
        

               
        Ordenamiento(arreglo,cajasAnchor,gancho1, cuerda1, gancho2, cuerda2);
        
        stage.setScene(scena);
        stage.show();
    }

    public void Ordenamiento (ArrayList<Integer> arreglo, ArrayList<AnchorPane>cajasAnchor,AnchorPane gancho1, AnchorPane cuerda1, AnchorPane gancho2, AnchorPane cuerda2){
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            int velocidad = 2000 ;
            SequentialTransition movCajas = new SequentialTransition();
            SequentialTransition movGancho1 = new SequentialTransition();
            SequentialTransition movCuerda1 = new SequentialTransition();
            SequentialTransition movGancho2 = new SequentialTransition();
            SequentialTransition movCuerda2 = new SequentialTransition();
            int aux=0,j=0;
            AnchorPane cajaAux = new AnchorPane();
            for(int i=1;i<arreglo.size();i++){
                
                aux = arreglo.get(i);       //Se saca el elemento que se va a comparar
                cajaAux = cajasAnchor.get(i);
                
                
                TranslateTransition trasVacioCaja = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja);
                TranslateTransition trasVacioGancho2_1 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_1);
                TranslateTransition trasVacioCuerda2_1 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_1);
                TranslateTransition trasCuerda1_1 = new TranslateTransition(Duration.millis(velocidad),cuerda1);
                trasCuerda1_1.setToX(cajaAux.getLayoutX()-200);
                movCuerda1.getChildren().add(trasCuerda1_1);               
                TranslateTransition trasGancho1_1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                trasGancho1_1.setToX(cajaAux.getLayoutX()-200);
                movGancho1.getChildren().add(trasGancho1_1);
                
                TranslateTransition trasVacioGancho2_2 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_2);
                TranslateTransition trasVacioCuerda2_2 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_2);
                TranslateTransition trasVacioCaja1 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja1);
                TranslateTransition trasVacioCuerda1_1 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_1);
                TranslateTransition bajaGancho1_1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                bajaGancho1_1.setByY(180);
                movGancho1.getChildren().add(bajaGancho1_1);
                            
                
                TranslateTransition trasVacioGancho2_3 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_3);
                TranslateTransition trasVacioCuerda2_3 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_3);
                TranslateTransition subeGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1.setByY(-180);
                movGancho1.getChildren().add(subeGancho1);              
                TranslateTransition trasVacioCuerda1_2 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_2); 
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja.setByY(-180);
                movCajas.getChildren().add(trasCaja);         
                j=i-1;
                
                while (j>=0 && aux<arreglo.get(j)){
                    
                    arreglo.set(j+1, arreglo.get(j));
                    cajasAnchor.set(j+1, cajasAnchor.get(j));
                    
                    TranslateTransition trasGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_1.setToX(cajasAnchor.get(j).getLayoutX()-200);
                    movCuerda2.getChildren().add(trasGancho2_1);
                    
                    TranslateTransition bajaGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    bajaGancho2_1.setByY(200);
                    movGancho2.getChildren().add(bajaGancho2_1);
                    
                    TranslateTransition trasGancho2_2 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_2.setByX(80);
                    movGancho2.getChildren().add(trasGancho2_1);
                    
                    
                       
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByX(80);
                    movCajas.getChildren().add(trasCaja1);
                    
                    TranslateTransition trasVacioGancho1_2 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_2);
                    
                    TranslateTransition trasVacioCuerda1_3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_3);
                    
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                    trasCaja2.setByX(-80);
                    movCajas.getChildren().add(trasCaja2);
                    
                    TranslateTransition trasGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                    trasGancho1.setByX(-80);
                    movGancho1.getChildren().add(trasGancho1);
                    
                    TranslateTransition trasCuerda1_3 = new TranslateTransition(Duration.millis(velocidad),cuerda1);
                    trasCuerda1_3.setByX(-80);
                    movCuerda1.getChildren().add(trasCuerda1_3);

                    j--;
                
                    System.out.print("--->  ");
                    //imprimeArreglo(arreglo);
                }
                
                TranslateTransition bajaGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                bajaGancho1.setByY(180);
                movGancho1.getChildren().add(bajaGancho1);
                
                TranslateTransition trasVacioCuerda1_4 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_4);
                
                arreglo.set(j+1, aux);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja3.setByY(180);
                movCajas.getChildren().add(trasCaja3);
                
                TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja2);
                
                TranslateTransition subeGancho1_2 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1_2.setByY(-180);
                movGancho1.getChildren().add(subeGancho1_2);
                
                TranslateTransition trasVacioCuerda1_5 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_5);
                
                
                cajasAnchor.set(j+1, cajaAux);
            }
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            
            movCajas.play();
            movCuerda1.play();
            movGancho1.play();
            movCuerda2.play();
            movGancho2.play();
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