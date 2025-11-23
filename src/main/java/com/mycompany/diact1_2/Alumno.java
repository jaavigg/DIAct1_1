package com.mycompany.diact1_2;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;
    private String telefono;

    // Constructor sin argumentos
    public Alumno() {
    }

    // Constructor nombre apellidos y edad
    public Alumno(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // Constructor con todo
    public Alumno(String nombre, String apellidos, String email, int edad, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
        this.telefono = telefono;
    }

    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // Metodo mayoredad
    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }
}
