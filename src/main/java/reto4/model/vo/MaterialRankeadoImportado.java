package reto4.model.vo;

public class MaterialRankeadoImportado {

    //Atributos -> Columnas de la tabla que representa la misma entidad
    private Integer ID_MaterialConstruccion;
    private String Nombre_Material;
    private Integer Precio_Unidad;
    
    //constructor
    public MaterialRankeadoImportado() {
    }

    public Integer getID_MaterialConstruccion() {
        return ID_MaterialConstruccion;
    }

    public void setID_MaterialConstruccion(Integer iD_MaterialConstruccion) {
        ID_MaterialConstruccion = iD_MaterialConstruccion;
    }

    public String getNombre_Material() {
        return Nombre_Material;
    }

    public void setNombre_Material(String nombre_Material) {
        Nombre_Material = nombre_Material;
    }

    public Integer getPrecio_Unidad() {
        return Precio_Unidad;
    }

    public void setPrecio_Unidad(Integer precio_Unidad) {
        Precio_Unidad = precio_Unidad;
    } 
}

