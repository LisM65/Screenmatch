package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Serie casaDragon = new Serie("La casa del Dragon",2022);
        //casaDragon.evalua(8);
        Pelicula otraPelicula = new Pelicula("Matriz", 1998);
        otraPelicula.evalua(6);
        var pelicula2 = new Pelicula("Señor de los anillos", 2021);
        pelicula2.evalua(7);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(pelicula2);
        lista.add(casaDragon);
        for (Titulo items: lista) {
            System.out.println(items);
            if (items instanceof Pelicula pelicula && pelicula.getClasificacion() > 4) {
                System.out.println(pelicula.getClasificacion());
            }
        }
        //ARRAYS
        ArrayList<String> ListaArtistas = new ArrayList<>();
        ListaArtistas.add("Kevin Kaar");
        ListaArtistas.add("Melendi");
        ListaArtistas.add("Ed Maverick");
        ListaArtistas.add("Abel Pintos");
        System.out.println("Lista de artistas no ordenado: " + ListaArtistas);

        Collections.sort(ListaArtistas);
        System.out.println("Lista de artistas ordenado: " + ListaArtistas);

        Collections.sort(lista);
        System.out.println(lista);
        System.out.println("********************************************");
        lista.sort(Comparator.comparing(Titulo::getFechaLanzamiento));
        System.out.println(lista);
    }
}
