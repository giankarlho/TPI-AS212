
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

    private String departamento="";
    PacienteImpl dao;
    private Paciente model;
    private Paciente selectPaciente;
    private List<Paciente> lstPaciente;
    
    public PacienteC() {
        dao = new PacienteImpl(); 
        model = new Paciente();
    }
    
    public void registrar(){
        try { 
            System.out.println("PacienteC/registrar model Fecha de Nacimiento: " + model.getNacimiento());
            model.setUbigeo(dao.obtenerCodigoUbigeo1(model.getUbigeo()));
//            model.setUbigeo(dao.obtenerCodigoUbigeo2(model.getUbigeo()));
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
    
    public List<String> completeTextUbigeo1 (String query) throws Exception{
        try {
            return dao.autoCompleteUbigeo1(query,departamento);
        } catch (Exception e) {
            System.out.println("Error en listar PacienteC/completeTextUbigeo1: " + e.getMessage());
            throw e;
        }
    
    }

    public List<String> completeTextUbigeo2 (String query) throws Exception{
        try {
            return dao.autoCompleteUbigeo2(query);
        } catch (Exception e) {
            throw e;
        }
 
    }
       
    
    
    
    
    
    
    
    
    
    
    // Getter y Setter
    public Paciente getModel() {
        return model;
    }

    public void setModel(Paciente model) {
        this.model = model;
    }

    public List<Paciente> getLstPaciente() {
        return lstPaciente;
    }

    public void setLstPaciente(List<Paciente> lstPaciente) {
        this.lstPaciente = lstPaciente;
    }

    public Paciente getSelectPaciente() {
        return selectPaciente;
    }

    public void setSelectPaciente(Paciente selectPaciente) {
        this.selectPaciente = selectPaciente;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }       
    
}
