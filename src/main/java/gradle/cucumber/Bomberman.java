package gradle.cucumber;

public class Bomberman extends Contenido{

    public Celda celdaActual;
    public Status estado;

    public Bomberman(){
        this.estado = new Vivo();
    }

    public boolean esVacio() { return false; }

    public boolean puedeMoverseA(Celda cell) {
        return cell.estaVacia();
    }

    public void mover(Celda celda){ this.estado.moverACelda(this, celda); }

    public void basicMover(Celda celda){
        this.celdaActual.setContenido(new ContenidoVacio());
        this.setCelda(celda);
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public void morir(){
        this.estado = new Muerto();
    }

    public Boolean estaMuerto(){
        return this.estado.estaMuerto();
    }

    public boolean estaEnCeldaVacia() {
        return this.celdaActual.estaVacia();
    }

    public Celda getCelda() {
        return this.celdaActual;
    }

    public void setCelda(Celda celda) {
       celda.setContenido(this);
       this.celdaActual = celda;
    }

    @Override
    public void interactuarCon(Bomberman bomberman,Celda celda){ /*Se deja el metodo por compatibilidad por ahora pero no se deberia dar nunca este caso.*/}
}
