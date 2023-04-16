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
import javafx.scene.Group;
import javafx.scene.control.Button;
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
            int velocidad = 300 ;
            boolean bajoGancho2;
            SequentialTransition movCajas = new SequentialTransition();
            SequentialTransition movGancho1 = new SequentialTransition();
            SequentialTransition movCuerda1 = new SequentialTransition();
            SequentialTransition movGancho2 = new SequentialTransition();
            SequentialTransition movCuerda2 = new SequentialTransition();
            int aux=0,j=0;
            AnchorPane cajaAux = new AnchorPane();
            for(int i=1;i<arreglo.size();i++){
                
                bajoGancho2 = false;
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
                bajaGancho1_1.setByY(165);
                movGancho1.getChildren().add(bajaGancho1_1);
                                           
                TranslateTransition trasVacioGancho2_3 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_3);
                TranslateTransition trasVacioCuerda2_3 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_3);
                TranslateTransition subeGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1.setByY(-165);
                movGancho1.getChildren().add(subeGancho1);              
                TranslateTransition trasVacioCuerda1_2 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_2); 
                TranslateTransition trasCaja = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja.setByY(-165);
                movCajas.getChildren().add(trasCaja);         
                j=i-1;
                
                
                if(j>=0 && aux<arreglo.get(j)){
                    
                    //Gancho2 va a la caja que debe mover
                    TranslateTransition trasVacioGancho1_2 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_2);
                    TranslateTransition trasVacioCuerda1_3 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_3);
                    TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja2);
                    TranslateTransition trasCuerda2_1 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_1.setToX((cajasAnchor.get(i).getLayoutX()-425));
                    movCuerda2.getChildren().add(trasCuerda2_1);
                    TranslateTransition trasGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_1.setToX((cajasAnchor.get(i).getLayoutX()-425));
                    movGancho2.getChildren().add(trasGancho2_1);
                    
                    bajoGancho2 = true;
                    TranslateTransition trasVacioGancho1_3 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_3);
                    TranslateTransition trasVacioCuerda1_4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_4);
                    TranslateTransition trasVacioCaja3 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja3);
                    TranslateTransition trasVacioCuerda2_4 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda2.getChildren().add(trasVacioCuerda2_4);
                    TranslateTransition bajaGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    bajaGancho2_1.setByY(180);
                    movGancho2.getChildren().add(bajaGancho2_1);
                }
                
                while (j>=0 && aux<arreglo.get(j)){
                                        
                    arreglo.set(j+1, arreglo.get(j));
                    cajasAnchor.set(j+1, cajasAnchor.get(j));
                    bajoGancho2 = true;
                    
                    //Gancho2 mueve la caja inferior que debe mover                                    
                    TranslateTransition trasVacioGancho1_5 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_5);
                    TranslateTransition trasVacioCuerda1_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_6);
                    TranslateTransition trasCuerda2_1 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_1.setByX(80);
                    movCuerda2.getChildren().add(trasCuerda2_1);
                    TranslateTransition trasGancho2_2 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_2.setByX(80);
                    movGancho2.getChildren().add(trasGancho2_2); 
                    TranslateTransition trasCaja1 = new TranslateTransition(Duration.millis(velocidad),cajasAnchor.get(j));
                    trasCaja1.setByX(80);
                    movCajas.getChildren().add(trasCaja1);

                    
                    TranslateTransition trasCaja2 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                    trasCaja2.setByX(-80);
                    movCajas.getChildren().add(trasCaja2);
                    TranslateTransition trasGancho1_2 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                    trasGancho1_2.setByX(-80);
                    movGancho1.getChildren().add(trasGancho1_2);
                    TranslateTransition trasCuerda1_3 = new TranslateTransition(Duration.millis(velocidad),cuerda1);
                    trasCuerda1_3.setByX(-80);
                    movCuerda1.getChildren().add(trasCuerda1_3);
                    
                    TranslateTransition trasCuerda2_2 = new TranslateTransition(Duration.millis(velocidad),cuerda2);
                    trasCuerda2_2.setByX(-160);
                    movCuerda2.getChildren().add(trasCuerda2_2);
                    TranslateTransition trasGancho2_3 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    trasGancho2_3.setByX(-160);
                    movGancho2.getChildren().add(trasGancho2_3);

                    j--;
                
                    //imprimeArreglo(arreglo);
                }
                
                if(bajoGancho2){
                    TranslateTransition trasVacioGancho1_5 = new TranslateTransition(Duration.millis(velocidad));
                    movGancho1.getChildren().add(trasVacioGancho1_5);
                    TranslateTransition trasVacioCuerda1_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda1.getChildren().add(trasVacioCuerda1_6);
                    TranslateTransition trasVacioCaja4 = new TranslateTransition(Duration.millis(velocidad));
                    movCajas.getChildren().add(trasVacioCaja4);
                    TranslateTransition trasVacioCuerda2_6 = new TranslateTransition(Duration.millis(velocidad));
                    movCuerda2.getChildren().add(trasVacioCuerda2_6);
                    TranslateTransition bajaGancho2_1 = new TranslateTransition(Duration.millis(velocidad),gancho2);
                    bajaGancho2_1.setByY(-180);
                    movGancho2.getChildren().add(bajaGancho2_1);
                
                }
                
                arreglo.set(j+1, aux);
                
                //Gancho1 inserta la caja donde corresponde
                TranslateTransition trasVacioCuerda2_6 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_6);
                TranslateTransition trasVacioGancho2_4 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_4);
                TranslateTransition trasVacioCuerda1_4 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda1.getChildren().add(trasVacioCuerda1_4);
                TranslateTransition bajaGancho1 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                bajaGancho1.setByY(165);
                movGancho1.getChildren().add(bajaGancho1);
                TranslateTransition trasCaja3 = new TranslateTransition(Duration.millis(velocidad),cajaAux);
                trasCaja3.setByY(165);
                movCajas.getChildren().add(trasCaja3);
                
                //Gancho1 sube
                TranslateTransition trasVacioCuerda2_7 = new TranslateTransition(Duration.millis(velocidad));
                movCuerda2.getChildren().add(trasVacioCuerda2_7);
                TranslateTransition trasVacioGancho2_5 = new TranslateTransition(Duration.millis(velocidad));
                movGancho2.getChildren().add(trasVacioGancho2_5);
                TranslateTransition trasVacioCaja2 = new TranslateTransition(Duration.millis(velocidad));
                movCajas.getChildren().add(trasVacioCaja2);                
                TranslateTransition subeGancho1_2 = new TranslateTransition(Duration.millis(velocidad),gancho1);
                subeGancho1_2.setByY(-165);
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