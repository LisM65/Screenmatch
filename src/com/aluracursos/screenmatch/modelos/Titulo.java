package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.expeciones.ErrorConversionRunTime;
import com.google.gson.annotations.SerializedName;
import com.sun.jdi.IntegerValue;

public class Titulo implements Comparable<Titulo>{
    //@SerializedName("Title")
    public String nombre;
    //@SerializedName("Year")
    public int fechaLanzamiento;
    public int duracionMinutos;
    public boolean incluidoPlan;
    private double sumaEvaluaciones = 0;
    private int totalEvaluaciones = 0;

    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public void setIncluidoPlan(boolean incluidoPlan) {
        this.incluidoPlan = incluidoPlan;
    }

    public Titulo(TituloOMDb miTituloOMDb){
        this.nombre =miTituloOMDb.title();
        this.fechaLanzamiento = Integer.valueOf(miTituloOMDb.year());
        if (miTituloOMDb.runtime().contains("N/A")){
            throw new ErrorConversionRunTime("No existe valor de duración (N/A)");
        }
        this.duracionMinutos = Integer.valueOf(miTituloOMDb.runtime().substring(0, 3).replace(" ",""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public boolean isIncluidoPlan() {
        return incluidoPlan;
    }

    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + getNombre());
        System.out.println("Su fecha de lanzamiento es: " + getFechaLanzamiento());
        System.out.println("La duración en minutos es: " + getDuracionMinutos());
    }

    public void evalua(double nota){
        sumaEvaluaciones += nota;
        totalEvaluaciones ++;
    }

    public double calculaMedia(){
        return sumaEvaluaciones/totalEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", duracionMinutos=" + duracionMinutos+")";
    }
}
