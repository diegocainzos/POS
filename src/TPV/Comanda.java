package TPV;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Comanda {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    int mesa;
    ArrayList<EntradaComanda> lineaComanda = new ArrayList<>();
    EstadoComanda estado;

    public EstadoComanda getEstado(){
        return estado;
    }
    public void setEstado(EstadoComanda estado){
        this.estado = estado;
    }
    void anadirComanda(ProductoMultiple p, float cantidad) {
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
                lineaComanda.add(LineaAux);
                //System.out.println("Comanda añadida");
            } else
                System.out.println("Comanda rechazada");


    }
    void anadirComanda(ProductoIndividual p, float cantidad){

        if(cantidad>p.existencias)
            System.out.println("No hay existencias de "+p.getNombre()+" comanda rechazada");
            
        else{
            p.existencias -=cantidad;
            EntradaComanda LineaAux = new EntradaComanda(cantidad, p);
            lineaComanda.add(LineaAux);
            //System.out.println("Comanda añadida "+p.getNombre());
            
        }
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





