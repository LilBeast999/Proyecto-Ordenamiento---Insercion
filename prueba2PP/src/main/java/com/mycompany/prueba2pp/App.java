package com.mycompany.prueba2pp;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {
private static final int TIEMPO_ESPERA = 1000; // 1 segundo
    @Override
    public void start(Stage stage) {
        AnchorPane anchor = new AnchorPane();

        Scene scena = new Scene (anchor);
        stage.setWidth(1024);
        stage.setHeight(768);
        scena.setFill(Color.web("#AABDD8"));
        

        // apartir de aca OJO
        ArrayList <Integer> arreglo = new ArrayList();
        
        for (int i=0; i<18; i++){
            arreglo.add( (int)Math.floor(Math.random()*(99-1+1)+1));
        }
        Label[] etiquetasCodigo = {
                new Label("1. Para i = 1 hasta n-1 hacer:"),
                new Label("2.     j = i"),
                new Label("3.     mientras j > 0 y A[j-1] > A[j] hacer:"),
                new Label("4.         intercambiar A[j] y A[j-1]"),
                new Label("5.         j = j - 1")
        };
        Label etiquetaArreglo = new Label(arrayToString(arreglo));
        VBox root = new VBox(10);
        root.getChildren().addAll(etiquetasCodigo);
        root.getChildren().add(etiquetaArreglo);
        
        Lapiz lapiz= new Lapiz(anchor);
        
        anchor=lapiz.dibujarfondo();
        anchor=lapiz.dibujar0();
        anchor=lapiz.dibujar1();
        anchor=lapiz.dibujar2();
        anchor=lapiz.dibujar3();
        anchor=lapiz.dibujar4();
        anchor=lapiz.dibujar5();
        anchor=lapiz.dibujar6();
        anchor=lapiz.dibujar7();
        anchor=lapiz.dibujar8();
        anchor=lapiz.dibujar9();
        
       
        Label etiqueta = new Label(arreglo.toString());
        anchor.getChildren().add(etiqueta);
        
        ArrayList <Rectangle> rectangulos = new ArrayList();
        ArrayList <Text> valores = new ArrayList();
       
        Text numero = new Text(100,100,Integer.toString(arreglo.get(0)));
        //anchor.getChildren().add(numero);
        
        for (int i = 0; i < arreglo.size(); i++) {
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
        }
        
        Ordenamiento(arreglo,valores,rectangulos);
      
        
        stage.setScene(scena);
      
        

        
        stage.show();
    }

    public void Ordenamiento (ArrayList<Integer> arreglo, ArrayList<Text>valores, ArrayList<Rectangle>rectangulos){
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
            int velocidad = 400 ;
            SequentialTransition movCajas = new SequentialTransition ();
            SequentialTransition movNumeros = new SequentialTransition ();
            int aux=0,j=0;
            Rectangle recAux = new Rectangle();
            Text valAux = new Text();
            for(int i=1;i<arreglo.size();i++){
           
                aux = arreglo.get(i);       //Se saca el elemento que se va a comparar
                recAux = rectangulos.get(i);
                valAux = valores.get(i);
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),recAux);
                trasCaja.setByY(-300);
                movCajas.getChildren().add(trasCaja);
                TranslateTransition trasValor = new TranslateTransition(Duration.millis(velocidad),valAux);
                trasValor.setByY(-300);
                movNumeros.getChildren().add(trasValor);
          
                j=i-1;
          
                while (j>=0 && aux<arreglo.get(j)){
                
                    arreglo.set(j+1, arreglo.get(j));
                    rectangulos.set(j+1, rectangulos.get(j));
                    valores.set(j+1, valores.get(j));
                
                
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),rectangulos.get(j));
                    trasCaja1.setByX(80);
                    movCajas.getChildren().add(trasCaja1);
                
                    TranslateTransition trasValor1 = new TranslateTransition(Duration.millis(velocidad),valores.get(j));
                    trasValor1.setByX(80);
                    movNumeros.getChildren().add(trasValor1);
                
                
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),recAux);
                    trasCaja2.setByX(-80);
                    movCajas.getChildren().add(trasCaja2);
                
                    TranslateTransition trasValor2 = new TranslateTransition(Duration.millis(velocidad),valAux);
                    trasValor2.setByX(-80);
                    movNumeros.getChildren().add(trasValor2);
                
                
                
                    j--;
                
                    System.out.print("--->  ");
                    imprimeArreglo(arreglo);
                }
            
                arreglo.set(j+1, aux);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),recAux);
                trasCaja3.setByY(300);
                movCajas.getChildren().add(trasCaja3);
            
                TranslateTransition trasValor3 = new TranslateTransition(Duration.millis(velocidad),valAux);
                trasValor3.setByY(300);
                movNumeros.getChildren().add(trasValor3);
            
                rectangulos.set(j+1, recAux);
                valores.set(j+1, valAux);
            }
            System.out.print("--->  ");
            imprimeArreglo(arreglo);
        
            movCajas.play();
            movNumeros.play();
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
