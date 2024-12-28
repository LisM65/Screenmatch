package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.principal.PrincipalConListas;


import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionMinutos(40);
        miPelicula.setIncluidoPlan(true);
        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(10);
        miPelicula.evalua(20);
        miPelicula.getNombre();
        System.out.println(miPelicula.getTotalEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del Dragon",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporadas(10);
        casaDragon.muestraFichaTecnica();

        System.out.println("++++++++++++++");
        System.out.println(casaDragon.getDuracionMinutos());

        Pelicula otraPelicula = new Pelicula("Matriz", 1998);
        otraPelicula.setDuracionMinutos(180);

        CalculadoraTiempo calculadora = new CalculadoraTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Tareyn");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(300);

        filtroRecomendacion.filtra(episodio);
        //
        var pelicula2 = new Pelicula("Señor de los anillos", 2021);
        pelicula2.setDuracionMinutos(180);
        pelicula2.setFechaLanzamiento(2001);

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(miPelicula);
        listaPeliculas.add(otraPelicula);
        listaPeliculas.add(pelicula2);

        System.out.println("Tptal de peliculas: "+listaPeliculas.size());
        System.out.println("La primera pelicula es: "+listaPeliculas.get(0).getNombre());
        /*for (int i = 0; i < listaPeliculas.size(); i++) {
            System.out.println("+"+listaPeliculas.get(i).getNombre());
            System.out.println("*"+listaPeliculas.get(i).getFechaLanzamiento());
            System.out.println("-"+listaPeliculas.get(i).getDuracionMinutos());
        }*/

        System.out.println(listaPeliculas.get(0).toString());
        var Palicula3 = new Pelicula("PELICULA 1", 2025);
    }
}
