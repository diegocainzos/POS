package TPV;

import java.time.LocalDateTime;

public class Factura {
    float pagado;
    enum Metodo {TARJETA,DESCUENTO,INVITACION,CHEQUE};
    Metodo metodo;
    int idFactura;
    public static int auxId=0;
    Comanda comanda;
    float price=0;
    float total=0;
    float totalTaxes=0;
    public Factura(){
        this.idFactura = auxId++;
    }
    void imprimir(){
        System.out.println("Factura simplificada número "+idFactura);
        StringBuilder sv = new StringBuilder();
        System.out.println("Mesa número "+ comanda.mesa + "\n" + comanda.dtf.format(LocalDateTime.now()));
        System.out.println("Producto    Cantidad Precio PVP unidad  PVP total\n" + "=====================================================");
        for (EntradaComanda entradaComanda : comanda.lineaComanda) {
            if(entradaComanda.multiple != null){
                sv.append(entradaComanda.multiple.getNombre());
                sv.append(String.format("%15.2f",entradaComanda.cantidad));
                sv.append(String.format("%7.2f",entradaComanda.multiple.getPrecio()));
                sv.append(String.format("%11.2f",entradaComanda.multiple.getPVP()));
                sv.append(String.format("%11.2f\n",entradaComanda.cantidad*entradaComanda.multiple.getPVP()));
                price += entradaComanda.multiple.getPrecio();
                total += entradaComanda.multiple.getPVP();
            }
            else{
                sv.append(entradaComanda.individual.getNombre());
                sv.append(String.format("%16.2f",entradaComanda.cantidad));
                sv.append(String.format("%7.2f",entradaComanda.individual.getPrecio()));
                sv.append(String.format("%11.2f",entradaComanda.individual.getPVP()));
                sv.append(String.format("%11.2f\n",entradaComanda.cantidad*entradaComanda.individual.getPVP()));
                price += entradaComanda.individual.getPrecio();
                total += entradaComanda.individual.getPVP();

            }
        }
        System.out.println(sv);
        totalTaxes=total-price;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total sin impuestos  %6.2f\n", price));
        sb.append(String.format("Total de impuestos   %6.2f\n", totalTaxes));
        sb.append(String.format("Total                %6.2f\n\n", total));
        sb.append(String.format("# Forma de pago:\n"));
        switch (metodo){
            case INVITACION -> {
                sb.append(String.format("Cheque regalo\n"));
                sb.append(String.format("Descuento %.2f\n",total));
                sb.append(String.format("Total  %.2f\n",0));
                sb.append(String.format("Entregado %.2f",0));
                sb.append(String.format("Devolución %.2f",0));
            }
        }
        System.out.println(sb);



    }
}
