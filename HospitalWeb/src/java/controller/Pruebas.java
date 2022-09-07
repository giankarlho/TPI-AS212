package controller;

import dao.Conexion;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "pruebas")
@Dependent
public class Pruebas implements Serializable{
    
    private String mensaje;
    
    public void probarCnx() throws Exception{
        mensaje = "Sal mensaje de ahkí";
        Conexion.conectar();
        if (Conexion.cnx != null){
            mensaje = "Esta conectado";
        } else{
            mensaje = "No hay conexión !!!! revisar...";
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
