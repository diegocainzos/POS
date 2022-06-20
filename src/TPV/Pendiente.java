package TPV;

public class Pendiente implements  EstadoComanda{
    private static final Pendiente instancia = new Pendiente();
    private Pendiente(){}
    public static Pendiente getInstancia() {
        return instancia;
    }

    @Override
    public void pagar(Comanda c) {
    c.setEstado(Pagado.getInstancia());
    Factura factura = new Factura();
    factura.comanda = c;

    }
    /*Podr´ıa darse el caso de que un cliente realice un pedido y lo cancele enseguida antes
    de ser servido. En este caso, la comanda pasa a estar cancelada y ya no se podr´a hacer
    nada con ella. Es necesario en este caso devolver al stock los productos que hab´ıan sido
    registrados en dicha comanda*/
    @Override
    public void cancelar(Comanda c) {
        c.setEstado(Cancelado.getInstancia());
        for (EntradaComanda entradaComanda : c.lineaComanda) {
            //si es un producto individual
            if (entradaComanda.individual !=null)
            entradaComanda.individual.anadirExis(entradaComanda.cantidad * entradaComanda.individual.numRacion);
            if (entradaComanda.multiple != null){
                for (Ingrediente t : entradaComanda.multiple.aIngredientes) {
                    t.anadirExis(entradaComanda.cantidad* t.numRacion);
                    }
                for (ProductoIndividual t : entradaComanda.multiple.aIndividuales) {
                    t.anadirExis(entradaComanda.cantidad* t.numRacion);
                }
            }


            }
        }



    @Override
    public void marcharse(Comanda c) {
        c.setEstado(Impagado.getInstancia());
    }
    public void anadirComanda(Comanda c, ProductoIndividual p, int cantidad){

        if(cantidad>p.existencias)
            System.out.println("No hay existencias de "+p.getNombre()+" comanda rechazada");

        else{
            p.existencias -=cantidad;
            EntradaComanda LineaAux = new EntradaComanda(cantidad, p);
            c.lineaComanda.add(LineaAux);
            //System.out.println("Comanda añadida "+p.getNombre());

        }

    }

    public  void anadirComanda(Comanda c, ProductoMultiple p, int cantidad) {
        boolean cont = true;
        //Se recorren los arrays para comprobar que existen las existencias necesarias para el pedido
        for (Ingrediente t : p.aIngredientes) {
            if ((cantidad * t.numRacion) > t.existencias) {
                System.out.println("No hay existencias de " + t.getNombre());
                cont = false;
            }
        }

        for (ProductoIndividual t : p.aIndividuales) {

            if ((cantidad * t.numRacion) > t.existencias) {
                System.out.println("No hay existencias de " + t.getNombre());
                cont = false;
            }
        }
        //Si se puede realizar el pedido, eliminamos las existencias necesarias del stock
        if (cont) {
            for (Ingrediente t : p.aIngredientes) {
                t.existencias -= (cantidad * t.numRacion);
            }

            for (ProductoIndividual t : p.aIndividuales) {
                t.existencias -= (cantidad * t.numRacion);
            }
            //Se añade la comanda a la linea del ticket
            EntradaComanda LineaAux = new EntradaComanda(cantidad, p);
            c.lineaComanda.add(LineaAux);
            //System.out.println("Comanda añadida");
        } else
            System.out.println("Comanda rechazada");


    }
    @Override
    public void solicitarCuenta(Comanda c) {
    }
}
