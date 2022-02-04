/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.notasalumno;

import java.util.Scanner;

/**
 *
 * @author DELL 6420
 */
public class UIUtilidades {
    public static void separador(){
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }
    public static void print(String text){
        System.out.println(text);
    }
    public static void encabezado(String text){
        separador();
        print(text);
        separador();
    }
    public static void menu(){
        String menu = "R\tRegistros | N\tNuevo | A\tActualizar | E\tEliminar | S\tSalir";
        separador();
        print(menu);
    }
    public static String capturarCampo(Scanner entradaTeclado, String leyenda, String valorPredeterminado){
        print(leyenda + "(" + valorPredeterminado + "): ");
        String input = entradaTeclado.nextLine();
        if(input.isEmpty()){
            return valorPredeterminado;
        }
        return input;
    }
    public static void printEncabezado(){
        separador();
        print(String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "ID", "NOMBRE", "ASIGNATURA", "NOTA1", "NOTA2", "NOTA3"));
        separador();
    }
}
