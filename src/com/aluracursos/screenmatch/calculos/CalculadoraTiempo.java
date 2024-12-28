package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraTiempo {
    private int tiempoTotal;

    public void incluye(Titulo t1) {
        this.tiempoTotal += t1.getDuracionMinutos();
    }

    public int getTiempoTotal() {
        return this.tiempoTotal;
    }
}
