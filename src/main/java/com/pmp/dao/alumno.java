/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.dao;

/**
 *
 * @author DELL 6420
 */
public class alumno {

    public int getId() {
        return _id;
    }
    public void setId(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getAsignatura() {
        return _asignatura;
    }
    public void setAsignatura(String _asignatura) {
        this._asignatura = _asignatura;
    }

    public float getNota1() {
        return _nota1;
    }
    public void setNota1(float _nota1) {
        this._nota1 = _nota1;
    }

    public float getNota2() {
        return _nota2;
    }
    public void setNota2(float _nota2) {
        this._nota2 = _nota2;
    }

    public float getNota3() {
        return _nota3;
    }
    public void setNota3(float _nota3) {
        this._nota3 = _nota3;
    }
    
    public String getRow(){
        return String.format("%d\t%s\t%s\t%f\t%f\t%f\n", _id, _nombre, _asignatura, _nota1, _nota2, _nota3);
    }
    
    private int _id;//campo necesario para realizar acciones específicas, campo aparte de los 5 pedidos en las instrucciones
    private String _nombre;
    private String _asignatura;
    private float _nota1;
    private float _nota2;
    private float _nota3;
}
