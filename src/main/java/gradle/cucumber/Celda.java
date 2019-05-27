package gradle.cucumber;

public class Celda {
    public Contenido contenido;

    public Celda(Contenido contenido) { this.contenido = contenido; }
    public Contenido getContenido() {
        return this.contenido;
    }
    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }
}
