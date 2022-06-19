package TPV;

public class Pagado {
    private static final Pagado instancia = new Pagado();
    private Pagado(){}
    public static Pagado getInstancia() {
        return instancia;
    }


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
}
