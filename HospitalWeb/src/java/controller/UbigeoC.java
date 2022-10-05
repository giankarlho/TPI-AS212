package controller;

import dao.UbigeoD;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Ubigeo;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "ubigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    Ubigeo ubigeo;
    UbigeoD dao;
    private List<String> listadoDptos;

    public UbigeoC() {
        ubigeo = new Ubigeo();
        dao = new UbigeoD();
    }

    public UbigeoC(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    @PostConstruct
    public void inicio() {
        try {
            listarDptos();
        } catch (Exception e) {
            
        }
    }

    public void listarDptos() throws Exception {
        try {
            listadoDptos = dao.listaDpto();
        } catch (Exception e) {
        }
    }

    // Getter y Setter
    public List<String> getListadoDptos() {
        return listadoDptos;
    }

    public void setListadoDptos(List<String> listadoDptos) {
        this.listadoDptos = listadoDptos;
    }

}
