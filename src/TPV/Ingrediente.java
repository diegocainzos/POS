package TPV;

public class Ingrediente extends Producto{
    int numRacion;

    public Ingrediente(String nombre, float precio, float existencias,float iva ) {
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.iva = iva;
    }
    void anadirExis( float exist){
        existencias += exist;
    }
    void restarExis(float exist){
        existencias -= exist;
    }

    public float getPVP(){
        float temp =( getPrecio()) + (getPrecio()*getIva());
        setPVP(temp);
        return temp;
    }
    

}
