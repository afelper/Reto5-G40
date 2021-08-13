package reto4.model.vo;

public class LideresProyectosEmblematicos {

    //Atributos -> Columnas de la tabla que representa la misma entidad
    private Integer ID_Lider;
    private Integer ID_Proyecto;
    private Integer ID_Tipo;


    public LideresProyectosEmblematicos(){  
    }


    public Integer getID_Lider() {
        return ID_Lider;
    }


    public void setID_Lider(Integer iD_Lider) {
        ID_Lider = iD_Lider;
    }


    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }


    public void setID_Proyecto(Integer iD_Proyecto) {
        ID_Proyecto = iD_Proyecto;
    }

    
    public Integer getID_Tipo() {
        return ID_Tipo;
    }


    public void setID_Tipo(Integer iD_Tipo) {
        ID_Tipo = iD_Tipo;
    }

}