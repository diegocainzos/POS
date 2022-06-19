package TPV;

public abstract class Producto{
    float iva;
    String descrip;
    float existencias; //volumen peso o unidad
    float precio;
    String nombre;
    float PVP;



    //SETTERS GETTERS
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public float getExistencias() {
        return existencias;
    }
    public void setExistencias(float existencias) {
        this.existencias = existencias;
    }
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPVP() {
        return PVP;
    }

    public void setPVP(float pVP) {
        PVP = pVP;
    }

    
    
 
    

}


