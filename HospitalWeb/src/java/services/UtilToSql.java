package services;

public class UtilToSql {
    
    public static java.sql.Date convert(java.util.Date fecha){
        java.sql.Date sDate = new java.sql.Date(fecha.getTime());
        return sDate;
    }
}
