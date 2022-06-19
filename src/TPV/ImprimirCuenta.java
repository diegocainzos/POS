package TPV;

import java.time.LocalDateTime;

public class ImprimirCuenta {
    Comanda comanda;
   /* void imprimir(){
        float price=0;
        float total=0;
        float totalTaxes;
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
        System.out.println(sb);


    }*/
}
