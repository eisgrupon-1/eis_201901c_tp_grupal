package gradle.cucumber;

public class Bomberman extends Contenido{

    //Por ahora a Bomberman le importa saber donde esta.
    public EstadoDelPersonaje estado;
    public Bomba bomba;

    public Bomberman(){
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
}