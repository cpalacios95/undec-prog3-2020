package gestores;

import dominio.*;

import java.util.ArrayList;

public class GestorAerolinea {
    private static GestorAerolinea gesAerolinea;
    private ArrayList<Vuelo> misVuelos;
    private ArrayList<Comandante> misComandantes;
    private ArrayList<CoPiloto> misCoPilotos;
    private ArrayList<Avion> misAviones;

    private GestorAerolinea() {
        this.misComandantes= new ArrayList<Comandante>();
        this.misCoPilotos=new ArrayList<CoPiloto>();
        this.misVuelos=new ArrayList<Vuelo>();
        this.misAviones= new ArrayList<Avion>();
    }

    public static GestorAerolinea getInstance() {
        if(gesAerolinea==null)
            gesAerolinea= new GestorAerolinea();
        return gesAerolinea;
    }

    public void clear() {
        misComandantes.clear();
        misCoPilotos.clear();
        misVuelos.clear();
        misAviones.clear();
    }

    public boolean addVuelo(dominio.Vuelo v01) {
        if(this.misVuelos.contains(v01))
            return false;
        else
            return true;
    }

    public boolean addComandante(Comandante c01) {
        int condicion = 0;
        if (this.misComandantes.size() == 0)
            misComandantes.add(c01);
        else
            for (Comandante e : misComandantes)
                if (e.getCUIL().equals(c01.getCUIL()))
                    condicion = 1;
        if (condicion == 1)
            return false;
        else
            misComandantes.add(c01);
        return true;
    }

    public boolean addCoPioloto(CoPiloto c01) {
        int condicion = 0;
        if (this.misCoPilotos.size() == 0)
            misCoPilotos.add(c01);
        else
            for (CoPiloto e : misCoPilotos)
                if (e.getCUIL().equals(c01.getCUIL()))
                    condicion = 1;
        if (condicion == 1)
            return false;
        else
            misCoPilotos.add(c01);
        return true;
    }

    public boolean addAvion(Avion a01) {
        int condicion = 0;
        if (this.misAviones.size() == 0)
            misAviones.add(a01);
        else
            for (Avion e : misAviones)
                if (e.getMatricula().equals(a01.getMatricula()))
                    condicion = 1;
        if (condicion == 1)
            return false;
        else
            misAviones.add(a01);
        return true;
    }
}
