package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.LideresMayorSalario;
import reto4.util.JDBCUtilities;

public class LideresMayorSalarioDao {

    //Consulta líderes con mayor salario/devuelve un ArrayList
    public ArrayList<LideresMayorSalario> consultarLideresMayorSalario() throws SQLException {

        //Contenedor de la respuesta -> Colección salarios
        ArrayList<LideresMayorSalario> respuesta = new ArrayList<LideresMayorSalario>();
        Connection conexion = null;

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT ID_Lider," + 
                            "Nombre," +
                            "Primer_Apellido " +
                            "FROM Lider " + 
                            "WHERE Salario >= 447000 AND Ciudad_Residencia = 'Ibague' " +
                            "ORDER BY ID_Lider";
        
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resulset = statement.executeQuery();

            //Moviendo apuntador por cada registro, cuando no hay más, retorna falso y se sale
            while(resulset.next()){
                //Cargar el registro actual en un Value Object
                LideresMayorSalario lider = new LideresMayorSalario();
                lider.setID_Lider(resulset.getInt("ID_Lider"));
                lider.setNombre(resulset.getString("Nombre"));
                lider.setPrimer_Apellido(resulset.getString("Primer_Apellido"));

                respuesta.add(lider);
            }

            resulset.close();
            statement.close();
        }catch(SQLException e){
            System.err.println("Error consultando líderes con mayor salario" + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }
    
    
}
