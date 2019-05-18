package gradle.cucumber;

public class ProtoMaxJr extends Contenido{

    public EstadoDelPersonaje estado;

    public ProtoMaxJr(){
        this.estado = new Vivo();
    }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino) {

    }

    @Override
    public Contenido interactuarConBomba() {
        this.morir();
        return new SaltarOlanzarBombas();
    }


    @Override
    public Boolean esSolido() {
        return false;
    }

    public Boolean estaMuerto(){ return this.estado.estaMuerto(); }

    public void morir(){ this.estado = new Muerto(); }
}

