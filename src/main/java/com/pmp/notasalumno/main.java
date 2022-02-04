package com.pmp.notasalumno;

import java.util.Scanner;
import java.util.ArrayList;
 
import com.pmp.dao.alumno;
import com.pmp.dao.alumnosModel;

/**
 *
 * @author DELL 6420
 */
public class main {
    private static Scanner entradaTeclado = new Scanner(System.in);
    private static alumnosModel model = new alumnosModel();
    
    public static void main(String[] args){
        UIUtilidades.encabezado("--Registro de Notas de Alumnos--");
        String menuOption = "Z";
        while(!menuOption.equals("S")){
            switch(menuOption){
                case "R":
                    mostrarListado();
                    break;
                case "N":
                    nuevoAlumno();
                    break;
                case "A":
                    actualizarAlumno();
                    break;
                case "E":
                    eliminarAlumno();
                    break;
                default:
                    UIUtilidades.print("Opción no encontrada!");
            }
            UIUtilidades.menu();
            menuOption = entradaTeclado.nextLine().toUpperCase();
        }        
    }
    private static void mostrarListado(){
        UIUtilidades.printEncabezado();
        ArrayList<alumno> alumnosOriginal = model.obtenerAlumnos();
        for(int i=0; i< alumnosOriginal.size(); i++){
            UIUtilidades.print(alumnosOriginal.get(i).getRow());
            UIUtilidades.separador();
        }
    }    
    
    private static void nuevoAlumno(){
        alumno nuevoAlumno = new alumno();
        UIUtilidades.encabezado("Nuevo Alumno");
        nuevoAlumno.setNombre(UIUtilidades.capturarCampo(entradaTeclado, "Nuevo Nombre", "Juan Mejía"));
        nuevoAlumno.setAsignatura(UIUtilidades.capturarCampo(entradaTeclado, "Nueva Asignatura", "Español"));
        nuevoAlumno.setNota1(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nueva Nota1", "95.5")));
        nuevoAlumno.setNota2(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nueva Nota2", "89.6")));
        nuevoAlumno.setNota3(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nueva Nota3", "100")));
        UIUtilidades.separador();
        int insertado = model.agregarAlumno(nuevoAlumno);
        if(insertado>0){
            UIUtilidades.print("Alumno agregado correctamente!");                    
        }
         UIUtilidades.separador();
    }
    private static void actualizarAlumno(){
        int actualizado = 0;
        int encontrado = 0;
        
        alumno alumnoActualizado = new alumno();
        ArrayList <alumno> alumnoReal = model.obtenerAlumnos();
        UIUtilidades.encabezado("Actualizar alumno");
        
        UIUtilidades.encabezado("Id del alumno a actualizar: ");
        int capturarId = Integer.parseInt(entradaTeclado.nextLine());
        
        for(int i=0; i<alumnoReal.size(); i++){
            if(capturarId == alumnoReal.get(i).getId()){
                alumnoActualizado.setNombre(UIUtilidades.capturarCampo(entradaTeclado, "Nombre",alumnoReal.get(i).getNombre()));
                alumnoActualizado.setAsignatura(UIUtilidades.capturarCampo(entradaTeclado, "Asignatura", alumnoReal.get(i).getAsignatura()));
                alumnoActualizado.setNota1(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nota1", Float.toString(alumnoReal.get(i).getNota1()))));
                alumnoActualizado.setNota2(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nota2", Float.toString(alumnoReal.get(i).getNota2()))));
                alumnoActualizado.setNota3(Float.parseFloat(UIUtilidades.capturarCampo(entradaTeclado, "Nota3", Float.toString(alumnoReal.get(i).getNota3()))));
                alumnoActualizado.setId(alumnoReal.get(i).getId());
                UIUtilidades.separador();
                
                actualizado = model.actualizarAlumno(alumnoActualizado);
                encontrado=1;
            }
        }        
        if(actualizado>0){
            UIUtilidades.print("Alumno Actualizado Satisfactoriamente");
        }else if(encontrado>0){
            UIUtilidades.print("Alumno No Encontrado");
        }
        UIUtilidades.separador();
        mostrarListado();
    }
    
    private static void eliminarAlumno(){
        String resultado = "Alumno Eliminado Satisfactoriamente";
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Ingrese el Id del alumno a eliminar: ");
        int id = lector.nextInt();
        
        System.out.println("¿Está seguro de eliminar este alumno?(1. Si - 2. No): ");
        int decision = lector.nextInt();
        
        if(decision == 1){
            int registroafectados = model.eliminarAlumno(id);
            UIUtilidades.print(resultado);
            if(registroafectados<0){
                resultado = "Error al eliminar producto";
                UIUtilidades.print(resultado);
            }
        }
        UIUtilidades.separador();
        mostrarListado();
    }
}
