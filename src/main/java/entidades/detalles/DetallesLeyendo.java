package entidades.detalles;

import interfaz.DetallesEstado;

import java.time.LocalDate;

public class DetallesLeyendo implements DetallesEstado {
    private LocalDate fechaInicio;
    private int paginasLeidas;

    public void asignarFechaInicio(LocalDate f) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("Fecha invalida o nula.");
        }
        this.fechaInicio = f;
    }

    public void asignarPaginasLeidas(int p) {
        if (p < 1) {
            throw new IllegalArgumentException("valor de paginas leida invalido");
        }
        this.paginasLeidas = p;

    }

    public int getPaginasLeidas() {
        return paginasLeidas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
}
