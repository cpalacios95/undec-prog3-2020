package test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestAerolineas {

    @Test
    public void test01CargarAeorilineaSinError(){
        try {
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "AF", "Baires Fly", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "Austral Lineas Aereas", "1957-01-24");
            //verify
            assertTrue(gesA.AddAerolinea(a01));
            assertTrue(gesA.AddAerolinea(a02));
            assertTrue(gesA.AddAerolinea(a03));
            assertTrue(gesA.AddAerolinea(a04));
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test02CargarAeorilineaConErrorRepetidas(){
        try {
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("30-64140555-4", "AL", "Fly Bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "AF", "Baires Fly", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "Austral Lineas Aereas", "1957-01-24");
            Aerolinea a05 = new Aerolinea("20-14669745-2", "AA", "Andes Lineas Aereas", "1961-11-22");
            //verify
            assertTrue(gesA.AddAerolinea(a01));
            assertFalse(gesA.AddAerolinea(a02));
            assertTrue(gesA.AddAerolinea(a03));
            assertTrue(gesA.AddAerolinea(a04));
            assertFalse(gesA.AddAerolinea(a05));
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test03CargarAerolineasConErroNombreNulo(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", null, "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El nombre de la aerolinea no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test04CargarAerolineasConErrorNombreVacio(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El nombre de la aerolinea no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test05CargarAerolineasConErrorCUITConLetras(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("KK-54963145-0", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El CUIT de la aerolinea no puede contener letras", e.getMessage());
        }
    }

    @Test
    public void test06CargarAerolineasConErrorCUITSinGuionMedio(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30641405554", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El CUIT de la aerolinea debe contener guion medio y tener el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test07CargarAerolineasConErrorCUITFormatoIncorrecto(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("140-54963145-", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El CUIT de la aerolinea debe tener el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test08CargarAerolineasConErrorCodigoIataNulo(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", null, "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El codigo IATA de la aerolinea no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test09CargarAerolineasConErrorCodigoIataVacio(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("El codigo IATA de la aerolinea no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test10CargarAerolineasConErrorCodigoIataLonguitudIncorrecta(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "ARaaa", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("La longuitud del codigo IATA tiene que ser igual a dos letras", e.getMessage());
        }
    }

    @Test
    public void test11CargarAerolineasConErrorCondigoIataLonguitudIncorrecta2(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "ARaaa", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "A", "Fly Bondi", "1970-12-11");
        }catch (ExceptionAerolinea e){
            assertEquals("La longuitud del codigo IATA tiene que ser igual a dos letras", e.getMessage());
        }
    }

    @Test
    public void test12CargarAerolineasConErrorFechaInvalida(){
        try {
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "2021-11-12");
        }catch (ExceptionAerolinea e){
            assertEquals("La Fecha de creacion de la aerolinea no puede ser mayor a la actual", e.getMessage());
        }
    }

    @Test
    public void test13ConsultarCUIT(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "AF", "Baires Fly", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "Austral Lineas Aereas", "1957-01-24");
            //exercise
            String expected01= "30-64140555-4";
            String expected02= "14-54963145-0";
            String expected03= "20-14669745-2";
            String expected04= "12-18649663-4";
            //verify
            assertEquals(expected01, a01.getCUIT());
            assertEquals(expected02, a02.getCUIT());
            assertEquals(expected03, a03.getCUIT());
            assertEquals(expected04, a04.getCUIT());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test14ConsultarNombre(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "AeroLINEAS Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "AF", "Baires FLY", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "aUSTRAL Lineas Aereas", "1957-01-24");
            //exercise
            String expected01= "Aerolineas Argentinas";
            String expected02= "Fly Bondi";
            String expected03= "Baires Fly";
            String expected04= "Austral Lineas Aereas";
            //verify
            assertEquals(expected01, a01.getNombre());
            assertEquals(expected02, a02.getNombre());
            assertEquals(expected03, a03.getNombre());
            assertEquals(expected04, a04.getNombre());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test15ConsultarCodigoIata(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "ar", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "Al", "Fly Bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "aF", "Baires Fly", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "Austral Lineas Aereas", "1957-01-24");
            //exercise
            String expected01= "AR";
            String expected02= "AL";
            String expected03= "AF";
            String expected04= "AA";
            //verify
            assertEquals(expected01, a01.getCodigoIata());
            assertEquals(expected02, a02.getCodigoIata());
            assertEquals(expected03, a03.getCodigoIata());
            assertEquals(expected04, a04.getCodigoIata());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test16ConsultarFechaCreacion(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            Aerolinea a03 = new Aerolinea("20-14669745-2", "AF", "Baires Fly", "1966-06-29");
            Aerolinea a04 = new Aerolinea("12-18649663-4", "AA", "Austral Lineas Aereas", "1957-01-24");
            //exercise
            LocalDate date1= LocalDate.parse("1949-05-14");
            LocalDate date2= LocalDate.parse("1970-12-11");
            LocalDate date3= LocalDate.parse("1966-06-29");
            LocalDate date4= LocalDate.parse("1957-01-24");
            //verify
            assertEquals(date1, a01.getFechaCreacion());
            assertEquals(date2, a02.getFechaCreacion());
            assertEquals(date3, a03.getFechaCreacion());
            assertEquals(date4, a04.getFechaCreacion());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test17SetNombre(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            //exercise
            a01.setNombre("Bariloche Fly");
            a02.setNombre("CorrIentes CoMPAny");
            //verify
            assertEquals("Bariloche Fly", a01.getNombre());
            assertEquals("Corrientes Company", a02.getNombre());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test18SetCUIT(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            //exercise
            a01.setCUIT("37-89110261-0");
            a02.setCUIT("71-12663114-3");
            //verify
            assertEquals("37-89110261-0", a01.getCUIT());
            assertEquals("71-12663114-3", a02.getCUIT());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test19SetCodigoIata(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            //exercise
            a01.setCodigoIata("LF");
            a02.setCodigoIata("aF");
            //verify
            assertEquals("LF", a01.getCodigoIata());
            assertEquals("AF", a02.getCodigoIata());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test20SetFechaCreacion(){
        try {
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Aerolinea a02 = new Aerolinea("14-54963145-0", "AL", "Fly Bondi", "1970-12-11");
            //exercise
            LocalDate date1= LocalDate.parse("1931-11-02");
            LocalDate date2= LocalDate.parse("1996-11-22");
            a01.setFecha("1931-11-02");
            a02.setFecha("1996-11-22");
            //verify
            assertEquals(date1, a01.getFechaCreacion());
            assertEquals(date2, a02.getFechaCreacion());
        }catch (ExceptionAerolinea e){}
    }

    @Test
    public void test21AgregarComandante(){
        try {
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            assertTrue(a01.addComandante(c01));
            assertTrue(a01.addComandante(c02));
        }catch (ExceptionAerolinea | ExceptionComandante e){}
    }

    @Test
    public void test22AgregarComandante(){
        try {
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            assertTrue(a01.addCoPiloto(c01));
            assertTrue(a01.addCoPiloto(c02));
        }catch (ExceptionAerolinea | ExceptionCoPiloto e){}
    }

    @Test
    public void test23AgregarAvion(){
        try {
            GestorAeropuerto gesA= GestorAeropuerto.getInstance();
            gesA.clear();
            //set up
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Avion av01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion av02= new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            assertTrue(a01.addAvion(av01));
            assertTrue(a01.addAvion(av02));
        }catch (ExceptionAerolinea | ExceptionAvion e){}
    }
}
