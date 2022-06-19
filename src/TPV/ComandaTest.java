package TPV;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ComandaTest {
   @Test
    void Cuenta(){
       //Leite: Precio: 1$, Existencias:100, Iva:10%(Igual pra todos)
       //Cafe: Precio: 1$, Existencias: 25
       //Zamburiñas: Precio:8$, Existencias:102
       //Viño: Precio: 10$, Existencias: 15

      //Los añadimos
       Ingrediente leite = new Ingrediente("Leite",1,100,0.1f);leite.descrip="Leite de cabra, pra o café";
       ProductoMultiple menu = new ProductoMultiple();
       ProductoIndividual cafe = new ProductoIndividual(0.1f,"Café hecho en el restaurante",25,1,"Café",0);cafe.numRacion=1;
       ProductoIndividual vino = new ProductoIndividual(0.10f,"Botella viño tinto",15,10,"Viño",0); vino.numRacion = 1;
       ProductoIndividual zamburinas = new ProductoIndividual(0.1f,"Tapa de zamburinas",102,8,"Zamburiñas",0);zamburinas.numRacion=1;
       menu.setNombre("Menu del dia");menu.setDescrip("Menu de la casa,con todo el cariño de nuestro restaurante");menu.setIva(0.1f);
       ProductoMultiple cafeLeite = new ProductoMultiple();
       cafeLeite.setIva(0.1f);cafeLeite.setNombre("Cafe con leite");cafeLeite.aIngredientes.add(leite);cafeLeite.aIndividuales.add(cafe);
       menu.aIndividuales.add(vino);
       menu.aIndividuales.add(zamburinas);
       menu.aMultiples.add(cafeLeite);

       //Precios
       float pZamburinasIva = 8.8f;
       float pVinoIva = 11;
       float pCafe = 2.0f;
       float pCafeIVA = 2.2f;
       float pVino = 10;
       float pZamburinas = 8;
       float eVino = 12;

       //Comprobamos si elimina las existencias después de añadirlas a la comanda
       Comanda comanda = new Comanda();
      //Tendría que quitar 3 unidades del stock, nos quedan 12
       comanda.anadirComanda(menu,3);
       assertEquals(eVino,vino.getExistencias());
      //Ahora hacemos que cada menu consuma 2 botellas de vino,12-2*3 = 6
       eVino = 6; vino.numRacion=2;
      comanda.anadirComanda(menu,3);
      assertEquals(eVino,vino.getExistencias());
      float eZamburinas = zamburinas.getExistencias();
      eVino = vino.getExistencias();
      //Si no hay existencias suficientes como en este caso, la función añadirComando no debería
      //  quitar existencias del stock
      comanda.anadirComanda(menu,4);
      //la comanda no puede ser realizada porque no hay suficientes unidades de vino
      assertEquals(eVino,vino.getExistencias());
      assertEquals(eZamburinas,zamburinas.getExistencias());

   }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
      @Test
      void imprimirCuenta(){

          Ingrediente leite = new Ingrediente("Leite",1,100,0.1f);leite.descrip="Leite de cabra, pra o café";
          ProductoMultiple menu = new ProductoMultiple();
          ProductoIndividual cafe = new ProductoIndividual(0.1f,"Café hecho en el restaurante",25,1,"Café",0);cafe.numRacion=1;
          ProductoIndividual vino = new ProductoIndividual(0.10f,"Botella viño tinto",15,10,"Viño",0); vino.numRacion = 1;
          ProductoIndividual zamburinas = new ProductoIndividual(0.1f,"Tapa de zamburinas",102,8,"Zamburiñas",0);zamburinas.numRacion=1;
          menu.setNombre("Menu");menu.setDescrip("Menu de la casa,con todo el cariño de nuestro restaurante");menu.setIva(0.1f);
          ProductoMultiple cafeLeite = new ProductoMultiple();
          menu.descuento = 0.8f;
          cafeLeite.setIva(0.1f);cafeLeite.setNombre("Cafe con leite");cafeLeite.aIngredientes.add(leite);cafeLeite.aIndividuales.add(cafe);
          menu.aIndividuales.add(vino);
          menu.aIndividuales.add(zamburinas);
          menu.aMultiples.add(cafeLeite);

          var comanda = new Comanda();
          comanda.mesa = 5;
          comanda.anadirComanda(vino,2);
          comanda.anadirComanda(menu,3);
          comanda.solicitarCuenta();
          String cuenta ="Mesa número 5\n" +comanda.dtf.format(LocalDateTime.now())+
                  "\n" +
                  "Producto    Cantidad Precio PVP unidad  PVP total\n" +
                  "=====================================================\n" +
                  "Viño           2,00  10,00      11,00      22,00\n" +
                  "Menu           3,00  16,00      17,60      52,80\n" +
                  "\n" + "# Pendiente de cobro\n"+
                  "Total sin impuestos   68,00\n" +
                  "Total de impuestos     6,80\n" +
                  "Total                 74,80\n" +
                  "\n" +
                  "\n" ;
          assertEquals(cuenta,outContent.toString());






      }
}
