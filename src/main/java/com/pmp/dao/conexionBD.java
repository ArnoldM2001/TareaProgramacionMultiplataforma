/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author DELL 6420
 */
public class conexionBD {
    private static Connection _conexion = null;
    
    private conexionBD(){//Constructor
        
    }
    public static Connection _getConexion(){
        try{
            if(_conexion == null){
                Class.forName("org.sqlite.JDBC");
                _conexion = DriverManager.getConnection("jdbc:sqlite:NotasDelAlumno.db");
            }
            return _conexion;
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
}
