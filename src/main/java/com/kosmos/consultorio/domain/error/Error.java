package com.kosmos.consultorio.domain.error;

import org.springframework.http.HttpStatus;

public class Error {

    public Integer codigo;

    public String mensaje;

    public String detalles;

    public Error(HttpStatus status, String detalles) {
        this.codigo = status.value();
        this.mensaje = status.getReasonPhrase();
        this.detalles = detalles;
    }

    public Error() {
    }

    public Error(Integer codigo, String mensaje, String detalles) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
