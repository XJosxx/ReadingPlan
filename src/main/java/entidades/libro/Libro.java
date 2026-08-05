package entidades.libro;

import java.time.LocalDate;

import entidades.detalles.*;
import interfaz.DetallesEstado;

public class Libro implements Comparable<Libro> {
    private int idLibro;
    private String titulo;
    private String autor;
    private int cantidadPaginas;
    private EstadoLibro estado;
    private DetallesEstado detalles;

    public Libro(String titulo, String autor, int paginas, EstadoLibro estado) throws Exception {
        asignarTitulo(titulo);
        asignarAutor(autor);
        asignarPaginas(paginas);
        asignarEstado(estado);
    }

    public void asignarTitulo(String t) {
        if (t == null || t.isBlank()) {
            throw new IllegalArgumentException("Titulo no puede ser null");
        }
        this.titulo = t;
    }

    public void asignarAutor(String a) {
        if (a == null || a.isBlank()) {
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
        if (est == null) {
            throw new IllegalArgumentException("Estado no puede ser nulo");
        }
        this.estado = est;
    }

    public void asignarIdLibro(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Id invalida.");
        }
        this.idLibro = i;
    }

    public void marcarComoLeido(DetallesLeido detalles) {
        if (this.estado != EstadoLibro.LEYENDO) {
            throw new IllegalStateException("Solo libros leyendo pueden marcarse como leidos");
        }
        DetallesLeyendo actuales = (DetallesLeyendo) this.detalles;
        if (!detalles.getFechaFinal().isAfter(actuales.getFechaInicio())) {
            throw new IllegalArgumentException("Fecha final debe ser posterior a fecha inicio");
        }

        this.estado = EstadoLibro.LEIDO;
        this.detalles = detalles;
    }

    public void marcarComoLeyendo(DetallesLeyendo detalles) {
        if (this.estado != EstadoLibro.PLANEADO) {
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

    public void eliminarEstado() {
        estado = null;
        detalles = null;
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

    public int getIdLibro() {
        return idLibro;
    }

    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareTo(otro.titulo);
    }

}
