/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.appestudiante.model;

public class Estudiante {
    private int Id;
    private String codigo;
    private String correo;
    private String nombre;
    private String direccion;
    private String movil;

    public Estudiante() {
    }

    public Estudiante(int Id, String codigo, String correo, String nombre, String direccion, String movil) {
        this.Id = Id;
        this.codigo = codigo;
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.movil = movil;
    }
    public Estudiante(int Id ) {
        this.Id = Id;
     
    }
    
     public Estudiante(String codigo, String correo, String nombre, String direccion, String movil) {
        
        this.codigo = codigo;
        this.correo = correo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.movil = movil;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    

  

    @Override
    public String toString() {
        return "Estudiante{" + "Id=" + Id + ", codigo=" + codigo + ", correo=" + correo + ", nombre=" + nombre + ", direccion=" + direccion + ", movil=" + movil + '}';
    }

   
    
}
