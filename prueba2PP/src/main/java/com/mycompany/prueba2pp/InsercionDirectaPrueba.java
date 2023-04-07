package com.mycompany.prueba2pp;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.text.Text;


 
public class InsercionDirectaPrueba extends Application {
    
    private static final int TIEMPO_ESPERA = 1000; // 1 segundo
    
    @Override
    public void start(Stage primaryStage) {
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
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Ordenamiento por inserción directa");
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
