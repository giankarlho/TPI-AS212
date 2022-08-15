package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "calculadora")
@SessionScoped
public class Calculadora implements Serializable {


    public Calculadora() {
    }
    
}
