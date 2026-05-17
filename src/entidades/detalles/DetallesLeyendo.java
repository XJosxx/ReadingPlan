package entidades.detalles;

import interfaz.DetallesEstado;

public class DetallesLeyendo implements DetallesEstado {
    private int paginasLeidas;

    public void asignarPaginasLeidas(int p) {
        if (p < 1) {
            throw new IllegalArgumentException("valor de paginas leida invalido");
        }
        this.paginasLeidas = p;

    }

    public int getPaginasLeidas() {
        return paginasLeidas;
    }
}
