package ar.edu.unlu.poo.labo2.artefactos;

import java.util.Objects;

public class Artefacto {
    private String nombre;
    private double nivelDePoder;
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNivelDePoder() {
        return nivelDePoder;
    }

    public void setPoder(double poder) {
        if (poder <= 100){
            this.nivelDePoder = poder;
        }else{
            this.nivelDePoder = 100;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Artefacto(String nombre, double poder, String tipo){
        setNombre(nombre);
        setPoder(poder);
        setTipo(tipo);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Artefacto artefacto = (Artefacto) o;
        return Objects.equals(getNombre(), artefacto.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNombre());
    }
}
