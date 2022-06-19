package TPV;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Comanda {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    int mesa;
    ArrayList<EntradaComanda> lineaComanda = new ArrayList<>();
    EstadoComanda estado = Pendiente.getInstancia();

    public EstadoComanda getEstado(){
        return estado;
    }
    public void setEstado(EstadoComanda estado){
        this.estado = estado;
    }
    void anadirComanda(ProductoMultiple p, int cantidad) {
           estado.anadirComanda(this, p, cantidad);
    }
    void anadirComanda(ProductoIndividual p, int cantidad){
        estado.anadirComanda(this, p, cantidad);
    }
    void solicitarCuenta(){
        imprimirCuenta();
        estado = Pendiente.getInstancia();

    }
    void imprimirCuenta(){
        //Variables locales
        float price=0;
        float total=0;
        float totalTaxes;
        StringBuilder sb = new StringBuilder();
        StringBuilder sv = new StringBuilder();
        //La cabecera se imprime
        System.out.println("Mesa número "+ mesa + "\n" + dtf.format(LocalDateTime.now()));
        System.out.println("Producto    Cantidad Precio PVP unidad  PVP total\n" + "=====================================================");
        //Se recorre la comanda y se imprime
        for (EntradaComanda entradaComanda : lineaComanda) {
            if(entradaComanda.multiple != null){

                sv.append(entradaComanda.multiple.getNombre());
                sv.append(String.format("%15.2f",entradaComanda.cantidad));
                sv.append(String.format("%7.2f",entradaComanda.multiple.getPrecio()));
                sv.append(String.format("%11.2f",entradaComanda.multiple.getPVP()));
                sv.append(String.format("%11.2f\n",entradaComanda.cantidad*entradaComanda.multiple.getPVP()));
                price += entradaComanda.multiple.getPrecio() * entradaComanda.cantidad;
                total += entradaComanda.multiple.getPVP()* entradaComanda.cantidad;
            }
            else{

                sv.append(entradaComanda.individual.getNombre());
                sv.append(String.format("%15.2f", entradaComanda.cantidad));
                sv.append(String.format("%7.2f", entradaComanda.individual.getPrecio()));
                sv.append(String.format("%11.2f", entradaComanda.individual.getPVP()));
                sv.append(String.format("%11.2f\n", entradaComanda.cantidad * entradaComanda.individual.getPVP()));
                price += entradaComanda.individual.getPrecio() *  entradaComanda.cantidad;
                total += entradaComanda.individual.getPVP() * entradaComanda.cantidad;

            }
        }
        totalTaxes=total-price;
        System.out.println(sv);
        System.out.println("# Pendiente de cobro");
        sb.append(String.format("Total sin impuestos  %6.2f\n", price));
        sb.append(String.format("Total de impuestos   %6.2f\n", totalTaxes));
        sb.append(String.format("Total                %6.2f\n\n", total));
        System.out.println(sb);
    }



}





