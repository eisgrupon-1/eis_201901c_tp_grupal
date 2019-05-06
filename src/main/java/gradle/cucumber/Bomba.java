package gradle.cucumber;

public class Bomba extends Contenido{

    public int ticks;
    public final int RANGO = 3;
    public Posicion posicion;

    public Bomba(Posicion posicion){
        this.ticks = 5;
        this.posicion = posicion;
    }

    public int getRango(){ return RANGO; }

    @Override
    public Boolean esSolido() {
        return true;
    }
    @Override
    public void interactuarConPersonajeMoviendoseA(Juego juego, Posicion destino){ /* Al igual que una pared no le permito al personaje moverse */ }
    @Override
    public void tick(Juego juego){
        ticks--;
        if(ticks == 0){
            juego.explotarBomba(posicion);
        }
    }
}
