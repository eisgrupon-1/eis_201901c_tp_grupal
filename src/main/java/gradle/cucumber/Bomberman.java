public class Bomberman {

    public Celda celdaActual;
    public Status estado;

    public Bomberman(){
        this.estado = new Vivo();
    }

    public boolean puedeMoverseA(Celda cell) {
        return cell.estaVacia();
    }

    public void mover(Celda cell){
        this.celdaActual = cell;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public Boolean isDead(){
        return this.estado.isDead();
    }

    public boolean estaEnCeldaVacia() {
        return this.celdaActual.estaVacia();
    }

    public void setCelda(Celda cell) { this.celdaActual = cell; }

    public Celda getCelda() {
        return this.celdaActual;
    }
}
