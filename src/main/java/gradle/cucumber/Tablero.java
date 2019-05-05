package gradle.cucumber;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private List<Celda> celdas;

    public Tablero(){

        this.celdas = new ArrayList<Celda>();

    }

    public void agregarCelda(Celda celda){

        this.celdas.add(celda);

    }

}
