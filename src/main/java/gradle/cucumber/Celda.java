package gradle.cucumber;

public class Celda {
    public Contenido contenido;
    private int coordenadaX;
    private int coordenadaY;

    public Celda(int coordenadaX, int coordenadaY, Contenido contenido) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.contenido = contenido;
    }

    public int getCoordenadaX(){
        return this.coordenadaX;
    }

    public int getCoordenadaY(){
        return this.coordenadaY;
    }

    public int distanciaEntreDosCeldas(Celda celda){

        double distancia = Math.sqrt((celda.coordenadaX - this.getCoordenadaX())*(celda.coordenadaX - this.getCoordenadaX()) + (celda.coordenadaY - this.getCoordenadaY())*(celda.coordenadaY - this.getCoordenadaY()));

        return (int)distancia;
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
