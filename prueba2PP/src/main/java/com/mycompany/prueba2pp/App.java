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
        
        //anchor.getChildren().add(caja);
        
        ArrayList<AnchorPane> cajas = new ArrayList();
        
        for(int i=0;i<numerodecajas;i++){
            Caja caja = new Caja((int)Math.floor(Math.random()*(99-1+1)+1));
            almacen.cajas.add(caja);
            //almacen.dibujarcaja(200+(80*i),850, anchor,almacen.cajas,i);
            cajas.add(almacen.dibujarcaja(200+(80*i),850, anchor,almacen.cajas,i));
        }
        
        for (int i=0; i<18; i++){
            arreglo.add( almacen.cajas.get(i).peso);
        }
        
        for (int i=0; i<18; i++){
            System.out.println(arreglo.get(i)+ " ");
        }
        
        //for (int i=0; i<numerodecajas; i++){
        //    System.out.println(almacen.cajas.get(i).peso+ " esto son los atributos de las cajas");
        //}
        
        Lapiz lapiz= new Lapiz(anchor);
        AnchorPane caja = new AnchorPane();
        anchor=lapiz.dibujarfondo();
        anchor=lapiz.dibujargrua();
        //caja.setLayoutX(600);
        //caja.setLayoutY(800);
        //caja.setPrefSize(60, 60);
        anchor=almacen.dibujarcaja(600, 400, anchor);
        anchor=almacen.dibujargancho(anchor);
        //aja.setStyle("-fx-background-color: #533E00;");
        
        //anchor.getChildren().add(caja);
        
        
       
        
        
        
        
        

        
        ArrayList <Rectangle> rectangulos = new ArrayList();
        ArrayList <Text> valores = new ArrayList();
       
        Text numero = new Text(100,100,Integer.toString(arreglo.get(0)));
        //anchor.getChildren().add(numero);
        
        
        
        /*for (int i = 0; i < arreglo.size(); i++) {
            Rectangle rectangulo = new Rectangle(200+(80*i),850,60,60); 
            rectangulos.add(rectangulo);
            rectangulo.setFill(Color.BROWN);
            anchor.getChildren().add(rectangulo);
            Text valor = new Text(((200+(80*i))+25),880,Integer.toString(arreglo.get(i)));
            valor.scaleXProperty().set(2.5);
            valor.scaleYProperty().set(2.5);
            valor.setFill(Color.WHITE);
            valores.add(valor);
            anchor.getChildren().add(valor);
        }*/
        
        Ordenamiento(arreglo,cajas);
        
      
        
        stage.setScene(scena);
        stage.show();
    }

    public void Ordenamiento (ArrayList<Integer> arreglo, ArrayList<AnchorPane>cajas){
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            int velocidad = 400 ;
            SequentialTransition movCajas = new SequentialTransition ();
            int aux=0,j=0;
            AnchorPane cajaAux = new AnchorPane();
            for(int i=1;i<arreglo.size();i++){
           
                aux = arreglo.get(i);       //Se saca el elemento que se va a comparar
                cajaAux = cajas.get(i);
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja.setByY(-300);
                movCajas.getChildren().add(trasCaja);         
                j=i-1;
          
                while (j>=0 && aux<arreglo.get(j)){
                
                    arreglo.set(j+1, arreglo.get(j));
                    cajas.set(j+1, cajas.get(j));
                
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajas.get(j));
                    trasCaja1.setByX(80);
                    movCajas.getChildren().add(trasCaja1);
                
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                    trasCaja2.setByX(-80);
                    movCajas.getChildren().add(trasCaja2);

                    j--;
                
                    System.out.print("--->  ");
                    imprimeArreglo(arreglo);
                }
            
                arreglo.set(j+1, aux);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja3.setByY(300);
                movCajas.getChildren().add(trasCaja3);
            
                cajas.set(j+1, cajaAux);
            }
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
        
            movCajas.play();
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