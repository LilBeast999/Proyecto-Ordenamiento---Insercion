package com.mycompany.prueba2pp;

import java.util.ArrayList;
import java.util.Random;
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
import static javafx.application.Application.launch;
import javafx.concurrent.Task;
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
        anchor=Pseudocodigo(anchor);
       
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
    public AnchorPane Pseudocodigo(AnchorPane Anchor) {
        int[] arreglo =generarArregloAleatorio(9,1,100);
        
        Text[] etiquetasCodigo = {
                new Text("1. Para i = 1 hasta n-1 hacer:"),
                new Text("2.     j = i"),
                new Text("3.     mientras j > 0 y A[j-1] > A[j] hacer:"),
                new Text("4.         intercambiar A[j] y A[j-1]"),
                new Text("5.         j = j - 1")
        };
     
        Text etiquetaArreglo = new Text(arrayToString(arreglo));
        VBox root = new VBox(10);
        root.getChildren().addAll(etiquetasCodigo);
        root.getChildren().add(etiquetaArreglo);
        
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 1; i < arreglo.length; i++) {
                    resaltarLineaCodigo(etiquetasCodigo, 0);
                    Thread.sleep(TIEMPO_ESPERA);
                    
                    int valorActual = arreglo[i];
                    int j = i;
                    
                    resaltarLineaCodigo(etiquetasCodigo, 1);
                    Thread.sleep(TIEMPO_ESPERA);
                    
                    while (j > 0 && arreglo[j - 1] > valorActual) {
                        arreglo[j] = arreglo[j - 1];
                        j--;
                        
                        resaltarLineaCodigo(etiquetasCodigo, 2);
                        Thread.sleep(TIEMPO_ESPERA);
                        
                        etiquetaArreglo.setText(arrayToString(arreglo));
                        
                        resaltarLineaCodigo(etiquetasCodigo, 3);
                        Thread.sleep(TIEMPO_ESPERA);
                        
                        etiquetaArreglo.setText(arrayToString(arreglo));
                        
                        resaltarLineaCodigo(etiquetasCodigo, 4);
                        Thread.sleep(TIEMPO_ESPERA);
                    }
                    
                    arreglo[j] = valorActual;
                    etiquetaArreglo.setText(arrayToString(arreglo));
                }
                return null;
            }
        };
        
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
        root.setPrefSize(400,400);
        Anchor.getChildren().add(root);
        return Anchor; 
    }
     private int[] generarArregloAleatorio(int n, int min, int max) {
        Random random = new Random();
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = random.nextInt(max - min + 1) + min;
        }
        return arreglo;
    }
    private void resaltarLineaCodigo(Text[] etiquetasCodigo, int indiceLinea) {
        for (int i = 0; i < etiquetasCodigo.length; i++) {
            if (i == indiceLinea) {
                etiquetasCodigo[i].setFill(Color.RED);
} else {
etiquetasCodigo[i].setFill(Color.BLACK);
}
}
}
    private String arrayToString(int[] arreglo) {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i < arreglo.length; i++) {
        sb.append(arreglo[i]);
        if (i < arreglo.length - 1) {
            sb.append(", ");
        }
    }
    sb.append(" ]");
    return sb.toString();
}

public static void main(String[] args) {
    launch(args);
}
    
    
    
    }
    
  
    
    
}