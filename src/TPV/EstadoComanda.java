package TPV;

public interface EstadoComanda {
    void pagar(Comanda c);
    void cancelar(Comanda c);
    //Se va sin pagar
    void marcharse(Comanda c);
    void anadirComanda(Comanda c, ProductoMultiple p, int cantidad);
    void anadirComanda(Comanda c, ProductoIndividual p, int cantidad);

}
