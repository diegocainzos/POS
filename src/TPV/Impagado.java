package TPV;

public class Pagado implements EstadoComanda {
    private static final Impagado instancia = new Impagado();
    private Impagado(){}
    public static Impagado getInstancia() {
        return instancia;
    }


    @Override
    public void pagar(Comanda c) {
        c.setEstado(Pagado.getInstancia());
    }

    @Override
    public void cancelar(Comanda c) {
        c.setEstado(Cancelado.getInstancia());

    }

    @Override
    public void marcharse(Comanda c) {
    //Ya está así
    }

    @Override
    public void anadirComanda(Comanda c, ProductoMultiple p, int cantidad) {

    }

    @Override
    public void anadirComanda(Comanda c, ProductoIndividual p, int cantidad) {

    }
}
