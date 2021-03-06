package gradle.cucumber;

import javafx.util.Pair;

public class Posicion {

    private Pair<Integer, Integer> posicion;

    public Posicion(int x, int y){
        posicion = new Pair<>(x, y);
    }

    public int x(){
        return posicion.getKey();
    }

    public int y(){
        return posicion.getValue();
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Posicion))return false;
        Posicion otherPosition = (Posicion)other;
        return this.x() == otherPosition.x() && this.y() == otherPosition.y();
    }

    public Posicion getPosicionHacia(Direccion direccion){
        Posicion modifier = this.valorParaDireccion(direccion);
        return new Posicion(this.x() + modifier.x(), this.y() + modifier.y());
    }

    private Posicion valorParaDireccion(Direccion direccion){
        int x = 0;
        int y = 0;
        switch(direccion) {
            case NORTE:
                y = 1;
                break;
            case SUR:
                y = -1;
                break;
            case ESTE:
                x = 1;
                break;
            case OESTE:
                x = -1;
                break;
        }
        return new Posicion(x, y);
    }
}
