
package controller;

import dao.PacienteImpl;
import model.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "pacienteC")
@SessionScoped
public class PacienteC implements Serializable{

    PacienteImpl dao;
    Paciente model;
    List<Paciente> lstPaciente;
    
    public PacienteC() {
        dao = new PacienteImpl();        
    }
    
    public void registrar(){
        try {
            dao.registrar(model);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Registrado", "Agregado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en PacienteC / registrar " + e.getMessage());
        }
        
    }
    
    public void modificar(){
        try {
          dao.modificar(model);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Actualizado", "Modificado con éxito"));  
        } catch (Exception e) {
            
        }
    }
    
    public void eliminar(){
        try {            
            dao.eliminar(model.getCodigo());
            listar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Eliminado", "Eliminado con éxito"));
        } catch (Exception e) {
            
        }
    }
    
    public void cambiarEstado(){
        try {            
//            dao.cambiarEstado('I');
            listar();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cambiar Estado", "Cambiar con éxito"));
        } catch (Exception e) {
            
        }
    }
    
    public void listar(){
        try {
            lstPaciente = dao.listarTodos('T');
        } catch (Exception e) {
            
        }
    }
    
}
