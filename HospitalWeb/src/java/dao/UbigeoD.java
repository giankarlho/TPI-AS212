package dao;

import java.util.ArrayList;
import java.util.List;

public class UbigeoD {

    public UbigeoD() {
        
    }

   public List<String> listaDpto() throws Exception{
       List<String> lista = new ArrayList<>();
       lista.add("AMAZONAS");
       lista.add("AYACUCHO");
       lista.add("ICA");
       lista.add("JUNIN");
       lista.add("LIMA");
       return lista;               
   }
}
