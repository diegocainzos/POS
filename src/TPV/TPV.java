package TPV;

public class TPV {
    public static void main (String[] args){
       /*Comanda e = new Comanda();
       e.mesa = 4;
       ProductoIndividual agua = new ProductoIndividual((float) 0.10,"Agua mineral",126,(float) 0.20, "Aguita",0);
       ProductoIndividual pan = new ProductoIndividual((float)0.10,"Pan de Boiro sen gluten, feito por meigas",10,1,"Pan",(float)1.212);
       ProductoMultiple menu = new ProductoMultiple();

       agua.numRacion=1;
       pan.numRacion = 1;
        menu.existencias = 2;
        menu.setNombre("Menu");
       menu.aIndividuales.add(pan);
       menu.aIndividuales.add(agua);
        System.out.println("el precio  de "+menu.getNombre() + " es "+ menu.getPVP());
        e.anadirComanda(menu,2);
        System.out.println("cuanto pan quedqa ?? " +pan.getExistencias());
        e.anadirComanda(pan,2);

        System.out.println("cuanto pan quedqa ?? " +pan.getExistencias());
        ImprimirCuenta printer = new ImprimirCuenta();
        printer.comanda = e;        e.imprimirCuenta();
*/
        Ingrediente leite = new Ingrediente("Leite",1,100,0.1f);leite.descrip="Leite de cabra, pra o café";
        ProductoMultiple menu = new ProductoMultiple();
        ProductoIndividual cafe = new ProductoIndividual(0.1f,"Café hecho en el restaurante",25,1,"Café",0);cafe.numRacion=1;
        ProductoIndividual vino = new ProductoIndividual(0.10f,"Botella viño tinto",15,10,"Viño",0); vino.numRacion = 1;
        ProductoIndividual zamburinas = new ProductoIndividual(0.1f,"Tapa de zamburinas",102,8,"Zamburiñas",0);zamburinas.numRacion=1;
        menu.setNombre("Menu");menu.setDescrip("Menu de la casa,con todo el cariño de nuestro restaurante");menu.setIva(0.1f);
        ProductoMultiple cafeLeite = new ProductoMultiple();
        cafeLeite.setIva(0.1f);cafeLeite.setNombre("Cafe con leite");cafeLeite.aIngredientes.add(leite);cafeLeite.aIndividuales.add(cafe);
        menu.aIndividuales.add(vino);
        menu.aIndividuales.add(zamburinas);
        menu.aMultiples.add(cafeLeite);
        menu.descuento=0.8f;
        System.out.println("precio menu "+menu.getPVP());
        Comanda comanda = new Comanda();
        comanda.mesa = 5;
        comanda.anadirComanda(vino, 2);
        comanda.anadirComanda(menu,3);
        comanda.imprimirCuenta();







    }
}
