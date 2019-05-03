package gradle.cucumber;

import gradle.cucumber.Status;

public class Vivo extends Status {
    @Override
    public Boolean estaMuerto() {
        return false;
    }
}
