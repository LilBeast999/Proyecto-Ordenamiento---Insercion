package com.mycompany.prueba2pp;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InsercionDirectaPrueba extends Application {
    
    private static final int TIEMPO_ESPERA = 1000; // 1 segundo
    
    @Override
    public void start(Stage primaryStage) {
        int[] arreglo = { 5, 1, 9, 3, 7, 2, 8, 4, 6 };
        
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
    
    private void resaltarLineaCodigo(Label[] etiquetasCodigo, int indiceLinea) {
        for (int i = 0; i < etiquetasCodigo.length; i++) {
            if (i == indiceLinea) {
                etiquetasCodigo[i].setTextFill(Color.RED);
} else {
etiquetasCodigo[i].setTextFill(Color.BLACK);
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
    