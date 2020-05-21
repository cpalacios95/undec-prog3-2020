package test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestCoPiloto {
    @Test
    public void test01CargarNuevoCoPilotoSinError(){
        try {
            //set up
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);

            //verify
            assertTrue(gesA.addCoPioloto(c01));
            assertTrue(gesA.addCoPioloto(c02));
            assertTrue(gesA.addCoPioloto(c03));
            assertTrue(gesA.addCoPioloto(c04));
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test02CargarCoPilotoConErrorRepetido(){
        try {
            //set up
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "21-29878766-0", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            CoPiloto c05= new CoPiloto("Malebran", "Gustavo", "10-12569898-3", "1990-06-12", 110344);
            //verify
            assertTrue(gesA.addCoPioloto(c01));
            assertFalse(gesA.addCoPioloto(c02));
            assertTrue(gesA.addCoPioloto(c03));
            assertTrue(gesA.addCoPioloto(c04));
            assertFalse(gesA.addCoPioloto(c05));
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test03CargarCoPilotoConErrorApellidoNulo(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto (null, "Ezequiel", "21-29878766-0", "1967-02-12", 1112245);
        }catch (ExceptionCoPiloto e){
            assertEquals("El apellido del copiloto no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test04CargarCoPilotoConErrorApellidoVacio(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("", "Ezequiel", "21-29878766-0", "1967-02-12", 1112245);
        }catch (ExceptionCoPiloto e) {
            assertEquals("El apellido del copiloto no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test05CargarCoPilotoConErrorNombreNulo() {
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", null, "19-14569874-1", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El nombre del copiloto no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test06CargarCoPilotoConErrorNombreVacio(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El nombre del copiloto no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test07CargarCoPilotoConErrorCUILConLetras(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "AA-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El cuil no debe contener letras", e.getMessage());
        }
    }

    @Test
    public void test08CargarCoPilotoConErrorCUILSinGuionMedio(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19145698741", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El cuil debe contener guines medios y el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test09CargarCoPilotoConErrorCUILFormatoIncorrecto(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "191-14569874-", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El cuil debe tener el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test10CargarCoPilotoConErrorAnioDeNacimientoIncorrecto(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1920-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El anio de nacimiento del copiloto no puede ser mayor de 1940", e.getMessage());
        }
    }
    @Test
    public void test11CargarCoPilotoConErrorAnioDeNacimientoIncorrecto(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "2050-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El anio de nacimiento del copiloto no puede ser menor de 1995", e.getMessage());
        }
    }


    @Test
    public void test14CargarCoPilotoConErrorLegajoIgualACero(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 0);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El legajo no puede ser igual a cero o negativo", e.getMessage());
        }
    }

    @Test
    public void test15CargarCoPilotoConErrorLegajoNegativo(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21",-1);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
        } catch (ExceptionCoPiloto e) {
            assertEquals("El legajo no puede ser igual a cero o negativo", e.getMessage());
        }
    }

    @Test
    public void test16ConsultarApellidos(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("CardozO", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("CONTe", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("NieTO", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("VarGas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            String expected01="Cardozo";
            String expected02="Conte";
            String expected03="Nieto";
            String expected04="Vargas";
            //verify
            assertEquals(expected01, c01.getApellidos());
            assertEquals(expected02, c02.getApellidos());
            assertEquals(expected03, c03.getApellidos());
            assertEquals(expected04, c04.getApellidos());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test17ConsultarNombres(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "FRANco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "EzequIel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis agUstin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            String expected01="Franco Abel";
            String expected02="Ezequiel";
            String expected03="Facundo Martin";
            String expected04="Alexis Agustin";
            //verify
            assertEquals(expected01, c01.getNombres());
            assertEquals(expected02, c02.getNombres());
            assertEquals(expected03, c03.getNombres());
            assertEquals(expected04, c04.getNombres());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test18ConsultarCUIL(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            String expected01="21-29878766-0";
            String expected02="19-14569874-1";
            String expected03="10-12569898-3";
            String expected04="11-31100258-0";
            //verify
            assertEquals(expected01, c01.getCUIL());
            assertEquals(expected02, c02.getCUIL());
            assertEquals(expected03, c03.getCUIL());
            assertEquals(expected04, c04.getCUIL());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test19ConsultarLegajo(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            int expected01=164863;
            int expected02=1112245;
            int expected03=112121;
            int expected04=123698;
            //verify
            assertEquals(expected01, c01.getLegajo());
            assertEquals(expected02, c02.getLegajo());
            assertEquals(expected03, c03.getLegajo());
            assertEquals(expected04, c04.getLegajo());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test20ConsultarFechaNacimiento(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "21-29878766-0", "1967-02-12", 1112245);
            //exercise
            LocalDate date1= LocalDate.parse("1958-10-21");
            LocalDate date2= LocalDate.parse("1967-02-12");
            //verify
            assertEquals(date1, c01.getFechaNacimiento());
            assertEquals(date2, c02.getFechaNacimiento());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test21SetApellidos(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            c01.setApellidos("Soria");
            c02.setApellidos("meDINA");
            c03.setApellidos("Gonzalez");
            c04.setApellidos("CASTROS");
            //verify
            assertEquals("Soria", c01.getApellidos());
            assertEquals("Medina", c02.getApellidos());
            assertEquals("Gonzalez", c03.getApellidos());
            assertEquals("Castros", c04.getApellidos());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test22SetNombres(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            CoPiloto c03= new CoPiloto ("Nieto", "Facundo Martin", "10-12569898-3", "1988-01-21", 112121);
            CoPiloto c04= new CoPiloto ("Vargas", "Alexis Agustin", "11-31100258-0", "1960-11-13", 123698);
            //exercise
            c01.setNombres("RODRIGO");
            c02.setNombres("GASTon Ramiro");
            c03.setNombres("Patricio GabrieL");
            c04.setNombres("FErnando");
            //verify
            assertEquals("Rodrigo", c01.getNombres());
            assertEquals("Gaston Ramiro", c02.getNombres());
            assertEquals("Patricio Gabriel", c03.getNombres());
            assertEquals("Fernando", c04.getNombres());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test23SetCUIL(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            //exercise
            c01.setCUIL("21-31898824-3");
            c02.setCUIL("20-11104314-1");
            //verify
            assertEquals("21-31898824-3", c01.getCUIL());
            assertEquals("20-11104314-1", c02.getCUIL());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test24SetFechaNacimiento(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            //exercise
            c01.setFechaNacimiento("1977-01-31");
            c02.setFechaNacimiento("1991-11-23");
            LocalDate date1= LocalDate.parse("1977-01-31");
            LocalDate date2= LocalDate.parse("1991-11-23");
            //verify
            assertEquals(date1, c01.getFechaNacimiento());
            assertEquals(date2, c02.getFechaNacimiento());
        }catch (ExceptionCoPiloto e){}
    }

    @Test
    public void test25SetLegajo(){
        try {
            //set up
            CoPiloto c01= new CoPiloto ("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            CoPiloto c02= new CoPiloto ("Conte", "Ezequiel", "19-14569874-1", "1967-02-12", 1112245);
            //exercise
            c01.setLegajo(125697);
            c02.setLegajo(213601);
            //verify
            assertEquals(125697, c01.getLegajo());
            assertEquals(213601, c02.getLegajo());
        }catch (ExceptionCoPiloto e){}
    }
}
