package com.aluracursos.screenmatch.expeciones;

public class ErrorConversionRunTime extends RuntimeException {
    private String mensaje;

    public ErrorConversionRunTime(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage(){
        return this.mensaje;
    }
}
