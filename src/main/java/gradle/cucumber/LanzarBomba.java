package gradle.cucumber;

public class LanzarBomba extends Poder{

    private int distanciaDefault = 2;

    @Override
    public void moverPersonaje(Juego juego, Posicion posicion) {
        juego.moverPersonaje(posicion);
    }

    @Override
    public Posicion posicionParaLaBomba(Posicion posicion, Direccion direccion){
        /*Por default se decide que Bomberman tira una bomba en la direccion opuesta a la que se mueve
         * (para evitar implementar hacia donde mira el personaje).
         * */
        Posicion posicionFinal = posicion;

        for(int i = 0; i < distanciaDefault; i++)
            posicionFinal = posicionFinal.getPosicionHacia(direccion);

        return posicionFinal;
    }
}