package TPV;

public class Cancelado implements EstadoComanda{
    private static final Cancelado instancia = new Cancelado();
    private Cancelado(){}
    public static Cancelado getInstancia() {
        return instancia;
    }
    //No se puede realizar más acciones si está cancelada
    @Override
    public void pagar(Comanda c) {
    }
    @Override
    public void cancelar(Comanda c) {
    }
    @Override
    public void marcharse(Comanda c) {
    }
    @Override
    public void anadirComanda(Comanda c, ProductoMultiple p, int cantidad) {
    }
    @Override
    public void anadirComanda(Comanda c, ProductoIndividual p, int cantidad) {
    }
    @Override
    public void solicitarCuenta(Comanda c) {

    }

}
