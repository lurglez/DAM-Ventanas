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
public class VentanaA {

    //Establecemos las variables
    private String nombre;

    //propiedades static y final de la clase
    public static final int ANCHO = 40;
    public static final int LARGO = 50;
    public static final int PRECIO = 150;

    private static int vendidas;
    private static int creadas;
    public static int ventanaRoja;
    public static int ventanaVerde;
    public static int ventanaGris;
    public static int ventanaNegro;
    public static int vendidaRoja;
    public static int vendidaVerde;
    public static int vendidaNegro;
    public static int vendidaGris;
    private static int color;
    //VENTANA A
    //Inicialización de un array de Strings
    public static final String[] COLORES = {"ROXO", "VERDE", "NEGRO", "GRIS"};

    //Constructor con color
    public VentanaA(int color, int cantidad) {
        this.color = color - 1;
        //contador creadas modelo A
        creadas += cantidad;
    }

    //Constructor sin valor    
    public VentanaA() {
    }

    //MÉTODOS
    //Devolver ancho
    public static int getAnchoA() {
        return ANCHO;
    }

    //Devolver largo
    public static int getLargoA() {
        return LARGO;
    }

    //Devolver precio
    public static int getprecioA() {
        return PRECIO;
    }

    //Devolver un string con los colores disponibles
    public static String getColoresA() {
        String colores = "Modelo A:";
        for (int i = 0; i < COLORES.length; i++) {
            colores += "\n" + (i + 1) + " ---> " + COLORES[i];
        }
        return colores;
    }

    //Devolver el color seleccionado por el usuario
    public static String getColor(int seleccion) {
        return COLORES[color];
    }

    //Controla la creación de ventanas
    //Establece un máximo por color y movimiento
    //Ingresa los datos en un array
    public static boolean crearVentanaA(int cantidad, int seleccion) {
        boolean opcion = true;
        //Array con ventanas disponibles
        int[] totalventanasA = {ventanaRoja, ventanaVerde, ventanaNegro, ventanaGris};
        //Si la opción es mayor a 30 se devuelve false
        if (cantidad > 30) {
            opcion = false;
        } else {

            //Switch que controla la elección del usuario
            switch (seleccion) {
                case 1:
                    ventanaRoja += cantidad;
                    break;
                case 2:
                    ventanaVerde += cantidad;
                    break;
                case 3:
                    ventanaNegro += cantidad;
                    break;
                case 4:
                    ventanaGris += cantidad;
                    break;
                default:
                    opcion = false;
            }
        }
        return opcion;
    }

    //Devuelve el precio total de la compra
    public static double facturaA(int compra) {
        double factura = compra * PRECIO;

        return factura;
    }

    //Devuelve las ventanas disponibles por colores
    public static String totalVentanasA() {
        int[] totalventanasA = {ventanaRoja, ventanaVerde, ventanaNegro, ventanaGris};
        String disponibles = "";
        for (int i = 0; i < totalventanasA.length; i++) {
            disponibles += totalventanasA[i] + "      ";
        }

        return "  " + Arrays.toString(COLORES) + "\n"
                + "    " + disponibles + "";
    }

    //COMPRA DE VENTANAS
    //Comprueba que la selección de ventanas está disponible
    public static boolean disponibilidadVentanas(int compra, int seleccion) {
        boolean opcion = true;
        int[] totalventanasA = {ventanaRoja, ventanaVerde, ventanaNegro, ventanaGris};

        switch (seleccion) {
            case 1:
                if (ventanaRoja >= compra) {
                } else {
                    opcion = false;
                }
                break;
            case 2:
                if (ventanaVerde >= compra) {
                } else {
                    opcion = false;
                }
                break;
            case 3:
                if (ventanaNegro >= compra) {
                } else {
                    opcion = false;
                }
                break;
            case 4:
                if (ventanaGris >= compra) {
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
        int cantidad = 0;
        int[] totalventanasA = {ventanaRoja, ventanaVerde, ventanaNegro, ventanaGris};
        int[] ventanasVendidasA = {vendidaRoja, vendidaVerde, vendidaNegro, vendidaGris};

        switch (seleccion) {
            case 1:
                vendidaRoja += compra;
                vendidas += compra;
                ventanaRoja -= compra;
                break;
            case 2:
                vendidaVerde += compra;
                vendidas += compra;
                ventanaVerde -= compra;
                break;
            case 3:
                vendidaNegro += compra;
                vendidas += compra;
                ventanaNegro -= compra;
                break;
            case 4:
                vendidaGris += compra;
                vendidas += compra;
                ventanaGris -= compra;
                break;
            default:
                opcion = false;
        }
        return opcion;
    }

    //Devuelve las ganancias acumuladas
    public static double gananciasA() {
        double ganancias;
        ganancias = vendidas * PRECIO;

        return ganancias;
    }

    //Devuelve las ventanas vendidas por colores
    public static String ventaTotalA() {
        int[] ventanasVendidasA = {vendidaRoja, vendidaVerde, vendidaNegro, vendidaGris};
        return Arrays.toString(COLORES) + Arrays.toString(ventanasVendidasA);
    }

    //Contador ventanas creadas en total en el modelo A
    public static int getContadorA() {
        return creadas;
    }
}
