package entidades.detalles;

import java.time.LocalDate;

import interfaz.DetallesEstado;

public class DetallesLeido implements DetallesEstado {
    private LocalDate fechaFinal;
    private int calificacion;

    public void asignarFechaFinal(LocalDate f) {
        if (f == null) {
            throw new IllegalArgumentException("Fecha invalida o nula.");
        }
        this.fechaFinal = f;
    }

    public void asignarCalificacion(int c) {
        if (c > 10 || c < 0) {
            throw new IllegalArgumentException("La calificacion solo es valida del 0 al 10.");
        }

        this.calificacion = c;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public int getCalificacion() {
        return calificacion;
    }
}
