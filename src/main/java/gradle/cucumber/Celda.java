package gradle.cucumber;

public class Celda {
    public Contenido content;

    public Celda(Contenido content) {
        this.content = content;
    }

    public boolean estaVacia() {
        return this.content.estaVacio();
    }

    public void setContent(Contenido included) {
        this.content = included;
    }

    public Contenido getContent() {
        return this.content;
    }
}
