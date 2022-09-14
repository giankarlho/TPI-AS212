package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    public static Connection cnx = null;

    public static Connection conectar()  {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BDFarmacia";
            String user = "sa";
            String pwd = "@abc123@";
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.err.println("Error en la conexión " + e.getMessage());
        }
        return cnx;        
    }
    
    public static void cerrarCnx() throws Exception{
        if (cnx != null) cnx.close();
    }
    
    public static void main(String[] args) {
        Conexion.conectar();
        if (cnx != null) {
            System.out.println("Hay conexión");
        } else{            
            System.out.println("No hay conexión");
        }
    }
    
}
