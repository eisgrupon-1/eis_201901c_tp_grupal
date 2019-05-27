package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Bomberman extends Contenido{

    private List<Poder> poderes;

    //Por ahora a Bomberman le importa saber donde esta.
    public EstadoDelPersonaje estado;

    public Bomberman(){
        this.poderes= new ArrayList<>();
        this.estado = new Vivo();
    }

    public boolean puedeMoverse(){ return !this.estaMuerto(); }

    public void morir(){ this.estado = new Muerto(); }
    public Boolean estaMuerto(){ return this.estado.estaMuerto(); }

    //Protocolo de Contenido
    @Override
    public Boolean esSolido() { return true; }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){ /*Se deja el metodo por compatibilidad por ahora pero no se deberia dar nunca este caso.*/}
    @Override
    public Contenido interactuarConBomba(){
        this.morir();
        return this;
    }
}