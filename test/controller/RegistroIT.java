/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import javax.swing.JTable;
import model.Categoria;
import model.Pelicula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Cristian
 */
public class RegistroIT {
    
    public RegistroIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicio de Prueba");
    }
    
    @After
    public void tearDown() {
        System.out.println("Fin de prueba");
    }

    /**
     * Test of Grabar method, of class Registro.
     */
    @Test
    public void testGrabar() {
        System.out.println("Grabar Categoría");
        Categoria categoria = new Categoria();
        Registro instance = new Registro();
        categoria.setId(606);
        categoria.setDescripcion("CategoriaTest00");
        System.out.println("Debe entregar true");
        boolean a=instance.Grabar(categoria);
        
        assertEquals(a, true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of GrabarP method, of class Registro.
     */
    @Test
    public void testGrabarP() {
        System.out.println("Grabar Película");
        Pelicula pelicula = new Pelicula();
        Registro instance = new Registro();
        pelicula.setId(676);
        pelicula.setCodigo(90009);
        pelicula.setDescripcion("CategoriaTest");
        pelicula.setFormato4k("N");
        pelicula.setNombre("PeliculaTest");
        pelicula.setPrecio(2000);
        System.out.println("Debe entregar true");
        boolean a=instance.GrabarP(pelicula);
        assertEquals(true,a);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Check method, of class Registro.
     */
    @Test
    @Ignore
    public void testCheck() {
        System.out.println("Check");
        int id = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.Check(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of CheckP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testCheckP() {
        System.out.println("CheckP");
        int cod = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.CheckP(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of CheckPP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testCheckPP() {
        System.out.println("CheckPP");
        int cod = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.CheckPP(cod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of VerificarC method, of class Registro.
//     */
    @Test
    @Ignore
    public void testVerificarC() {
        System.out.println("VerificarC");
        int id = 0;
        Registro instance = new Registro();
        Categoria expResult = null;
        Categoria result = instance.VerificarC(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of BuscarP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testBuscarP() {
        System.out.println("BuscarP");
        JTable table = null;
        int Codigo = 0;
        Registro instance = new Registro();
        JTable expResult = null;
        JTable result = instance.BuscarP(table, Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of BuscarC method, of class Registro.
//     */
    @Test
    @Ignore
    public void testBuscarC() {
        System.out.println("BuscarC");
        JTable table = null;
        int Codigo = 0;
        Registro instance = new Registro();
        JTable expResult = null;
        JTable result = instance.BuscarC(table, Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of BuscarCP method, of class Registro.
//     */
    @Test
    public void testBuscarCP() {
        System.out.println("Buscar película por Categoría");
        System.out.println("Recibe una JTable y un string con la descripción de la categoría");
        JTable table = new JTable();
        String Codigo = "SciFi";
        Registro instance = new Registro();
        JTable expResult = table;
        System.out.println("Debe entregar un objeto JTable");
        JTable result = instance.BuscarCP(table, Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of EliminarP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testEliminarP() {
        System.out.println("EliminarP");
        int Codigo = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.EliminarP(Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of EliminarPP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testEliminarPP() {
        System.out.println("EliminarPP");
        int Codigo = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.EliminarPP(Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of EliminarC method, of class Registro.
//     */
    @Test
    @Ignore
    public void testEliminarC() {
        System.out.println("EliminarC");
        int id = 0;
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.EliminarC(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of Mostrar method, of class Registro.
//     */
    @Test
    @Ignore
    public void testMostrar() {
        System.out.println("Mostrar");
        JTable table = null;
        Registro instance = new Registro();
        JTable expResult = null;
        JTable result = instance.Mostrar(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of MostrarPP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testMostrarPP() {
        System.out.println("MostrarPP");
        JTable table = null;
        Registro instance = new Registro();
        JTable expResult = null;
        JTable result = instance.MostrarPP(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of MostrarC method, of class Registro.
//     */
    @Test
    @Ignore
    public void testMostrarC() {
        System.out.println("MostrarC");
        JTable table = null;
        Registro instance = new Registro();
        JTable expResult = null;
        JTable result = instance.MostrarC(table);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of VerificarP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testVerificarP() {
        System.out.println("VerificarP");
        int Codigo = 0;
        Registro instance = new Registro();
        Pelicula expResult = null;
        Pelicula result = instance.VerificarP(Codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of Modificar method, of class Registro.
//     */
    @Test
    public void testModificar() {
        System.out.println("Modificar Película con ID inexistente");
        System.out.println("Se crea un objeto pelicula");
        Pelicula pelicula = new Pelicula();
        Registro instance = new Registro();
        pelicula.setId(818);
        pelicula.setCodigo(919);
        pelicula.setDescripcion("CategoriaTest");
        pelicula.setFormato4k("N");
        pelicula.setNombre("PeliculaTest");
        pelicula.setPrecio(2000);
        System.out.println("Debe devolver false");
        boolean expResult = false;
        boolean result = instance.Modificar(pelicula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of AgregarPP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testAgregarPP() {
        System.out.println("AgregarPP");
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.AgregarPP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of RemoverPP method, of class Registro.
//     */
    @Test
    @Ignore
    public void testRemoverPP() {
        System.out.println("RemoverPP");
        Registro instance = new Registro();
        boolean expResult = false;
        boolean result = instance.RemoverPP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of BuscarPalabra method, of class Registro.
//     */
    @Test
    public void testBuscarPalabra() {
        System.out.println("Buscar por Palabra");
        System.out.println("Recibe un objeto JTable y un string");
        JTable table = new JTable();
        String palabra = "ar";
        Registro instance = new Registro();
        System.out.println("Debe devolver un objeto JTable");
        JTable expResult = table;
        JTable result = instance.BuscarPalabra(table, palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of Valores method, of class Registro.
//     */
    @Test
    @Ignore
    public void testValores() {
        System.out.println("Valores");
        JComboBox cmb = null;
        Registro instance = new Registro();
        JComboBox expResult = null;
        JComboBox result = instance.Valores(cmb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
