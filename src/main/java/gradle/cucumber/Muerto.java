package gradle.cucumber;

public class Muerto extends Status {

    @Override
    public Boolean estaMuerto() {
        return true;
    }

    @Override
    public void moverACelda(Bomberman bomberman, Celda celda){ /*No hacemos nada porque Bomberman esta muerto.*/}
}
