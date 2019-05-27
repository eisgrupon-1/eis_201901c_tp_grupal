package gradle.cucumber;

import java.util.List;
import java.util.ArrayList;

public class Juego {

    private Tablero tablero;
    private Bomberman personaje;
    private Posicion posicionDelPersonaje;
    private List<Bomba> contenidosConTick;
    private Poder poder;

    public Juego(){
        this.poder = new PoderDefault();
        this.tablero = new Tablero(this.tamanioDefaultDeTablero());
        this.personaje = new Bomberman();
        this.posicionDelPersonaje = this.tablero.agregarContenidoA(this.personaje, this.posicionDefaultDelPersonaje());
        this.contenidosConTick = new ArrayList<>();
    }

    //Accessing
    public Bomberman getPersonaje(){ return this.personaje; }
    public Posicion getPosicionDelPersonaje(){ return this.posicionDelPersonaje; }
    public Tablero getTablero(){ return this.tablero; }
    public Boolean bombermanTienePoder(){ return !poder.esPoderDefault(); }

    //Acciones
    public Bomba arrojarBomba(){
        Bomba bomba = new Bomba(this.posicionDelPersonaje);
        contenidosConTick.add(bomba);
        return bomba;
    }

    public Bomba arrojarBomba(Direccion direccion){
        Bomba bomba = new Bomba(poder.posicionParaLaBomba(this.posicionDelPersonaje, direccion));
        contenidosConTick.add(bomba);
        return bomba;
    }

    public void moverPersonajeHacia(Direccion direccion){ this.moverPersonajeA(this.posicionDelPersonaje.getPosicionHacia(direccion)); }

    public void moverPersonaje(Posicion posicionDestino){
        if(this.personaje.puedeMoverse())
            this.tablero.contenidoEn(posicionDestino).interactuarConPersonajeMoviendoseA(this, posicionDestino);
    }

    public void basicMoverPersonajeA(Posicion posicionDestino){
        this.tablero.agregarContenidoA(new ContenidoVacio(), this.posicionDelPersonaje);
        this.posicionDelPersonaje = this.tablero.agregarContenidoA(this.personaje, posicionDestino);
        this.tick();
    }

    public void moverPersonajeA(Posicion posicionDestino){
        this.poder.moverPersonaje(this, posicionDestino);
    }

    private void tick(){
        for(Bomba contenido : this.contenidosConTick)
            contenido.tick(this);
    }

    public void setPoderDeBomberman(Poder poder){
        this.poder = poder;
    }

    public void explotarBomba(Bomba bomba){
        Posicion posicionOrigen = bomba.getPosicion();

        for(int i = 0; i <= bomba.RANGO; i++)
            for(int j = 0; j <= bomba.RANGO; j++) {
                if ((i + posicionOrigen.x()) >= 0
                        & (j + posicionOrigen.y()) >= 0
                        & (j + i) <= bomba.RANGO) {
                    Posicion posicion = new Posicion(i + posicionOrigen.x(), j + posicionOrigen.y());
                    tablero.agregarContenidoA(tablero.contenidoEn(posicion).interactuarConBomba(), posicion);
                }
                if ((-i + posicionOrigen.x()) >= 0
                        & (-j + posicionOrigen.y()) >= 0
                        & (j + i) <= bomba.RANGO) {
                    Posicion posicion = new Posicion(-i + posicionOrigen.x(), -j + posicionOrigen.y());
                    tablero.agregarContenidoA(tablero.contenidoEn(posicion).interactuarConBomba(), posicion);
                }
            }
        this.tablero.agregarContenidoA(new ContenidoVacio(), posicionOrigen);
    }

    //Defaults
    private int tamanioDefaultDeTablero(){ return 10; }
    private Posicion posicionDefaultDelPersonaje(){ return new Posicion(0, 0); }
}
