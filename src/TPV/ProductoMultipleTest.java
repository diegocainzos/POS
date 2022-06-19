package TPV;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoMultipleTest {
    @Test
    void main(){
        //Leite: Precio: 1$, Existencias:100, Iva:10%(Igual pra todos)
        //Cafe: Precio: 1$, Existencias: 25
        //Zamburiñas: Precio:8$, Existencias:102
        //Viño: Precio: 10$, Existencias: 15
        //Menu
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
        float pZamburinasIva = 8.8f;
        float pVinoIva = 11;
        float pCafe = 2.0f;
        float pCafeIVA = 2.2f;
        float pVino = 10;
        float pZamburinas = 8;
        //Los precios individuales
        assertEquals(pZamburinasIva,zamburinas.getPVP());
        assertEquals(pVinoIva,vino.getPVP());
        assertEquals(pCafe,cafeLeite.getPrecio());
        assertEquals(pCafeIVA,cafeLeite.getPVP());
       // System.out.println("El precio del cafe con leche sin iva es "+cafeLeite.getPrecio()+" según el programa.\nY debería ser "+pCafe);
       // System.out.println("El precio del cafe con leche con iva es "+cafeLeite.getPVP()+" según el programa.\nY debería ser "+pCafeIVA);
        //El calculo de un producto multiple
        float pmenuIVA = pCafeIVA+pVinoIva+pZamburinasIva;
        float pmenu = pCafe+pVino+pZamburinas;
        assertEquals(pmenuIVA,menu.getPVP());
        assertEquals(pmenu,menu.getPrecio());
        System.out.println(vino.getExistencias());
        vino.anadirExis(5);
        assertEquals(20,vino.getExistencias());
        vino.restarExis(5);
        assertEquals(15,vino.getExistencias());
        //Cambio de descuento
        pCafe = pCafe/2;
        pCafeIVA=pCafeIVA/2;
        cafeLeite.descuento = 0.5F;
        assertEquals(pCafeIVA,cafeLeite.getPVP());
        assertEquals(pCafe,cafeLeite.getPrecio());
        //Cambio método calculo PVP
        cafeLeite.Modo = ProductoMultiple.modo.FIJO;
        cafeLeite.pFijo = 245;
        pCafeIVA = 245 + 245* cafe.getIva();
        assertEquals(pCafeIVA,cafeLeite.getPVP());

    }

}