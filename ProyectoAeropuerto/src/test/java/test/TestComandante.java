package test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestComandante {

    @Test
    public void test01CargarNuevoComandanteSinError(){
        try {
            //set up
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //verify
            assertTrue(gesA.addComandante(c01));
            assertTrue(gesA.addComandante(c02));
            assertTrue(gesA.addComandante(c03));
            assertTrue(gesA.addComandante(c04));
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test02CargarComandanteConErrorRepetido(){
        try {
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22",  100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            Comandante c05= new Comandante("Cerezo", "Guillermo Jose", "20-35535653-0", "1990-05-12", 190344);

            //verify
            assertTrue(gesA.addComandante(c01));
            assertFalse(gesA.addComandante(c02));
            assertTrue(gesA.addComandante(c03));
            assertTrue(gesA.addComandante(c04));
            assertFalse(gesA.addComandante(c05));
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test03CargarComandanteConErrorApellidoNulo(){
        try {
            //set up
            Comandante c01= new Comandante ("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22",100267);
            Comandante c02= new Comandante (null, "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
        }catch (ExceptionComandante e){
            assertEquals("El apellido del comandante no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test04CargarComandanteConErrorApellidoVacio(){
        try {
            //set up
            Comandante c01= new Comandante ("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02= new Comandante ("", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
        }catch (ExceptionComandante e) {
            assertEquals("El apellido del comandante no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test05CargarComandanteConErrorNombreNulo() {
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", null, "20-35535653-0", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El nombre del comandante no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test06CargarComandanteConErrorNombreVacio(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "", "20-35535653-0", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El nombre del comandante no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test07CargarComandanteConErrorCUILConLetras(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "LL-35535653-0", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El cuil no debe contener letras", e.getMessage());
        }
    }

    @Test
    public void test08CargarComandanteConErrorCUILSinGuionMedio(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "20355356530", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El cuil debe contener guines medios y el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test09CargarComandanteConErrorCUILFormatoIncorrecto(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "203-55356530-", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El cuil debe tener el siguiente formato XX-XXXXXXXX-X", e.getMessage());
        }
    }

    @Test
    public void test10CargarComandanteConErrorAnioDeNacimientoIncorrecto(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1930-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El anio de nacimiento del comandante no puede ser mayor de 1940", e.getMessage());
        }
    }
    @Test
    public void test11CargarComandanteConErrorAnioDeNacimientoIncorrecto(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "2005-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17",195832);
        } catch (ExceptionComandante e) {
            assertEquals("El anio de nacimiento del comandante no puede ser menor de 1995", e.getMessage());
        }
    }

    @Test
    public void test14CargarComandanteConErrorLegajoIgualACero(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 0);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
        } catch (ExceptionComandante e) {
            assertEquals("El legajo no puede ser igual a cero o negativo", e.getMessage());
        }
    }

    @Test
    public void test15CargarComandanteConErrorLegajoNegativo(){
        try {
            //set up
            Comandante c01 = new Comandante("Larrain", "Leandro Alfredo", "17-34896124-3", "1977-08-22", 100267);
            Comandante c02 = new Comandante("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", -14);
        } catch (ExceptionComandante e) {
            assertEquals("El legajo no puede ser igual a cero o negativo", e.getMessage());
        }
    }

    @Test
    public void test16ConsultarApellidos(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("LARRAIN", "Leandro Alfredo", "21-35236114-4", "1977-08-22",  100267);
            Comandante c03= new Comandante ("SCALET diaZ", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("ChanaMPE", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            String expected01="Gallegos Espejo";
            String expected02="Larrain";
            String expected03="Scalet Diaz";
            String expected04="Chanampe";
            //verify
            assertEquals(expected01, c01.getApellidos());
            assertEquals(expected02, c02.getApellidos());
            assertEquals(expected03, c03.getApellidos());
            assertEquals(expected04, c04.getApellidos());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test17ConsultarNombres(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro AlFREDO", "21-35236114-4", "1977-08-22", 100267);
            Comandante c03= new Comandante ("Scalet Diaz", "JuaN IgnAcio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "SantiagO NiCOLAS", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            String expected01="Yamil Sebastian";
            String expected02="Leandro Alfredo";
            String expected03="Juan Ignacio";
            String expected04="Santiago Nicolas";
            //verify
            assertEquals(expected01, c01.getNombres());
            assertEquals(expected02, c02.getNombres());
            assertEquals(expected03, c03.getNombres());
            assertEquals(expected04, c04.getNombres());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test18ConsultarCUIL(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22",  100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            String expected01="17-34896124-3";
            String expected02="21-35236114-4";
            String expected03="20-35535653-0";
            String expected04="15-36740258-0";
            //verify
            assertEquals(expected01, c01.getCUIL());
            assertEquals(expected02, c02.getCUIL());
            assertEquals(expected03, c03.getCUIL());
            assertEquals(expected04, c04.getCUIL());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test19ConsultarLegajo(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            int expected01=190283;
            int expected02=100267;
            int expected03=195832;
            int expected04=189445;
            //verify
            assertEquals(expected01, c01.getLegajo());
            assertEquals(expected02, c02.getLegajo());
            assertEquals(expected03, c03.getLegajo());
            assertEquals(expected04, c04.getLegajo());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test20ConsultarFechaNacimiento(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            //exercise
            LocalDate date1= LocalDate.parse("1980-08-03");
            LocalDate date2= LocalDate.parse("1977-08-22");
            //verify
            assertEquals(date1, c01.getFechaNacimiento());
            assertEquals(date2, c02.getFechaNacimiento());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test21SetApellidos(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22",  100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            c01.setApellidos("Rodriguez");
            c02.setApellidos("Palacios");
            c03.setApellidos("RolDAN");
            c04.setApellidos("Chanampe");
            //verify
            assertEquals("Rodriguez", c01.getApellidos());
            assertEquals("Palacios", c02.getApellidos());
            assertEquals("Roldan", c03.getApellidos());
            assertEquals("Chanampe", c04.getApellidos());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test22SetNombres(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22",  100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            c01.setNombres("Matias NaHUel");
            c02.setNombres("Cristian Gabriel");
            c03.setNombres("Horacio");
            c04.setNombres("Gustavo");
            //verify
            assertEquals("Matias Nahuel", c01.getNombres());
            assertEquals("Cristian Gabriel", c02.getNombres());
            assertEquals("Horacio", c03.getNombres());
            assertEquals("Gustavo", c04.getNombres());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test23SetCUIL(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            //exercise
            c01.setCUIL("17-34898824-3");
            c02.setCUIL("21-39936114-4");
            //verify
            assertEquals("17-34898824-3", c01.getCUIL());
            assertEquals("21-39936114-4", c02.getCUIL());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test24SetFechaNacimiento(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22", 100267);
            //exercise
            c01.setFechaNacimiento("1981-06-17");
            c02.setFechaNacimiento("1980-08-03");
            LocalDate date1= LocalDate.parse("1981-06-17");
            LocalDate date2= LocalDate.parse("1980-08-03");
            //verify
            assertEquals(date1, c01.getFechaNacimiento());
            assertEquals(date2, c02.getFechaNacimiento());
        }catch (ExceptionComandante e){}
    }

    @Test
    public void test25SetLegajo(){
        try {
            //set up
            Comandante c01= new Comandante ("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            Comandante c02= new Comandante ("Larrain", "Leandro Alfredo", "21-35236114-4", "1977-08-22",  100267);
            Comandante c03= new Comandante ("Scalet Diaz", "Juan Ignacio", "20-35535653-0", "1981-06-17", 195832);
            Comandante c04= new Comandante ("Chanampe", "Santiago Nicolas", "15-36740258-0", "1963-02-03", 189445);
            //exercise
            c01.setLegajo(190284);
            c02.setLegajo(250267);
            c03.setLegajo(111132);
            c04.setLegajo(180440);
            //verify
            assertEquals(190284, c01.getLegajo());
            assertEquals(250267, c02.getLegajo());
            assertEquals(111132, c03.getLegajo());
            assertEquals(180440, c04.getLegajo());
        }catch (ExceptionComandante e){}
    }
}
