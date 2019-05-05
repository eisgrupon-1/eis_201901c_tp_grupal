package gradle.cucumber;

public class Bomberman extends Contenido{

    //Por ahora a Bomberman le importa saber donde esta.
    public Celda celdaActual;
    public Status estado;

    public Bomberman(){
        this.estado = new Vivo();
    }

    public Boolean esSolido() { return true; }

    public void mover(Celda celda){ this.estado.moverACelda(this, celda); }

    public void basicMover(Celda celda){
        this.celdaActual.setContenido(new ContenidoVacio());
        celda.setContenido(this);
        this.celdaActual = celda;
    }

    public void morir(){
        this.estado = new Muerto();
    }

    public Boolean estaMuerto(){
        return this.estado.estaMuerto();
    }

    public Celda getCelda() {
        return this.celdaActual;
    }

    @Override
    public void interactuarCon(Bomberman bomberman,Celda celda){ /*Se deja el metodo por compatibilidad por ahora pero no se deberia dar nunca este caso.*/}
}
