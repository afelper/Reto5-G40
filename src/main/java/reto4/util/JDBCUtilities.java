package reto4.util;

//Librerías para archivos
import java.io.File;
//Librerías para conexión a base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    
    //Ubicación de la base de datos que soporta este SW
    private static final String UBICACION_DB = "ProyectosConstruccion.db"; //Ruta absoluta

    //Método para proveer conexión
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_DB;
        return DriverManager.getConnection(url);
    }

    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_DB);
        return archivo.length() == 0;
    }
}