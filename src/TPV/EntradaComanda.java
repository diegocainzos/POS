package TPV;


public class EntradaComanda {

    float cantidad;
    ProductoIndividual individual;
    ProductoMultiple multiple;
    
    public EntradaComanda(float cantidad, ProductoIndividual individual) {
        this.cantidad = cantidad;
        this.individual = individual;
    }
    public EntradaComanda(float cantidad, ProductoMultiple multiple) {
        this.cantidad = cantidad;
        this.multiple = multiple;
    }
    
   
}
