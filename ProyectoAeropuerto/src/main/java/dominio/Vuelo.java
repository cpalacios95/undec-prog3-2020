package dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo {

    private String codigo;
    private LocalTime horaSal;
    private LocalTime horaLle;
    private LocalDate fechaSal;
    private LocalDate fechaLle;
    private Aerolinea miAerolinea;
    private Aeropuerto aeropuertoSalida;
    private Aeropuerto aeropuertoLlegada;

    public Vuelo(int i, String s, String s1, String s2, String s3, Aerolinea a01) {
        this.miAerolinea=a01;
        this.codigo=miAerolinea.getCodigoIata()+" "+i;
        this.fechaSal= LocalDate.parse(s);
        this.horaSal= LocalTime.parse(s1);
        this.fechaLle= LocalDate.parse(s2);
        this.horaLle= LocalTime.parse(s3);
    }


    public void addAeropuertoSalida(Aeropuerto aero01) {
        this.aeropuertoSalida=aero01;
    }

    public void addAeropuertoLlegada(Aeropuerto aero02) {
        this.aeropuertoLlegada=aero02;
    }


    public String getCodigo() {
        return codigo;
    }

    public LocalTime getHoraSal() {
        return horaSal;
    }

    public LocalTime getHoraLle() {
        return horaLle;
    }

    public LocalDate getFechaSal() {
        return fechaSal;
    }

    public LocalDate getFechaLle() {
        return fechaLle;
    }

    public Aerolinea getMisAerolineas() {
        return miAerolinea;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public void addAerolinea(Aerolinea a01) {
        this.miAerolinea= a01;
    }
}
