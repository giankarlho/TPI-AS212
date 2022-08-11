package services;

public class CaracolS {
    
    public static String calcular(int altura, int sube, int resbala){
        String rpta = validar(altura,sube,resbala);
        if (rpta.length() != 0) return rpta;
        int avance =0, dias=0;
        while(avance < altura){
            avance += sube; // avance = avance + sube
            dias ++;
            if (avance >= altura) break;
            avance -= resbala; // avance = avance - resbala            
        }
        rpta = "Llegará en " + dias + " dias a salir del pozo";
        return rpta;
    }
    
    public static String validar(int altura, int sube, int resbala){
        String mensaje="";
        if (resbala >= sube){
            mensaje = "Ing. un nro. menor que la subida";
        }else if (sube >= altura){
            mensaje = "La altura debe ser mayor a la subida";
        }else if (altura < 1){
            mensaje = "la altura no puede ser negativa";
        }
        return mensaje;
    }
}
