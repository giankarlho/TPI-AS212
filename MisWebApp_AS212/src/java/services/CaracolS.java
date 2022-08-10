package services;

public class CaracolS {
    
    public static String calcular(int altura, int sube, int resbala){
        String rpta = "";
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
}
