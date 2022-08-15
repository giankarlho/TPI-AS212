package controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import services.CajeroS;

@Named(value = "cajeroC")
@SessionScoped
public class CajeroC implements Serializable {

    private int tope = 0;
    private int monto = 0;
    private String mensaje = "";

    public void calcular() {
        mensaje = CajeroS.calcular(tope, monto);
    }

    public void limpiar() {
        tope = 0;
        monto = 0;
        mensaje = "";
    }
    // Getter y Setter

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
