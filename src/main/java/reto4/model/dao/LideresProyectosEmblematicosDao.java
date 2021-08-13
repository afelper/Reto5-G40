package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.LideresProyectosEmblematicos;
import reto4.util.JDBCUtilities;

public class LideresProyectosEmblematicosDao {
    
    //Consultar Lideres proyectos emblemáticos
    public ArrayList<LideresProyectosEmblematicos> consultarLideresProyectosEmblematicos() throws SQLException {
    
        ArrayList<LideresProyectosEmblematicos> respuesta = new ArrayList<LideresProyectosEmblematicos>();
        Connection conexion = null;
    
        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT l.ID_Lider, p.ID_Proyecto , t.ID_Tipo " +
                            "FROM Proyecto p " +
                            "join Lider l ,Tipo t " +
                            "on p.ID_Lider = l.ID_Lider AND p.ID_Tipo =t.ID_Tipo " +
                            "WHERE p.ID_Proyecto BETWEEN 130 AND 139 " +
                            "GROUP BY l.ID_Lider " +
                            "ORDER BY l.ID_Lider;";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resulset = statement.executeQuery();

            while(resulset.next()){

                LideresProyectosEmblematicos lider = new LideresProyectosEmblematicos();
                lider.setID_Lider(resulset.getInt("ID_Lider"));
                lider.setID_Proyecto(resulset.getInt("ID_Proyecto"));
                lider.setID_Tipo(resulset.getInt("ID_Tipo"));

                respuesta.add(lider);
            }

            resulset.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultado Líderes proyecto emblemáticos" + e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;

    }
}
