package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import services.CaracolS;

@Named(value = "caracolC")
@SessionScoped
public class CaracolC implements Serializable {

    private int altura;
    private int sube;
    private int resbala;
    private String mensaje = "";
    
    public CaracolC() {
    }
    
    public void calcular(){        
        mensaje = CaracolS.calcular(altura, sube, resbala);
    }
    
    public void limpiar(){
        altura = 10;
        sube = 1;
        resbala = 0;
        mensaje = " ";
    }
    
    // Getter y Setter

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getSube() {
        return sube;
    }

    public void setSube(int sube) {
        this.sube = sube;
    }

    public int getResbala() {
        return resbala;
    }

    public void setResbala(int resbala) {
        this.resbala = resbala;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    
            
            
}
