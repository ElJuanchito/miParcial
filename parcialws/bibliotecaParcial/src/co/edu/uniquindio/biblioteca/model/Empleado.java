package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Empleado {
    private String nombre;
    private double salario;
    private String cargo;
    private ArrayList<Prestamo> listaPrestamos;
    private int aniosExperiencia;


    public Empleado(String nombre, double salario, String cargo) {
        super();
        this.nombre = nombre;
        this.salario = salario;
        this.cargo = cargo;
        this.listaPrestamos = new ArrayList<Prestamo>();
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", salario=" + salario + ", cargo=" + cargo + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Verifica nombre si el nombre tiene al menos tres vocales
     * @return
     */
    public boolean verificarNombreVocales() {
        char [] vocales = {'a', 'e', 'i', 'o', 'u'};
        int cont = 0;
        for (char caracter: nombre.toCharArray()) {
            for (char caracterV: vocales) {
                if (caracter == caracterV) cont ++;
            }
        } if (cont >= 3) return true;
        return false;
    }
}
