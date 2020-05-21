package test;

import dominio.Avion;
import exception.ExceptionAvion;
import gestores.GestorAerolinea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAvion {

    @Test
    public void test01CargarNuevoAvionSinError(){
        try {
            //set up
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a03= new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a04= new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a05= new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            assertTrue(gesA.addAvion(a01));
            assertTrue(gesA.addAvion(a02));
            assertTrue(gesA.addAvion(a03));
            assertTrue(gesA.addAvion(a04));
            assertTrue(gesA.addAvion(a05));
        }catch (ExceptionAvion e){ }
    }

    @Test
    public void test02CargarAvionConErrorRepetido(){
        try {
            //set up
            GestorAerolinea gesA= GestorAerolinea.getInstance();
            gesA.clear();
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a03= new Avion("LV-CTC", "Airbus A330-200", 264, 1992);
            Avion a04= new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a05= new Avion("LQ-CAD", "Boeing 737-800", 1994);

            assertTrue(gesA.addAvion(a01));
            assertTrue(gesA.addAvion(a02));
            assertFalse(gesA.addAvion(a03));
            assertTrue(gesA.addAvion(a04));
            assertFalse(gesA.addAvion(a05));
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test03CargarAvionConErrorMatriculaVacia(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("", "Boeing 737-700", 128, 1993);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La matricula no puede ser vacia", e.getMessage());
        }
    }

    @Test
    public void test04CargarAvionConErrorMatriculaNula(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion(null, "Boeing 737-700", 128, 1993);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La matricula no puede ser nula", e.getMessage());
        }
    }

    @Test
    public void test05CargarAvionConErrorModeloNulo(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", null, 128, 1993);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("El modelo no puede ser nulo", e.getMessage());
        }
    }

    @Test
    public void test06CargarAvionConErrorModeloVacio(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "", 128, 1993);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("El modelo no puede ser vacio", e.getMessage());
        }
    }

    @Test
    public void test07CargarNuevoAvionConErrorCapacidadCero(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "Boeing 737-800", 0, 1993);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La capacidad no puede ser igual a cero o negativa", e.getMessage());
        }
    }

    @Test
    public void test08CargarNuevoAvionConErrorCapacidadNegativa(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "Boeing 737-800", -5, 1994);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La capacidad no puede ser igual a cero o negativa", e.getMessage());
        }
    }

    @Test
    public void test09CargarNuevoAvionConErrorAnioDeFabricacionMenorA1900(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "Boeing 737-800", 182, 1900);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("El anio de fabricacion del avion no puede ser menor a 1900", e.getMessage());
        }
    }

    @Test
    public void test10CargarNuevoAvionConErrorAnioDeFabricacionMayorA2020(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "Boeing 737-800", 182, 2030);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("El anio de fabricacion no puede ser mayor al actual", e.getMessage());
        }
    }

    @Test
    public void test11CargarNuevoAvionConErrorMatriculaConMasDe6Diguitos(){
        try {
            //set up
            Avion a01= new Avion("LV-CTCA", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-CAD", "Boeing 737-800", 182, 1994);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La longuitud de la matricula tiene que ser igual a 6", e.getMessage());
        }
    }

    @Test
    public void test12CargarNuevoAvionConErrorMatriculaConMenosDe6Diguitos(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQ-AD", "Boeing 737-800", 182, 1994);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La longuitud de la matricula tiene que ser igual a 4", e.getMessage());
        }
    }

    @Test
    public void test13CargarNuevoAvionConErrorMatriculaSinGuionMedio(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQQCAD", "Boeing 737-800", 182, 1994);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La matricula debe contener un guion medio", e.getMessage());
        }
    }

    @Test
    public void test14CargarNuevoAvionConErrorMatriculaConOtroFormato(){
        try {
            //set up
            Avion a01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("LQCAD-", "Boeing 737-800", 182, 1994);
        }catch (ExceptionAvion e){
            //verify
            assertEquals("La matricula debe tener el formato XX-XXX", e.getMessage());
        }
    }

    @Test
    public void test15CagarNuevoAvionConMatriculaEnMinuscula(){
        try {
            //set up
            Avion a01= new Avion("Lv-CTC", "Boeing 737-800", 182, 1994);
            Avion a02= new Avion("Lq-bYY", "Boeing 737-700", 128, 1993);
            Avion a03= new Avion("LV-Fvh", "Airbus A330-200", 264, 1992);
            Avion a04= new Avion("lq-cad", "Boeing 737-700", 1993);
            Avion a05= new Avion("lV-cXt", "Boeing 737-800", 1994);
            //exercise
            String expected01= "LV-CTC";
            String expected02= "LQ-BYY";
            String expected03= "LV-FVH";
            String expected04= "LQ-CAD";
            String expected05= "LV-CXT";
            //verify
            assertEquals(expected01, a01.getMatricula());
            assertEquals(expected02, a02.getMatricula());
            assertEquals(expected03, a03.getMatricula());
            assertEquals(expected04, a04.getMatricula());
            assertEquals(expected05, a05.getMatricula());
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test16ConsultarModeloAvion(){
        try {
            //set up
            Avion a01= new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02= new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03= new Avion("LQ-CAD", "Boeing 737-700", 1993);
            //exercise
            String expected01= "Boeing 737-700";
            String expected02= "Airbus A330-200";
            String expected03= "Boeing 737-700";
            //verify
            assertEquals(expected01, a01.getModelo());
            assertEquals(expected02, a02.getModelo());
            assertEquals(expected03, a03.getModelo());
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test17ConsultarCapacidadAvion() {
        try {
            //set up
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            int expected01 = 128;
            int expected02 = 264;
            int expected03 = 0;
            int expected04 = 0;
            //verify
            assertEquals(expected01, a01.getCapacidad());
            assertEquals(expected02, a02.getCapacidad());
            assertEquals(expected03, a03.getCapacidad());
            assertEquals(expected04, a04.getCapacidad());
        }catch(ExceptionAvion e){}
    }

    @Test
    public void test18ConsultarAnioDeFabricacion(){
        try {
            //set up
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            int expected01 = 1993;
            int expected02 = 1992;
            int expected03 = 1993;
            int expected04 = 1994;
            //verify
            assertEquals(expected01, a01.getAnioDeFabricacion());
            assertEquals(expected02, a02.getAnioDeFabricacion());
            assertEquals(expected03, a03.getAnioDeFabricacion());
            assertEquals(expected04, a04.getAnioDeFabricacion());
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test19SetMatricula(){
        try {
            //set up
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            a01.setMatricula("LQ-BYT");
            a02.setMatricula("LQ-HHH");
            a03.setMatricula("LV-ABC");
            a04.setMatricula("LX-XYZ");
            //verify
            assertEquals("LQ-BYT", a01.getMatricula());
            assertEquals("LQ-HHH", a02.getMatricula());
            assertEquals("LV-ABC", a03.getMatricula());
            assertEquals("LX-XYZ", a04.getMatricula());
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test20setModelo(){
        try {
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            a01.setModelo("Airbus A330-200");
            a02.setModelo("Embraer 190");
            a03.setModelo("Boeing 747-400");
            a04.setModelo("Avro York");
            //verify
            assertEquals("Airbus A330-200", a01.getModelo());
            assertEquals("Embraer 190", a02.getModelo());
            assertEquals("Boeing 747-400", a03.getModelo());
            assertEquals("Avro York", a04.getModelo());
        }catch (ExceptionAvion e){}
    }

    @Test
    public void test21SetCapacidad(){
        try {
            //set up
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            a01.setCapacidad(150);
            a02.setCapacidad(270);
            a03.setCapacidad(130);
            a04.setCapacidad(220);
            //verify
            assertEquals(150, a01.getCapacidad());
            assertEquals(270, a02.getCapacidad());
            assertEquals(130, a03.getCapacidad());
            assertEquals(220, a04.getCapacidad());
        }catch(ExceptionAvion e){}
    }

    @Test
    public void test22SetAnioDeFabricacion(){
        try {
            //set up
            Avion a01 = new Avion("LQ-BYY", "Boeing 737-700", 128, 1993);
            Avion a02 = new Avion("LV-FVH", "Airbus A330-200", 264, 1992);
            Avion a03 = new Avion("LQ-CAD", "Boeing 737-700", 1993);
            Avion a04 = new Avion("LV-CXT", "Boeing 737-800", 1994);
            //exercise
            a01.setAnioDeFabricacion(1992);
            a02.setAnioDeFabricacion(1990);
            a03.setAnioDeFabricacion(2002);
            a04.setAnioDeFabricacion(2001);
            //verify
            assertEquals(1992, a01.getAnioDeFabricacion());
            assertEquals(1990, a02.getAnioDeFabricacion());
            assertEquals(2002, a03.getAnioDeFabricacion());
            assertEquals(2001, a04.getAnioDeFabricacion());
        }catch (ExceptionAvion e){}
    }
}
