package gradle.cucumber;

public class Celda {
    public Contenido contenido;

    public Celda(Contenido contenido) {
        this.contenido = contenido;
    }

    public boolean estaVacia() {
        return this.contenido.esVacio();
    }

    public void interactuarCon(Bomberman bomberman){
        contenido.interactuarCon(bomberman, this);
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Contenido getContenido() {
        return this.contenido;
    }
}
