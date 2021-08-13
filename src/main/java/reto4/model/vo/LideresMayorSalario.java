package reto4.model.vo;

public class LideresMayorSalario {

    //Atributos -> Columnas de la tabla que representa la misma entidad
    private Integer ID_Lider;
    private String Nombre;
    private String Primer_Apellido;
    
    public LideresMayorSalario() {
    }

    public Integer getID_Lider() {
        return ID_Lider;
    }

    public void setID_Lider(Integer iD_Lider) {
        ID_Lider = iD_Lider;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }
    
}
