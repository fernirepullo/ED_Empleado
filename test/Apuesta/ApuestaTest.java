/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apuesta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fer
 */
public class ApuestaTest {

    public ApuestaTest() {

    }

    /**
     * Test of apostar method, of class Apuesta.
     */
    @Test
    public void testApostarDineroNegativo() throws Exception {
        System.out.println("apostar valores menor que 0");
        int dinero = -50;
        int minimo = 1;
        Apuesta apuesta = new Apuesta();

        if (dinero < minimo){
            Exception thrown = assertThrows(
                    Exception.class,
                    () -> {
                        apuesta.apostar(dinero);});

            assertTrue(thrown.getMessage().contains("No se puede"));
        }

        else {
            apuesta.apostar(dinero);
        }
    }

    @Test
    public void testApostarDineroEntreLimites() throws Exception {

        System.out.println("apostar valores entre 1 y dinero disponible");
        Apuesta apuesta = new Apuesta();
        int dinero = 25;
        int minimo = 1;
        int dineroDisp = 100;

        apuesta.setDinero_disp(dineroDisp);
        apuesta.apostar(dinero);
        assertTrue(dinero >= minimo && dinero <= apuesta.getDinero_disp());

    }

    @Test
    public void testApostarDineroSuperiorAlDisponible() throws Exception {
        System.out.println("apostar valores superior a dinero disponible");
        int dinero = 110;
        int dineroDisp = 100;

        Apuesta apuesta = new Apuesta();
        apuesta.setDinero_disp(dineroDisp);

        if (dinero > dineroDisp) {

            Exception thrown = assertThrows(
                    Exception.class,
                    () -> {
                        apuesta.apostar(dinero);
                    });

            assertTrue(thrown.getMessage().contains("No se puede"));
        }
        else {

            apuesta.apostar(dinero);
        }
    }

    /**
     * Test of cobrar_apuesta method, of class Apuesta.
     */
    @Test
    public void testCobrar_apuestaValoresValidos() throws Exception {
        System.out.println("cobrar_apuesta");

        int cantidad_goles_local = 2;
        int cantidad_goles_visit = 3;

        Apuesta apuesta = new Apuesta();
        boolean acierto = apuesta.comprobar_resultado(cantidad_goles_local, cantidad_goles_visit);

        if(!acierto){

            Exception thrown = assertThrows(
                    Exception.class,
                    () -> {
                        apuesta.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit);
                    });

            assertTrue(thrown.getMessage().contains("No se puede"));
        }
        else {

            apuesta.cobrar_apuesta(cantidad_goles_local, cantidad_goles_visit);

        }
    }

}
