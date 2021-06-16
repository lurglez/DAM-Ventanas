/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_ventanas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lurde
 */
public class VentanaB {

    //Establecemos las variables
    public static int ventanaAzul;
    public static int ventanaRosa;
    public static int ventanaAmarilla;
    public static int ventanaBlanca;
    public static int vendidaAzul;
    public static int vendidaRosa;
    public static int vendidaAmarilla;
    public static int vendidaBlanca;

    private String nombre;
    private static int color;
    private static int vendidas;
    private static int creadas;
    //propiedades static y final de la clase
    public static final int ANCHO = 60;
    public static final int LARGO = 30;
    public static final int PRECIO = 120;
    //Inicialización de un array de Strings
    public static final String[] COLORES = {"AZUL", "ROSA", "AMARELO", "BRANCO"};

    //VENTANA B
    //Constructor con color
    public VentanaB(int color, int cantidad) {
        this.color = color - 1;
        //contador creadas modelo A
        creadas += cantidad;
    }
    //Constructor sin valor 

    public VentanaB() {
    }

    //MÉTODOS
    //Devolver ancho
    public static int getAnchoB() {
        return ANCHO;
    }

    //Devolver largo
    public static int getprecioB() {
        return PRECIO;
    }
    //Devolver precio

    public static int getLargoB() {
        return LARGO;
    }
    //Devolver un string con los colores disponibles

    public static String getColoresB() {
        String colores = "Modelo B:";
        for (int i = 0; i < COLORES.length; i++) {
            colores += "\n" + (i + 1) + " ---> " + COLORES[i];
        }
        return colores;//método para pasar un array a String
    }

    //Devolver el color seleccionado por el usuario
    public static String getColor(int seleccion) {
        return COLORES[color];
    }

    //Controla la creación de ventanas
    //Establece un máximo por color y movimiento
    //Ingresa los datos en un array
    public static boolean crearVentanaB(int cantidad, int seleccion) {
        boolean opcion = true;
        int[] totalventanasB = {ventanaAzul, ventanaRosa, ventanaAmarilla, ventanaBlanca};
        //Si la opción es mayor a 30 se devuelve false
        if (cantidad > 30) {
            opcion = false;
        } else {
            //Switch que controla la elección del usuario y establece los cambios indicados
            switch (seleccion) {
                case 1:
                    ventanaAzul += cantidad;
                    break;
                case 2:
                    ventanaRosa += cantidad;
                    break;
                case 3:
                    ventanaAmarilla += cantidad;
                    break;
                case 4:
                    ventanaBlanca += cantidad;
                    break;
                default:
                    opcion = false;
            }
        }
        return opcion;
    }

    //Devuelve el precio total de la compra
    public static double facturaB(int cantidad) {
        double factura = cantidad * PRECIO;
        return factura;
    }
    //Devuelve las ventanas disponibles por colores

    public static String totalVentanasB() {
        int[] totalventanasB = {ventanaAzul, ventanaRosa, ventanaAmarilla, ventanaBlanca};
        String disponibles = "";
        for (int i = 0; i < totalventanasB.length; i++) {
            disponibles += totalventanasB[i] + "       ";
        }

        return "  " + Arrays.toString(COLORES) + "\n"
                + "    " + disponibles + "";
    }

    //COMPRA DE VENTANAS
    //Comprueba que la selección de ventanas está disponible
    public static boolean disponibilidadVentanasB(int compra, int seleccion) {
        boolean opcion = true;
        int[] totalventanasB = {ventanaAzul, ventanaRosa, ventanaAmarilla, ventanaBlanca};

        switch (seleccion) {
            case 1:
                if (ventanaAzul >= compra) {

                } else {
                    opcion = false;
                }
                break;
            case 2:
                if (ventanaRosa >= compra) {
                } else {
                    opcion = false;
                }
                break;
            case 3:
                if (ventanaAmarilla >= compra) {
                } else {
                    opcion = false;
                }
                break;
            case 4:
                if (ventanaBlanca >= compra) {
                } else {
                    opcion = false;
                }
                break;
            default:
                opcion = false;
        }
        return opcion;
    }

    //Realiza los cambios oportunos en los array de ventas y de ventanas disponibles
    //Aumenta el contador general de ventanas vendidas
    public static boolean compraFinal(int compra, int seleccion) {
        boolean opcion = true;
        int[] totalventanasB = {ventanaAzul, ventanaRosa, ventanaAmarilla, ventanaBlanca};
        int[] ventanasVendidasB = {vendidaAzul, vendidaRosa, vendidaAmarilla, vendidaBlanca};

        switch (seleccion) {
            case 1:
                ventanaAzul -= compra;
                vendidaAzul += compra;
                vendidas += compra;
                break;
            case 2:
                ventanaRosa -= compra;
                vendidaRosa += compra;
                vendidas += compra;
                break;
            case 3:
                ventanaAmarilla -= compra;
                vendidaAmarilla += compra;
                vendidas += compra;
                break;
            case 4:
                ventanaBlanca -= compra;
                vendidaBlanca += compra;
                vendidas += compra;
                break;
            default:
                opcion = false;
        }
        return opcion;
    }

    //Devuelve las ventanas vendidas por colores
    public static String ventaTotalB() {
        int[] ventanasVendidasB = {vendidaAzul, vendidaRosa, vendidaAmarilla, vendidaBlanca};

        return Arrays.toString(COLORES) + Arrays.toString(ventanasVendidasB);
    }

    //Devuelve las ganancias acumuladas
    public static double gananciasB() {
        double ganancias;
        ganancias = PRECIO * vendidas;
        return ganancias;
    }
    //Contador ventanas creadas en total en el modelo A

    public static int getContadorB() {
        return creadas;
    }
}
