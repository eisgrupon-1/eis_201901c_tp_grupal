package gradle.cucumber;

import java.util.List;
import java.util.ArrayList;

public class Juego {

    private Tablero tablero;
    private Bomberman personaje;
    private Posicion posicionDelPersonaje;
    private List<Contenido> contenidosConTick;

    public Juego(){
        this.tablero = new Tablero(this.tamanioDefaultDeTablero());
        this.personaje = new Bomberman();
        this.posicionDelPersonaje = this.tablero.agregarContenidoA(this.personaje, this.posicionDefaultDelPersonaje());
        this.contenidosConTick = new ArrayList<>();
    }

    //Accessing
    public Bomberman getPersonaje(){ return this.personaje; }
    public Posicion getPosicionDelPersonaje(){ return this.posicionDelPersonaje; }
    public Tablero getTablero(){ return this.tablero; }

    //Acciones
    public void arrojarBombaYMoverPersonajeHacia(Direccion direccion){
        contenidosConTick.add(new Bomba(this.posicionDelPersonaje));
        this.moverPersonajeHacia(direccion);
    }

    public void moverPersonajeHacia(Direccion direccion){ this.moverPersonajeA(this.posicionDelPersonaje.getPosicionHacia(direccion)); }

    private void moverPersonajeA(Posicion posicionDestino){
        if(this.personaje.puedeMoverse())
            this.tablero.contenidoEn(posicionDestino).interactuarConPersonajeMoviendoseA(this, posicionDestino);
    }

    public void basicMoverPersonajeA(Posicion posicionDestino){
        this.tablero.agregarContenidoA(new ContenidoVacio(), this.posicionDelPersonaje);
        this.posicionDelPersonaje = this.tablero.agregarContenidoA(this.personaje, posicionDestino);
        this.tick();
    }

    private void tick(){
        for(Contenido contenido : this.contenidosConTick)
            contenido.tick(this);
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
