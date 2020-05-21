package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVuelo {

    @Test
    public void test01CargarVuelo() {
        try {
            //set up
            GestorVuelo ges= GestorVuelo.getInstance();
            ges.clear();
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Comandante piloto01 = new Comandante("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            CoPiloto copiloto01 = new CoPiloto("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            Avion av01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Vuelo v01 = new Vuelo(1234, "2020-10-12", "08:30", "2020-10-12", "13:21",a01);
            Aeropuerto aero01 = new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto aero02 = new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.clear();
            a01.addComandante(piloto01);
            a01.addCoPiloto(copiloto01);
            a01.addAvion(av01);
            v01.addAerolinea(a01);
            v01.addAeropuertoSalida(aero01);
            v01.addAeropuertoLlegada(aero02);
            //verify
            assertTrue(ges.addVuelo(v01));
        } catch (ExceptionAerolinea aero) {
        } catch (ExceptionAvion avion) {
        } catch (ExceptionAeropuerto aerop) {
        } catch (ExceptionComandante com) {
        } catch (ExceptionCoPiloto cop) {
        }
    }

    @Test
    public void test02ComprobarDatosVuelo(){
        try {
            //set up
            GestorVuelo ges= GestorVuelo.getInstance();
            ges.clear();
            Aerolinea a01 = new Aerolinea("30-64140555-4", "AR", "Aerolineas Argentinas", "1949-05-14");
            Comandante piloto01 = new Comandante("Gallegos Espejo", "Yamil Sebastian", "17-34896124-3", "1980-08-03", 190283);
            CoPiloto copiloto01 = new CoPiloto("Cardozo", "Franco Abel", "21-29878766-0", "1958-10-21", 164863);
            Avion av01= new Avion("LV-CTC", "Boeing 737-800", 182, 1994);
            Vuelo v01 = new Vuelo(1234, "2020-10-12", "08:30", "2020-10-12", "13:21", a01);
            Aeropuerto aero01 = new Aeropuerto("BRC", "Aeropuerto Internacional Teniente Luis Candelaria", "San Carlos de Bariloche", 6480);
            Aeropuerto aero02 = new Aeropuerto("JUJ", "Aeropuerto Internacional Gobernador Horacio Guzman", "San Salvador de Jujuy", 2112);
            //exercise
            a01.clear();
            a01.addComandante(piloto01);
            a01.addCoPiloto(copiloto01);
            a01.addAvion(av01);
            v01.addAeropuertoSalida(aero01);
            v01.addAeropuertoLlegada(aero02);
            ges.addVuelo(v01);
            assertEquals("Id Vuelo: AR 1234, Aerolinea: Aerolineas Argentinas, Aeropuerto Salida:" +
                    " Aeropuerto Internacional Teniente Luis Candelaria, Aeropuerto Llegada: Aeropuerto Internacional Gobernador Horacio Guzman, " +
                    "Fecha de Salida: 2020-10-12, Hora de Salida: 08:30, Fecha de Llegada: 2020-10-12, Hora Llegada: 13:21, " +
                    "Comandante: Gallegos Espejo, Yamil Sebastian, CoPiloto: Cardozo, Franco Abel, Avion: Boeing 737-800",ges.mostrarDatosVuelo());
        } catch (ExceptionAvion exceptionAvion) {
            exceptionAvion.printStackTrace();
        } catch (ExceptionCoPiloto exceptionCoPiloto) {
            exceptionCoPiloto.printStackTrace();
        } catch (ExceptionComandante exceptionComandante) {
            exceptionComandante.printStackTrace();
        } catch (ExceptionAerolinea aerolinea) {
            aerolinea.printStackTrace();
        } catch (ExceptionAeropuerto aeropuerto) {
            aeropuerto.printStackTrace();
        }
    }
}
