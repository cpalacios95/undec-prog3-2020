package test;


import dominio.Aeropuerto;
import exception.ExceptionAeropuerto;
import gestores.GestorAeropuerto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestAeropuerto {

    @Test
    public void test01CargarAeropuertoSinError(){
        try {
            //set up
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRJ", "Aeropuerto Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);

            assertTrue(gesA.addAeropuerto(a01));
            assertTrue(gesA.addAeropuerto(a02));
            assertTrue(gesA.addAeropuerto(a03));
            assertTrue(gesA.addAeropuerto(a04));
        }catch (ExceptionAeropuerto e){}

    }

    @Test
    public void test02CargarAeropuertoConErrorCodigIataRepetido(){
        try {
            //set up
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("BRC", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 6480);
            Aeropuerto a03= new Aeropuerto("LRJ", "Aeropuerto Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);

            assertTrue(gesA.addAeropuerto(a01));
            assertFalse(gesA.addAeropuerto(a02));
            assertTrue(gesA.addAeropuerto(a03));
            assertTrue(gesA.addAeropuerto(a04));
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test03CargarAeropuertoConErrorCodigoIataNulo(){
        try {
            //set up

            Aeropuerto a01= new Aeropuerto(null, "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El codigo IATA del aeropuerto no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test04CargarAeropuertoConErrorCodigoIataVacio(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El codigo IATA del aeropuerto no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test05CargarAeropuertoConErrorCodigoIataLonguitudIncorrecta(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRCCCC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("La longuitud del codigo IATA tiene que ser igual a tres letras", e.getMessage());
        }
    }

    @Test
    public void test06CargarAeropuertoConErrorCondigoIataLonguitudIncorrecta2(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("UJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("La longuitud del codigo IATA tiene que ser igual a tres letras", e.getMessage());
        }
    }

    @Test
    public void test07CargarAeropuertoConErrorNombreNulo(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", null, "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El nombre del aeropuerto no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test08CargarAeropuertoConErrorNombreVacio(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El nombre del aeropuerto no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test09CargarAeropuertoConErrorCiudadNula(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", null, 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El nombre de la ciudad no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test10CargarAeropuertoConErrorCiudadVacia(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El nombre de la ciudad no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test11CargarAeropuertoConErrorCodigoPostalIgualACero(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 0);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
        }catch (ExceptionAeropuerto e){
            assertEquals("El codigo postal no puede ser igual a cero", e.getMessage());
        }
    }

    @Test
    public void test12CargarAeropuertoConErrorCodigoPostalNegativo(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", -2);
        }catch (ExceptionAeropuerto e){
            assertEquals("El codigo postal no puede ser negativo", e.getMessage());
        }
    }

    @Test
    public void test13ConsultarCodigoIata(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("brc", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("Juj", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRj", "Aeropuerto Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("mDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);
            //exercise
            String expected01= "BRC";
            String expected02= "JUJ";
            String expected03= "LRJ";
            String expected04= "MDZ";
            //verify
            assertEquals(expected01, a01.getCodigoIata());
            assertEquals(expected02, a02.getCodigoIata());
            assertEquals(expected03, a03.getCodigoIata());
            assertEquals(expected04, a04.getCodigoIata());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test14ConsultarNombre(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional TenientE Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto INTERNacional Gobernador HORACIO guzman", "San Salvador de Jujuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRJ", "AeropUERTO Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);
            //exercise
            String expected01= "Aeropuerto Internacional Teniente Luis Candelaria";
            String expected02= "Aeropuerto Internacional Gobernador Horacio Guzman";
            String expected03= "Aeropuerto Capitán Vicente Almandos Almonacid";
            String expected04= "Aeropuerto Internacional De Mendoza";
            //verify
            assertEquals(expected01, a01.getNombre());
            assertEquals(expected02, a02.getNombre());
            assertEquals(expected03, a03.getNombre());
            assertEquals(expected04, a04.getNombre());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test15ConsultarCiudad(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San CARLOS de BaRILOche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de JuJuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRJ", "Aeropuerto Capitán Vicente Almandos Almonacid", "La RiojA", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "mendozA", 1451);
            //exercise
            String expected01= "San Carlos De Bariloche";
            String expected02= "San Salvador De Jujuy";
            String expected03= "La Rioja";
            String expected04= "Mendoza";
            //verify
            assertEquals(expected01, a01.getCiudad());
            assertEquals(expected02, a02.getCiudad());
            assertEquals(expected03, a03.getCiudad());
            assertEquals(expected04, a04.getCiudad());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test16ConsultarCodigoPostal(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRJ", "Aeropuerto Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);
            //exercise
            int expected01= 6480;
            int expected02= 2112;
            int expected03= 5360;
            int expected04= 1451;
            //verify
            assertEquals(expected01, a01.getCodigoPostal());
            assertEquals(expected02, a02.getCodigoPostal());
            assertEquals(expected03, a03.getCodigoPostal());
            assertEquals(expected04, a04.getCodigoPostal());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test17SetCodigoIata(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.setCodigoIata("BRA");
            a02.setCodigoIata("Lrr");
            //verify
            assertEquals("BRA", a01.getCodigoIata());
            assertEquals("LRR", a02.getCodigoIata());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test18setNombre(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.setNombre("AeropuERTO Teniente Luis Candelaria");
            a02.setNombre("Aeropuerto Internacional INTENDENTe Horacio Guzman");
            //verify
            assertEquals("Aeropuerto Teniente Luis Candelaria", a01.getNombre());
            assertEquals("Aeropuerto Internacional Intendente Horacio Guzman", a02.getNombre());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test19setCiudad(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.setCiudad("Rosario");
            a02.setCiudad("San JUAn");
            //verify
            assertEquals("Rosario", a01.getCiudad());
            assertEquals("San Juan", a02.getCiudad());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test20setCodigoPostal(){
        try {
            //set up
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.setCodigoPostal(2560);
            a02.setCodigoPostal(1780);
            //verify
            assertEquals(2560, a01.getCodigoPostal());
            assertEquals(1780, a02.getCodigoPostal());
        }catch (ExceptionAeropuerto e){}
    }

    @Test
    public void test21BuscarAeropuertoPorCodigoIATA(){
        try {
            //set up
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            Aeropuerto a01= new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto a02= new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            Aeropuerto a03= new Aeropuerto("LRJ", "Aeropuerto Capitán Vicente Almandos Almonacid", "La Rioja", 5360);
            Aeropuerto a04= new Aeropuerto("MDZ", "Aeropuerto Internacional de Mendoza", "Mendoza", 1451);
            //exercise
            gesA.addAeropuerto(a01);
            gesA.addAeropuerto(a02);
            gesA.addAeropuerto(a03);
            gesA.addAeropuerto(a04);
            ArrayList<Aeropuerto> aeropuertosPrueba= new ArrayList<Aeropuerto>();
            aeropuertosPrueba.add(a01);
            //verify
            assertEquals(aeropuertosPrueba, gesA.buscarAeropuerto("BRC"));
        }catch (ExceptionAeropuerto e){}
    }
}
