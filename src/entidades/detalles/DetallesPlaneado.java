package entidades.detalles;

import java.time.LocalDate;

import interfaz.DetallesEstado;

public class DetallesPlaneado implements DetallesEstado {
    private LocalDate fechaPlaneadaIniciar;
    private String prioridad;

    public void asignarFechaPlaneadainiciar(LocalDate f) {
        if (f == null) {
            throw new IllegalArgumentException("Fecha invalida o nula.");
        }

        this.fechaPlaneadaIniciar = f;
    }

    public void asignarPrioridad(String p) {
        if (p.isBlank()) {
            throw new IllegalArgumentException("Prioridad invalida o nula.");
        }
        this.prioridad = p;
    }

    public LocalDate getFechaPlaneadaIniciar() {
        return fechaPlaneadaIniciar;
    }

    public String getPrioridad() {
        return prioridad;
    }
}
