package interfaz;

public interface DetallesEstado {
    default String obtenerTipo() {
        return null;
    } // retorna "LEYENDO", "LEIDO", "PLANEADO"

    default String obtenerResumen() {
        return null;
    } // texto corto para mostrar el tabla
}
