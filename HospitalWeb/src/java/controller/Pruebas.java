package controller;

import dao.Conexion;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "pruebas")
@Dependent
public class Pruebas implements Serializable{
    String mensaje;
    
    public void probarCnx() throws Exception{
        Conexion.conectar();
        if (Conexion.cnx != null){
            System.out.println("Esta conectado");
        } else{
            System.out.println("No hay conexión !!!! revisar...");
        }
    }
    
    
    
}
