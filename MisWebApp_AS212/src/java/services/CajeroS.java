package services;

public class CajeroS {
    
    public static String calcular(int tope, int monto){
        String mensaje = "";
        int[] tipoBilletes = {200,100,50,20,10};
        int billete = 0;
        for (int x:tipoBilletes){
            if (monto < x){
                continue; // continua con el siguiente billete
            }
            billete = monto / x;
            monto = monto % x;
            mensaje = mensaje + billete + " de " + x + " soles \n";
        }
        return mensaje;
    }      
    
}
