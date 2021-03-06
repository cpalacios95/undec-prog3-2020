package gestores;

import dominio.Avion;
import dominio.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorVuelo {

    private static GestorVuelo gesVuelo;
    private ArrayList<Vuelo> misVuelo;

    private GestorVuelo(){
        this.misVuelo= new ArrayList<Vuelo>();
    }

    public static GestorVuelo getInstance() {
        if(gesVuelo==null)
            gesVuelo= new GestorVuelo();
        return gesVuelo;
    }

    public void clear() {
        misVuelo.clear();
    }


    public boolean addVuelo(Vuelo v01) {
        this.misVuelo.add(v01);
        return true;
    }

    public String mostrarDatosVuelo() {
        int i=0;
        String salida = "";
        for (Vuelo e : this.misVuelo) {
            salida+= "Id Vuelo: "+e.getCodigo()+", Aerolinea: "+e.getMisAerolineas().getNombre()+", Aeropuerto Salida: "+e.getAeropuertoSalida().getNombre()+", Aeropuerto Llegada: "+e.getAeropuertoLlegada().getNombre() +
                    ", Fecha de Salida: "+e.getFechaSal()+", Hora de Salida: "+e.getHoraSal()+", Fecha de Llegada: "+e.getFechaLle()+", Hora Llegada: " +e.getHoraLle()+
                    ", Comandante: "+e.getMisAerolineas().getMisComandantes().get(i).getApellidos()+", "+e.getMisAerolineas().getMisComandantes().get(i).getNombres()+", CoPiloto: "+e.getMisAerolineas().getMisCopilotos().get(i).getApellidos()+", "+e.getMisAerolineas().getMisCopilotos().get(i).getNombres()+", Avion: "+e.getMisAerolineas().getMisAviones().get(i).getModelo();
            i++;
        }
        return salida;
    }

    public ArrayList<Vuelo> buscarVueloPorFechaDeSalida(String s) {
        ArrayList<Vuelo> devolver= new ArrayList<Vuelo>();
        LocalDate fecha= LocalDate.parse(s);
        for (Vuelo e: this.misVuelo){
            if(e.getFechaSal().equals(fecha));
                devolver.add(e);
        }
        return devolver;
    }

    public ArrayList<Vuelo> buscarVueloPorFechaDeLlegada(String s) {
        ArrayList<Vuelo> devolver= new ArrayList<Vuelo>();
        LocalDate fecha= LocalDate.parse(s);
        for (Vuelo e: this.misVuelo){
            if(e.getFechaLle().equals(fecha));
            devolver.add(e);
        }
        return devolver;
    }

}
