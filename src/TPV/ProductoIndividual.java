package TPV;

public class ProductoIndividual extends Producto {
    int numRacion;//número de raciones por menus, es decir si un menu tiene dos hamburguesas iguales, seria dos

    void anadirExis(float exist) {
        existencias += exist;
    }

    void restarExis(float exist) {
        existencias -= exist;
    }

    public ProductoIndividual(float iva, String descrip, float existencias, float precio, String nombre, float PVP) {
        this.iva = iva;
        this.descrip = descrip;
        this.existencias = existencias;
        this.precio = precio;
        this.nombre = nombre;
        this.PVP = PVP;

    }
    public float getPVP(){
        float temp =( getPrecio()) + (getPrecio()*getIva());
        setPVP(temp);
        return temp;
    }
}
