package gradle.cucumber;

public class Celda {
    public Contenido contenido;

    public Celda(Contenido contenido) {
        this.contenido = contenido;
    }

    public Boolean estaVacia() {
        return !this.contenido.esSolido();
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
