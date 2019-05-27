package gradle.cucumber;

public class Tablero {

    private Celda[][] celdas ;

    public Tablero(int size){
        this.celdas = new Celda[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                this.celdas[i][j] = new Celda(new ContenidoVacio());
    }

    public Posicion agregarContenidoA(Contenido contenido, Posicion posicion){
        celdas[posicion.x()][posicion.y()].setContenido(contenido);
        return posicion;
    }

    public Contenido contenidoEn(Posicion posicion){
        return celdas[posicion.x()][posicion.y()].getContenido();
    }

}
