package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.expeciones.ErrorConversionRunTime;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOMDb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class PrincipalBusqueda {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("escriba el nombre de la pelicula");
            var busqueda = lectura.nextLine();
            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }
            String busquedaCod = URLEncoder.encode(busqueda, StandardCharsets.UTF_8).replace("%20", "+");

            String url = "https://www.omdbapi.com/?t=" + busquedaCod + "&apikey=af4a25b4";
            System.out.println(url);

            // CLIENTE -> CONSULTA -> RESPUESTA
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            String json;

            try {
                // Enviar solicitud y obtener respuesta
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Imprimir el cuerpo de la respuesta
                System.out.println("Respuesta de la API:");
                json = response.body();
                System.out.println(json);

                TituloOMDb miTitutloOMDb = gson.fromJson(json, TituloOMDb.class);
                System.out.println(miTitutloOMDb);
                Titulo miTitulo = new Titulo(miTitutloOMDb);
                System.out.println(miTitulo);

                /*//GRABAR TEXTO en .TXT
                FileWriter escritura = new FileWriter("pelicula.txt");
                //SOBREESCRIBIR ABRIR ESCRITURA
                escritura.write(miTitulo.toString());
                //CERRAR ESCRITURA
                escritura.close();*/

                titulos.add(miTitulo);
            } catch (IOException | InterruptedException e) {
                // Manejar excepciones
                System.err.println("Ocurrió un error al realizar la solicitud: " + e.getMessage());
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URL");
            } catch (ErrorConversionRunTime e){
                System.out.println("Error excepcional: " + e.getMessage());
            }
        }

        System.out.println(titulos);
        try (FileWriter escritura = new FileWriter("titulos.json")){
            escritura.write(gson.toJson(titulos));
            System.out.println("Archivo agregado");
        } catch (IOException e) {
            System.out.println("Ocurrio un error" + e.getMessage());
            e.printStackTrace();
        }

        /*//GUARDAR LOS TITULOS EN UN ARCHIVO
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.close();*/

        System.out.println("Finalizo la ejecucion del programa");

    }
}
