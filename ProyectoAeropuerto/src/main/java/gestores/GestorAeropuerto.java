package gestores;

import dominio.Aerolinea;
import dominio.Aeropuerto;

import java.util.ArrayList;

public class GestorAeropuerto {

    private static GestorAeropuerto gesAeropuerto;
    private ArrayList<Aerolinea> misAerolineas;
    private ArrayList<Aeropuerto> misAeropuertos;

    private GestorAeropuerto() {
        this.misAerolineas= new ArrayList<Aerolinea>();
        this.misAeropuertos= new ArrayList<Aeropuerto>();
    }
    public static GestorAeropuerto getInstance() {
        if(gesAeropuerto==null)
            gesAeropuerto= new GestorAeropuerto();
        return gesAeropuerto;
    }


    public boolean AddAerolinea(Aerolinea a01) {
        int condicion=0;
        if (this.misAerolineas.size() == 0)
            misAerolineas.add(a01);
        else
            for (Aerolinea e : misAerolineas)
                if (e.getCUIT().equals(a01.getCUIT()))
                    condicion=1;
        if(condicion==1)
            return false;
        else
            misAerolineas.add(a01);
        return true;
    }

    public boolean addAeropuerto(Aeropuerto a01) {
        int condicion=0;
        if (this.misAeropuertos.size() == 0)
            misAeropuertos.add(a01);
        else
            for (Aeropuerto e : misAeropuertos)
                if (e.getCodigoIata().equals(a01.getCodigoIata()))
                    condicion=1;
        if(condicion==1)
            return false;
        else
            misAeropuertos.add(a01);
        return true;
    }

    public void clear(){
        this.misAeropuertos.clear();
        this.misAeropuertos.clear();
    }
}
