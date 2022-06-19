package TPV;

import java.util.ArrayList;


public class ProductoMultiple extends Producto {
    ArrayList<Ingrediente> aIngredientes = new ArrayList<>();
    ArrayList<ProductoIndividual> aIndividuales = new ArrayList<>();
    ArrayList<ProductoMultiple> aMultiples = new ArrayList<>();

    //Método calcular precio
    enum modo {FIJO, DESCUENTO}
    modo Modo = modo.DESCUENTO;
    //Descuento usado para calcular PVP
    float descuento = 1;
    //Precio fijo para calcular PVP
    float pFijo;

    public float getPrecio() {
        float aux = 0;

        switch (Modo) {
            case DESCUENTO -> {
                for (ProductoIndividual a : aIndividuales)
                    aux +=  a.getPrecio();
                for (Ingrediente a : aIngredientes)
                    aux += a.getPrecio();
                for (ProductoMultiple a : aMultiples)
                    aux += a.getPrecio();
                PVP = aux * descuento;
            }
            case FIJO -> PVP = pFijo;


        }
        return PVP;
    }



    public float getPVP() {
        float aux = 0;

        switch (Modo) {
            case DESCUENTO -> {
                for (ProductoIndividual a : aIndividuales)
                    aux += (a.getPrecio() * a.getIva() + a.getPrecio());
                for (Ingrediente a : aIngredientes)
                    aux += (a.getPrecio() * a.getIva() + a.getPrecio());
                for (ProductoMultiple a : aMultiples)

                    aux += (a.getPrecio() * a.getIva() + a.getPrecio());
                PVP = aux * descuento;
            }
            case FIJO -> PVP = pFijo * getIva()+pFijo;


        }
        return PVP;
    }
}



