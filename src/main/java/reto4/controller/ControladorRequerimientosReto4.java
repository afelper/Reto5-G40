package reto4.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.dao.LideresMayorSalarioDao;
import reto4.model.dao.LideresProyectosEmblematicosDao;
import reto4.model.dao.MaterialRankeadoImportadoDao;
import reto4.model.vo.LideresMayorSalario;
import reto4.model.vo.LideresProyectosEmblematicos;
import reto4.model.vo.MaterialRankeadoImportado;

public class ControladorRequerimientosReto4 {
    
    //Alojar instancias de clases del modelo
    private final LideresMayorSalarioDao lideresMayorSalarioDao;
    private final LideresProyectosEmblematicosDao lideresProyectosEmblematicosDao;
    private final MaterialRankeadoImportadoDao materialRankeadoImportadoDao;
  
    //Constructor
    public ControladorRequerimientosReto4(){
        this.lideresMayorSalarioDao = new LideresMayorSalarioDao();
        this.lideresProyectosEmblematicosDao = new LideresProyectosEmblematicosDao();
        this.materialRankeadoImportadoDao = new MaterialRankeadoImportadoDao();
    }
    
    // Cada requerimiento solicitado -> Casos de Uso

    //Requerimiento 1 -> Listar Líderes con mayor Salario
    public ArrayList<LideresMayorSalario> requerimiento1() throws SQLException{
        return this.lideresMayorSalarioDao.consultarLideresMayorSalario();
    }

    //Requerimiento 2 -> Listar Lideres proyectos emblemáticos
    public ArrayList<LideresProyectosEmblematicos> requerimiento2() throws SQLException{
        return this.lideresProyectosEmblematicosDao.consultarLideresProyectosEmblematicos();
    }

    //Requerimiento 3 -> Listar Productos Importados
    public ArrayList<MaterialRankeadoImportado> requerimiento3() throws SQLException{
        return this.materialRankeadoImportadoDao.consultarMaterialRankeadoImportados();
    }
}