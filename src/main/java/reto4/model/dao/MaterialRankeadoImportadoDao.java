package reto4.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.vo.MaterialRankeadoImportado;
import reto4.util.JDBCUtilities;

public class MaterialRankeadoImportadoDao {
    
    //Consultar Productos importados
    public ArrayList<MaterialRankeadoImportado> consultarMaterialRankeadoImportados() throws SQLException {

        ArrayList<MaterialRankeadoImportado> respuesta = new ArrayList<MaterialRankeadoImportado>();
        Connection conexion = null;

        try {
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT ID_MaterialConstruccion, Nombre_Material, Precio_Unidad "+
                            "FROM MaterialConstruccion "+
                            "WHERE Importado = 'Si' "+
                            "AND Precio_Unidad >= 1000 "+
                            "ORDER BY ID_MaterialConstruccion ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                MaterialRankeadoImportado material = new MaterialRankeadoImportado();
                material.setID_MaterialConstruccion(resultSet.getInt("ID_MaterialConstruccion"));
                material.setNombre_Material(resultSet.getString("Nombre_Material"));
                material.setPrecio_Unidad(resultSet.getInt("Precio_Unidad"));

                respuesta.add(material);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultado Productos importados");
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }
}