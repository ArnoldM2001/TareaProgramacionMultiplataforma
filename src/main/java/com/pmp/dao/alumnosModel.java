/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Set;

import java.util.ArrayList;

/**
 *
 * @author DELL 6420
 */
public class alumnosModel {
    private Connection _conexion = null;
    
    public alumnosModel(){
        _conexion = conexionBD._getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS alumnos"
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + " nombre TEXT NOT NULL,"
                + " asignatura TEXT NOT NULL," 
                + " nota1 DECIMAL(10,2),"
                + " nota2 DECIMAL(10,2),"
                + " nota3 DECIMAL(10,2))";
        try{
            Statement comando = _conexion.createStatement();
            int resultado = comando.executeUpdate(sqlCreateTable);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public ArrayList <alumno> obtenerAlumnos(){
        try{
            ArrayList alumnos = new ArrayList<alumno>();
            Statement comandoSQL = _conexion.createStatement();
            ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM alumnos;");
            while(registroEnTabla.next()){
                alumno alumnoActual = new alumno();
                alumnoActual.setId(registroEnTabla.getInt("id"));
                alumnoActual.setNombre(registroEnTabla.getString("nombre"));
                alumnoActual.setAsignatura(registroEnTabla.getString("asignatura"));
                alumnoActual.setNota1(registroEnTabla.getFloat("nota1"));
                alumnoActual.setNota2(registroEnTabla.getFloat("nota2"));
                alumnoActual.setNota3(registroEnTabla.getFloat("nota3"));

                alumnos.add(alumnoActual);
            }
            return alumnos;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<alumno>();
        }        
    }
    
    public alumno obtenerAlumnos(int id){
        try{           
            PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM alumnos where id=?;");
            comandoSQL.setInt(1, id);
            ResultSet registroEnTabla = comandoSQL.executeQuery();
            alumno alumnoActual= new alumno();
            while(registroEnTabla.next()){
                alumnoActual.setId(registroEnTabla.getInt("id"));
                alumnoActual.setNombre(registroEnTabla.getString("nombre"));
                alumnoActual.setAsignatura(registroEnTabla.getString("asignatura"));
                alumnoActual.setNota1(registroEnTabla.getFloat("nota1"));
                alumnoActual.setNota2(registroEnTabla.getFloat("nota2"));
                alumnoActual.setNota3(registroEnTabla.getFloat("nota3"));

                break;
            }
            return alumnoActual;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }        
    }
    
    public int agregarAlumno(alumno nuevoAlumno){
        try{
            String insertSql = "INSERT INTO alumnos (nombre, asignatura, nota1, nota2, nota3) values (?, ?, ?, ?, ?);";
            PreparedStatement comandoSQL = _conexion.prepareStatement(insertSql);
            comandoSQL.setString(1, nuevoAlumno.getNombre());
            comandoSQL.setString(2, nuevoAlumno.getAsignatura());
            comandoSQL.setFloat(3, nuevoAlumno.getNota1());
            comandoSQL.setFloat(4, nuevoAlumno.getNota2());
            comandoSQL.setFloat(5, nuevoAlumno.getNota3());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }        
    }
    public int actualizarAlumno(alumno updateAlumno){
        try{
            String updateSql = "UPDATE alumnos SET nombre=?, asignatura=?, nota1=?, nota2=?, nota3=? where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(updateSql);
            comandoSQL.setString(1, updateAlumno.getNombre());
            comandoSQL.setString(2, updateAlumno.getAsignatura());
            comandoSQL.setFloat(3, updateAlumno.getNota1());
            comandoSQL.setFloat(4, updateAlumno.getNota2());
            comandoSQL.setFloat(5, updateAlumno.getNota3());
            comandoSQL.setInt(6, updateAlumno.getId());
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }        
    }
    public int eliminarAlumno(int id){
        try{
            String deleteSql = "DELETE FROM alumnos where id=?;";
            PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
            comandoSQL.setInt(1, id);
            
            int registrosAfectados = comandoSQL.executeUpdate();
            comandoSQL.close();
            return registrosAfectados;
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return 0;
        }        
    }
}
