package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;
        
public class Conexion {
    
    public static Connection cnx = null;
    
    public static Connection conectar() throws Exception{
        try {
        InputStream inputStream = Conexion.class.getClassLoader().
                getResourceAsStream("properties/db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

//        String user="root";
//        String pwd="";
//        String driver="com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/bdfarmacia";        
        
             Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            
            System.out.println("Error de conexión: " + e.getMessage() + e.getStackTrace());
        }
        return cnx;
    }
    
    public static void main(String[] args) throws Exception {
        try {
            Conexion.conectar();
        if (cnx!=null) System.out.println("Conectado 😎");
        } catch (Exception e) {
            System.out.println("Error en " + e.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}
