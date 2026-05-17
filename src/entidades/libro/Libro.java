package entidades.libro;

import java.time.LocalDate;

import entidades.detalles.*;
import interfaz.DetallesEstado;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private EstadoLibro estado;
    private LocalDate fechaInicio;
    private DetallesEstado detalles;

    public Libro(String titulo, String autor, int paginas, EstadoLibro estado) throws Exception {
        asignarTitulo(titulo);
        asignarAutor(autor);
        asignarPaginas(paginas);
        asignarEstado(estado);
    }

    public void asignarTitulo(String t) {
        if (t.isBlank() || t == null) {
            throw new IllegalArgumentException("Titulo no puede ser null");
        }
        this.titulo = t;
    }

    public void asignarAutor(String a) {
        if (a.isBlank() || a == null) {
            throw new IllegalArgumentException("Autor no puede ser null");
        }
        this.autor = a;
    }

    public void asignarPaginas(int p) {
        if (p < 1) {
            throw new IllegalArgumentException("La cantidad de paginas no puede ser menos a 1");
        }
        this.cantidadPaginas = p;
    }

    public void asignarEstado(EstadoLibro est) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado no puede ser nulo");
        }
        this.estado = est;
    }

    public void asignarFechaInicio(LocalDate fechaInicio) {
        if (fechaInicio == null) {
            throw new IllegalArgumentException("Fecha invalida o nula.");
        }
    }

    public void marcarComoLeido(DetallesLeido detalles) {
        if (this.estado != EstadoLibro.LEYENDO) {
            throw new IllegalStateException("Solo libros leyendo pueden marcarse como leidos");
        }
        if (!detalles.getFechaFinal().isAfter(this.fechaInicio)) {
            throw new IllegalArgumentException("Fecha final debe ser posterior a fecha inicio");
        }

        this.estado = EstadoLibro.LEIDO;
        this.detalles = detalles;
    }

    public void marcarComoLeyendo(DetallesLeyendo detalles) {
        if (this.estado != EstadoLibro.LEIDO) {
            throw new IllegalStateException("Solo libros planeados pueden marcarse como leyendo");
        }
        this.estado = EstadoLibro.LEYENDO;
        this.detalles = detalles;
    }

    public void marcarComoPlaneado(DetallesPlaneado detalles) {
        if (this.estado == EstadoLibro.LEYENDO || this.estado == EstadoLibro.LEIDO) {
            throw new IllegalStateException("Un libro no puede pasar de leido o leyendo a planeando");
        }

        this.estado = EstadoLibro.PLANEADO;
        this.detalles = detalles;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public EstadoLibro getEstadoLibro() {
        return estado;
    }

    public DetallesEstado getDetallesEstado() {
        return detalles;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareTo(otro.titulo);
    }

}
