/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.poo_ventanas;

import gal.teis.libreriadam.Menu;
import gal.teis.libreriadam.ControlData;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lurde
 */
public class Principal {

    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se establecen las variables necesarias
        //Algunas de ellas será necesario inicializarlas antes de su uso
        VentanaA laVentanaA = null;
        VentanaB laVentanaB = null;
        boolean finalizar = false;
        boolean fin;
        int seleccion;
        String nombre = "";
        int compra;
        int cantidad = 0;
        char caracter = '\0';

        //Abrimos la aplicación con un mensaje de bienvenida
        System.out.println("Benvidos a nosa aplicación!, díganos qué desexa facer:");
        //Establecemos un bucle en el menú principal
        do {
            //Mostramos el menú (situado al final del documento) llamando al método y con el Switch captamos la opción seleccionada por el usuario
            switch (menuPrincipal()) {
                //Establecemos las diferentes opciones y las desarrollamos
                //Opción 1: PRE-ORDENAR
                case 1:
                    //Mostramos un mensaje informativo al usuario
                    System.out.println("(Informámoslle que non se poden ordear máis de 30 pezas por pedido, "
                            + "se necesitase máis unidades, realice varios pedidos ou fale directamente cun dos nosos empregados. :)");
                    //Establecemos otro bucle dentro del bucle principal
                    do {
                        //Le damos su propio boolean para evitar confusiones
                        fin = false;
                        //Mostramos uno de los submenús llamando al método y con el Switch le damos al usuario su selección
                        switch (menuCrearVentanas()) {
                            //Volvemos a desarrollar las diferentes opciones dadas al usuario
                            //Opción 1: PRE-ORDENAR ventanas MODELO A
                            case 1:
                                //Mostramos los mensajes oportunos por pantalla
                                //Llamamos a los métodos de la clase A
                                System.out.println("  Modelo A: ");
                                System.out.println(" -----------");
                                System.out.println("|-Ancho: " + VentanaA.getAnchoA() + " |");
                                System.out.println("|-Largo: " + VentanaA.getLargoA() + " |");
                                System.out.println(" -----------");
                                System.out.println("--------------------------------------------------");
                                System.out.println("|-Cores dispoñibles: |" + VentanaA.getColoresA());
                                System.out.println("--------------------------------------------------");
                                System.out.println("O precio deste modelo é de: " + VentanaA.getprecioA());
                                System.out.println(" ");
                                //Pedimos al usuario que selecciones color y cantidad 
                                //Damos la oportunidad de crear varias ventanas de una vez
                                //Controlamos la entrada por teclado llamando a ControlData
                                System.out.println("En qué cor estaría interesada/o? (Marque o número correspondente)");
                                seleccion = ControlData.lerInt(input);
                                System.out.println("Cántas desexa pre-ordenar/crear?");
                                cantidad = ControlData.lerInt(input);
                                //Con un if controlamos las posibilidades e informamos al usuario del resultado
                                if (VentanaA.crearVentanaA(cantidad, seleccion) == false) {
                                    System.out.println("Non se puido completar a petición.");
                                } else {
                                    laVentanaA = new VentanaA(seleccion, cantidad);
                                    System.out.println("Acaba de pre-ordenar " + cantidad + " xanela/s de color " + VentanaA.getColor(seleccion) + " e xa está/n dispoñible/s pra sua compra.");
                                }
                                break;
                            //Opción 2: PRE-ORDENAR ventanas MODELO B
                            case 2:
                                //Mostramos los mensajes oportunos por pantalla
                                //Llamamos a los métodos de la clase B
                                System.out.println("   Modelo B: ");
                                System.out.println(" -----------");
                                System.out.println("|-Ancho: " + VentanaB.getAnchoB() + " |");
                                System.out.println("|-Largo: " + VentanaB.getLargoB() + " |");
                                System.out.println(" -----------");
                                System.out.println("------------------------------------------------------");
                                System.out.println("|-Cores dispoñibles: |" + VentanaB.getColoresB());
                                System.out.println("------------------------------------------------------");
                                System.out.println("O precio deste modelo é de: " + VentanaB.getprecioB());
                                System.out.println("");
                                //Pedimos al usuario que selecciones color y cantidad 
                                //Damos la oportunidad de crear varias ventanas de una vez
                                //Controlamos la entrada por teclado llamando a ControlData
                                System.out.println("En qué cor estaría interesada/o? (Marque o número correspondente)");
                                seleccion = ControlData.lerInt(input);
                                System.out.println("Cántas desexa pre-ordenar/crear?");
                                cantidad = ControlData.lerInt(input);
                                //Con un if controlamos las posibilidades e informamos al usuario del resultado
                                if (VentanaB.crearVentanaB(cantidad, seleccion) == false) {
                                    System.out.println("Non se puido completar a petición.");
                                } else {
                                    laVentanaB = new VentanaB(seleccion, cantidad);
                                    System.out.println("Acaba de pre-ordenar " + cantidad + " xanela/s de cor " + VentanaB.getColor(seleccion) + " e xa está/n dispoñible/s pra sua compra.");
                                }
                                break;
                            //Opción 3: ver cuantas ventanas han sido creadas de cada modelo
                            case 3:
                                //Mostramos por pantalla el resultado llamando a los métodos oportunos
                                System.out.println("En total creáronse :" + VentanaA.getContadorA() + " xanelas modelo A, e "
                                        + VentanaB.getContadorB() + " xanelas modelo B.");
                                break;
                            //Opción 4: volvemos al menú principal
                            case 4:
                                System.out.println("***************************************************************");
                                //Damos otro valor al boolean para cerrar el bucle do/while
                                fin = true;

                        }
                        //Se cierra el bucle
                    } while (!fin);
                    break;
                //Opción 2 menú principal: Comprar ventanas creadas anteriormente
                case 2:
                    //Mostramos por pantalla las ventanas que hay en stock antes de que el usuario seleccione de qué modelo desea comprar
                    System.out.println("");
                    System.out.println("Actualmente, contamos co siguinte stock: ");
                    System.out.println("----------------------------------");
                    System.out.println("        STOCK -A-: " + "\n"
                            + VentanaA.totalVentanasA());
                    System.out.println("----------------------------------");
                    System.out.println("        STOCK -B-: " + "\n"
                            + VentanaB.totalVentanasB());
                    System.out.println("----------------------------------");
                    //Abrimos otro bucle do/while
                    do {
                        fin = false;
                        //Llamámos al método y con el switch recogemos la selección del usuario
                        switch (menuComprarVentanas()) {
                            //Opción 1: comprar ventanas del MODELO A
                            case 1:
                                //Pedimos al usuario que selecciones color y cantidad 
                                //Damos la oportunidad de comprar varias ventanas de una vez
                                //Controlamos la entrada por teclado llamando a ControlData
                                System.out.println("");
                                System.out.println("En qué cor estaría interesada/o? ");
                                System.out.println(VentanaA.getColoresA());
                                seleccion = ControlData.lerInt(input);
                                System.out.println("Cántas desexa comprar?");
                                compra = ControlData.lerInt(input);
                                //Con un if controlamos las posibilidades e informamos al usuario del resultado
                                //Mostramos los datos de la compra por pantalla y pedimos al usuario que verifique si son correctos y desea seguir con la compra
                                if (VentanaA.disponibilidadVentanas(compra, seleccion) == true) {
                                    System.out.println("Vai  realizar unha compra de " + compra + " xanela/s, cun  precio de " + VentanaA.PRECIO + " euros unidade.");
                                    System.out.println("En total serían " + VentanaA.facturaA(compra) + " euros.");
                                    System.out.println("Indique se desexa seguir coa compra pulsado (S), ou pulse calquera outra tecla pra volver ao menú");
                                    caracter = ControlData.lerChar(input);
                                    //Establecemos otro if/else para controlar las dos posibilidades: comprar o no comprar
                                    if (Character.toUpperCase(caracter) == 'S') {
                                        VentanaA.compraFinal(compra, seleccion);
                                        System.out.println("A compra foi completada satisfactoriamente.");
                                        System.out.println("Grazas por confiar nas nosas xanelas!");
                                        System.out.println("***********************************************");

                                    } else {
                                        System.out.println("***************************************");
                                        System.out.println(" Pode seguir comprando ou volver noutro momento. ");
                                        System.out.println("***************************************");
                                    }
                                    //Si los datos no fuesen correctos mostramos mensaje por pantalla
                                } else {
                                    System.out.println("***************************************");
                                    System.out.println(":( Parece que non hai o stock solicitado :( ");
                                    System.out.println("***************************************");
                                }
                                break;
                            //Opción 2: comprar ventanas del MODELO B
                            case 2:
                                //Pedimos al usuario que selecciones color y cantidad 
                                //Damos la oportunidad de comprar varias ventanas de una vez
                                //Controlamos la entrada por teclado llamando a ControlData
                                System.out.println("");
                                System.out.println("En qué cor estaría interesada/o? ");
                                System.out.println(VentanaB.getColoresB());
                                seleccion = ControlData.lerInt(input);
                                System.out.println("Cántas desexa comprar?");
                                compra = ControlData.lerInt(input);
                                //Con un if controlamos las posibilidades e informamos al usuario del resultado
                                //Mostramos los datos de la compra por pantalla y pedimos al usuario que verifique si son correctos y desea seguir con la compra
                                if (VentanaB.disponibilidadVentanasB(compra, seleccion) == true) {
                                    System.out.println("Vai realizar unha compra de " + compra + " xanela/s, cun precio de " + VentanaB.PRECIO + " euros unidade.");
                                    System.out.println("En total serían " + VentanaB.facturaB(compra) + " euros.");
                                    System.out.println("Indique se desexa seguir coa compra pulsado (S), ou pulse cualquera outra tecla pra volver ao menú");
                                    caracter = ControlData.lerChar(input);
                                    //Establecemos otro if/else para controlar las dos posibilidades: comprar o no comprar
                                    if (Character.toUpperCase(caracter) == 'S') {
                                        VentanaB.compraFinal(compra, seleccion);
                                        System.out.println("A compra foi completada satisfactoriamente.");
                                        System.out.println("Grazas por confiar nas nosass xanelas!");
                                        System.out.println("***********************************************");
                                    } else {
                                        System.out.println("***************************************");
                                        System.out.println(" Pode seguir comprando ou volver noutro momento. ");
                                        System.out.println("***************************************");
                                    }
                                    //Si los datos no fuesen correctos mostramos mensaje por pantalla
                                } else {
                                    System.out.println("***************************************");
                                    System.out.println(":( Parece que non hai o stock solicitado :( ");
                                    System.out.println("***************************************");
                                }
                                break;
                            //Opción 3: ver cuantas ventanas fueron vendidas y las ganancias 
                            case 3:
                                System.out.println("Ata o momento foron vendidas: ");
                                System.out.println("Do modelo A: " + VentanaA.ventaTotalA() + " cunhas ganancias totais de :" + VentanaA.gananciasA());
                                System.out.println("Do modelo B: " + VentanaB.ventaTotalB() + " cunhas ganancias totais de :" + VentanaB.gananciasB());
                                break;
                            //Opción 4: Volver al menú principal
                            case 4:
                                System.out.println("***************************************************************");
                                //Asignamos otro valor al boolean
                                fin = true;
                        }
                        //Ponemos fin al bucle do/while
                    } while (!fin);
                    break;
                //Opción 3 del menú principal: cerrar la aplicación
                case 3:
                    //Asignamos otro valor al boolean
                    finalizar = true;
                    //Mostramos un mensaje de despedida por pantalla
                    System.out.println("Esperamos que a experiencia fose do seu agrado!");
                    break;
            }
            //Cerramos bucle do/while
        } while (!finalizar);
        input.close();
    }

    /**
     * Dibuja un menú en la consola a partir con unas opciones determinadas
     */
    /*Creamos el menú principal del programa para controlar la navegación entre las opciones principales del programa*/
    static byte menuPrincipal() {
        /*se establecen las variables correspondientes*/
        byte opcion;
        boolean correcta;

        /*Establecemos un bucle*/
 /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/
        do {
            ArrayList<String> misOpciones = new ArrayList<String>();
            System.out.println("");
            /*Creamos las opciones a mostrar en el menú*/
            misOpciones.add("Gustaríame solicitar un modelo específico de xanela");
            misOpciones.add("Ver xanelas dispoñibles e proceder á compra");
            misOpciones.add("Saír da APP");

            /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
            Menu miMenu = new Menu(misOpciones);
            miMenu.printMenu();

            /*La clase ControlData permite hacer un control de tipo leído*/
            opcion = ControlData.lerByte(input);
            correcta = miMenu.rango(opcion);

            /*Salimos del bucle cuando así lo solicite el usuario*/
        } while (!correcta);

        return opcion;
    }

    /**
     * Dibuja un menú en la consola a partir con unas opciones determinadas
     */
    /*Creamos un submenú para controlar la creación de ventanas*/
    static byte menuCrearVentanas() {
        byte opcion;
        boolean correcta;
        System.out.println("\n*********************************************************************************************");
        System.out.println("Seleccione que modelo de xanela desexa crear:");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/

        ArrayList<String> misOpciones = new ArrayList<String>();
        System.out.println("");
        /*Creamos las opciones a mostrar en el menú*/
        misOpciones.add("Pre-Ordenar unha xanela do modelo A");
        misOpciones.add("Pre-Ordenar unha xanela do modelo B");
        misOpciones.add("Saber cántas xanelas foron pre-ordenadas en total");
        misOpciones.add("Volver ao menú principal");


        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);
        miMenu.printMenu();

        /*La clase ControlData permite hacer un control de tipo leído*/
        opcion = ControlData.lerByte(input);
        correcta = miMenu.rango(opcion);

        return opcion;
    }

    static byte menuComprarVentanas() {
        byte opcion;
        boolean correcta;
        System.out.println("");
        System.out.println("Seleccione qué desexa facer:");
        /* Solo sale del While cuando se selecciona una opción correcta en rango y tipo*/

        correcta = true;

        ArrayList<String> misOpciones = new ArrayList<String>();
        misOpciones.add("Realizar compra do modelo A");
        misOpciones.add("Realizar compra do modelo B");
        misOpciones.add("Saber cántas xanelas foron vendidas e as ganancias acumuladas");
        misOpciones.add("Volver ao menú principal");

        /*La clase Menu permite imprimir el menú a partir de los datos de un ArrayList<String>
            y utilizar métodos para control de rango*/
        Menu miMenu = new Menu(misOpciones);
        miMenu.printMenu();

        /*La clase ControlData permite hacer un control de tipo leído*/
        opcion = ControlData.lerByte(input);
        correcta = miMenu.rango(opcion);

        return opcion;
    }
}
