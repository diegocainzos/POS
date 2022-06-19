package TPV;

public class Impagado implements EstadoComanda{
    private static final Impagado instancia = new Impagado();
    private Impagado(){}
    public static Impagado getInstancia() {
        return instancia;
    }
    /*En el caso de que alg´un cliente se vaya sin pagar, la comanda pasar´a a fase de impagada.
    En esa fase solo se podr´an realizar dos operaciones en el caso de que el cliente vuelva m´as
    tarde para pagar: generar de nuevo la cuenta y pagar.
    */

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
        //Aqui está
    }

    @Override
    public void anadirComanda(Comanda c, ProductoMultiple p, int cantidad) {
    }

    @Override
    public void anadirComanda(Comanda c, ProductoIndividual p, int cantidad) {
    }
    @Override
    public void solicitarCuenta(Comanda c) {
    c.imprimirCuenta();
    }
}
